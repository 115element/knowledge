package com.cloud.chang.util.seda;

import com.cloud.chang.util.concurrent.UnitedThreadFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.HashSet;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Stage extends AbstractStageService {
    private static final Logger log = LoggerFactory.getLogger(Stage.class);
    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY = (1 << COUNT_BITS) - 1;

    private static final int RUNNING = -1 << COUNT_BITS;
    private static final int SHUTDOWN = 0 << COUNT_BITS;
    private static final int STOP = 1 << COUNT_BITS;
    private static final int TIDYING = 2 << COUNT_BITS;
    private static final int TERMINATED = 3 << COUNT_BITS;

    private static int runStateOf(int c) {
        return c & ~CAPACITY;
    }

    private static int workerCountOf(int c) {
        return c & CAPACITY;
    }

    private static int ctlOf(int rs, int wc) {
        return rs | wc;
    }

    private static boolean runStateLessThan(int c, int s) {
        return c < s;
    }

    private static boolean runStateAtLeast(int c, int s) {
        return c >= s;
    }

    private static boolean isRunning(int c) {
        return c < SHUTDOWN;
    }

    private boolean compareAndIncrementWorkerCount(int expect) {
        return ctl.compareAndSet(expect, expect + 1);
    }

    private boolean compareAndDecrementWorkerCount(int expect) {
        return ctl.compareAndSet(expect, expect - 1);
    }

    private void decrementWorkerCount() {
        do {
        } while (!compareAndDecrementWorkerCount(ctl.get()));
    }

    private final TimeUnit unit = TimeUnit.SECONDS;
    private final BlockingQueue<StageTask> workQueue;
    private final HashSet<Worker> workers = new HashSet<>();
    private final ReentrantLock mainLock = new ReentrantLock();
    private final Condition termination = mainLock.newCondition();
    private final ThreadFactory threadFactory;
    private final StageRejected handler;
    private final boolean elas;
    private final String name;
    private final Bus bus;

    private int largestPoolSize;
    private long completedTaskCount;
    private volatile int corePoolSize;
    private volatile long keepAliveTime;
    private volatile int maximumPoolSize;
    private final AccessControlContext acc;
    private volatile boolean allowCoreThreadTimeOut;
    private static final RuntimePermission shutdownPerm = new RuntimePermission("modifyThread");

    // ????????????????????????,???????????????
    public Stage(int core, int max, long keepAlive, String name, Bus bus) {
        this(core, max, keepAlive, true, name, bus);
    }

    public Stage(int core, int max, long keepAlive, boolean elas, String name, Bus bus) {
        if (core < 0 || max <= 0 || max < core || keepAlive < 0) {
            throw new IllegalArgumentException();
        }
        if (unit == null || name == null || bus == null) {
            throw new NullPointerException();
        }
        this.bus = bus;
        this.elas = elas;
        this.acc = System.getSecurityManager() == null ? null : AccessController.getContext();
        this.corePoolSize = core;
        this.maximumPoolSize = max;
        // ???????????????????????????
        if (elas) {
            this.workQueue = new SynchronousQueue<>();
        } else {
            this.workQueue = new LinkedBlockingQueue<>();
        }
        this.keepAliveTime = unit.toNanos(keepAlive);
        this.name = name;
        this.threadFactory = UnitedThreadFactory.create(name);
        // ????????????????????????????????????????????????
        this.handler = new DirectFail();
    }

    // ?????????worker?????????runnable?????????start??????
    // ?????????????????????????????????runWorker
    // ?????????????????????????????????runnable?????????firstTask???????????????????????????
    // ?????????????????????stage?????????
    // ????????????????????????future??????????????????????????????????????????future????????????
    private final class Worker extends AbstractQueuedSynchronizer implements Runnable {
        //private static final long serialVersionUID = 6138294804551838833L;
        final Thread thread;
        StageTask firstTask;
        volatile long completedTasks;

        Worker(StageTask firstTask) {
            setState(-1);
            this.firstTask = firstTask;
            this.thread = getThreadFactory().newThread(this);
        }

        @Override
        public void run() {
            runWorker(this);
        }

        protected boolean isHeldExclusively() {
            return getState() != 0;
        }

        protected boolean tryAcquire(int unused) {
            if (compareAndSetState(0, 1)) {
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            } else {
                return false;
            }
        }

        protected boolean tryRelease(int unused) {
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        public void lock() {
            acquire(1);
        }

        public boolean tryLock() {
            return tryAcquire(1);
        }

        public void unlock() {
            release(1);
        }

        public boolean isLocked() {
            return isHeldExclusively();
        }

        void interruptIfStarted() {
            Thread t;
            if (getState() >= 0 && (t = thread) != null && !t.isInterrupted()) {
                workerInterrupt(t, "Worker.interruptIfStarted");
            }
        }

        void workerInterrupt(Thread t, String callFrom) {
            if (null == t) {
                log.error("thread null, callFrom=" + callFrom);
                return;
            }
            try {
                t.interrupt();
            } catch (SecurityException ignore) {
                log.error(ignore.toString() + ", callFrom=" + callFrom, ignore);
            } catch (Throwable te) {
                log.error(te.toString() + ", callFrom=" + callFrom, te);
            }
        }
    }

    private ThreadFactory getThreadFactory() {
        return threadFactory;
    }

    private void advanceRunState(int targetState) {
        for (; ; ) {
            int c = ctl.get();
            if (runStateAtLeast(c, targetState)) {
                break;
            } else if (ctl.compareAndSet(c, ctlOf(targetState, workerCountOf(c)))) {
                break;
            }
        }
    }

    private final void tryTerminate() {
        for (; ; ) {
            int c = ctl.get();
            if (isRunning(c)) {
                return;
            } else if (runStateAtLeast(c, TIDYING)) {
                return;
            } else if ((runStateOf(c) == SHUTDOWN && !workQueue.isEmpty())) {
                return;
            }
            if (workerCountOf(c) != 0) {
                interruptIdleWorkers(ONLY_ONE);
                return;
            }
            final ReentrantLock lock = this.mainLock;
            lock.lock();
            try {
                if (ctl.compareAndSet(c, ctlOf(TIDYING, 0))) {
                    try {
                        terminated();
                    } finally {
                        ctl.set(ctlOf(TERMINATED, 0));
                        termination.signalAll();
                    }
                    return;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    private void checkShutdownAccess() {
        SecurityManager security = System.getSecurityManager();
        if (security != null) {
            security.checkPermission(shutdownPerm);
            final ReentrantLock lock = this.mainLock;
            lock.lock();
            try {
                for (Worker w : workers)
                    security.checkAccess(w.thread);
            } finally {
                lock.unlock();
            }
        }
    }

    private void interruptIdleWorkers(boolean onlyOne) {
        final ReentrantLock lock = this.mainLock;
        lock.lock();
        try {
            for (Worker w : workers) {
                Thread t = w.thread;
                if (!t.isInterrupted() && w.tryLock()) {
                    try {
                        w.workerInterrupt(t, "Stage.interruptIdleWorkers");
                    } finally {
                        w.unlock();
                    }
                }
                if (onlyOne) {
                    break;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    private void interruptIdleWorkers() {
        interruptIdleWorkers(false);
    }

    // ????????????????????????????????????shutDown???????????????????????????????????????????????????????????????
    private void interruptWorkers() {
        final ReentrantLock lock = this.mainLock;
        lock.lock();
        try {
            for (Worker w : workers)
                w.interruptIfStarted();
        } finally {
            lock.unlock();
        }
    }

    private static final boolean ONLY_ONE = true;

    @Override
    public boolean execute(StageTask task) {
        if (task == null) {
            return false;
        }
        int c = ctl.get();
        // ??????????????????????????????????????????????????????????????????
        if (workerCountOf(c) < corePoolSize) {
            if (addWorker(task, true)) {
                return true;
            } else {
                // ??????????????????????????????????????????
                c = ctl.get();
            }
        }
        // ???????????????sync????????????
        // ????????????????????????
        // ??????????????????????????????????????????????????????
        if (isRunning(c) && workQueue.offer(task)) {
            int recheck = ctl.get();
            // ??????????????????remove
            if (!isRunning(recheck)) {
                // ??????????????????????????????????????????
                if (!elas && remove(task)) {
                    reject(task);
                    return false;
                } else {
                    // ???????????????????????????????????????
                    // ???????????????????????????????????????????????????
                    tryTerminate();
                    return true;
                }
            } else if (workerCountOf(recheck) == 0) {
                addWorker(null, false);
                return true;
            } else {
                // ?????????????????????????????????????????????
                return true;
            }
        } else if (!addWorker(task, false)) {
            reject(task);
            return false;
        } else {
            // ?????????????????????????????????????????????
            return true;
        }
    }

    private boolean remove(StageTask task) {
        boolean removed = workQueue.remove(task);
        tryTerminate();
        return removed;
    }

    // ????????????????????????task??????null
    // ??????????????????????????????????????????????????????
    private final boolean addWorker(StageTask firstTask, boolean core) {
        retry:
        for (; ; ) {
            int c = ctl.get();
            int rs = runStateOf(c);
            if (rs >= SHUTDOWN && !(rs == SHUTDOWN && firstTask == null && !workQueue.isEmpty())) {
                return false;
            }
            for (; ; ) {
                int wc = workerCountOf(c);
                if (wc >= CAPACITY) {
                    return false;
                } else if (wc >= (core ? corePoolSize : maximumPoolSize)) {
                    return false;
                }
                if (compareAndIncrementWorkerCount(c)) {
                    break retry;
                }
                c = ctl.get();
                if (runStateOf(c) != rs) {
                    continue retry;
                }
            }
        }
        boolean workerStarted = false;
        boolean workerAdded = false;
        Worker w = null;
        try {
            w = new Worker(firstTask);
            final Thread t = w.thread;
            if (t != null) {
                final ReentrantLock lock = this.mainLock;
                lock.lock();
                try {
                    int rs = runStateOf(ctl.get());
                    if (rs < SHUTDOWN || (rs == SHUTDOWN && firstTask == null)) {
                        if (t.isAlive()) {
                            // ????????????????????????????????????????????????????????????????????????false???
                            // ?????????????????????????????????????????????????????????
                            log.error("new Worker Thread isAlive, stage task=" + firstTask);
                            throw new IllegalThreadStateException();
                        }
                        workers.add(w);
                        int s = workers.size();
                        if (s > largestPoolSize) {
                            largestPoolSize = s;
                        }
                        workerAdded = true;
                    }
                } finally {
                    lock.unlock();
                }
                if (workerAdded) {
                    t.start();
                    workerStarted = true;
                }
            }
        } finally {
            if (!workerStarted) {
                addWorkerFailed(w);
            }
        }
        return workerStarted;
    }

    private void addWorkerFailed(Worker w) {
        final ReentrantLock lock = this.mainLock;
        lock.lock();
        try {
            if (w != null) {
                workers.remove(w);
            }
            decrementWorkerCount();
            tryTerminate();
        } finally {
            lock.unlock();
        }
    }

    private final void runWorker(Worker w) {
        // ?????????thread??????worker??????thread
        Thread wt = Thread.currentThread();
        StageTask task = w.firstTask;
        w.firstTask = null;
        w.unlock();
        boolean completedAbruptly = true;
        try {
            while (task != null || (task = getTask()) != null) {
                w.lock();
                if ((runStateAtLeast(ctl.get(), STOP) || (Thread.interrupted() &&
                        runStateAtLeast(ctl.get(), STOP))) && !wt.isInterrupted()) {
                    wt.interrupt();
                }
                try {
                    beforeExecute(wt, task);
                    Throwable thrown = null;
                    try {
                        task.task(bus);
                    } catch (RuntimeException x) {
                        thrown = x;
                        throw x;
                    } catch (Error x) {
                        thrown = x;
                        throw x;
                    } catch (Throwable x) {
                        thrown = x;
                        throw new Error(x);
                    } finally {
                        afterExecute(task, thrown);
                    }
                } finally {
                    task = null;
                    w.completedTasks++;
                    w.unlock();
                }
            }
            completedAbruptly = false;
        } finally {
            processWorkerExit(w, completedAbruptly);
        }
    }

    private final StageTask getTask() {
        boolean timedOut = false;
        for (; ; ) {
            int c = ctl.get();
            int rs = runStateOf(c);
            if (rs >= SHUTDOWN && (rs >= STOP || workQueue.isEmpty())) {
                decrementWorkerCount();
                return null;
            }
            int wc = workerCountOf(c);
            boolean timed = allowCoreThreadTimeOut || wc > corePoolSize;
            if ((wc > maximumPoolSize || ((timed && timedOut)) && (wc > 1 || workQueue.isEmpty()))) {
                if (compareAndDecrementWorkerCount(c)) {
                    return null;
                } else {
                    continue;
                }
            }
            try {
                StageTask r = timed ? workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) : workQueue.take();
                if (r != null) {
                    return r;
                } else {
                    timedOut = true;
                }
            } catch (InterruptedException retry) {
                timedOut = false;
            }
        }
    }

    private final void processWorkerExit(Worker w, boolean completedAbruptly) {
        if (completedAbruptly) {
            decrementWorkerCount();
        }
        final ReentrantLock lock = this.mainLock;
        lock.lock();
        try {
            completedTaskCount += w.completedTasks;
            workers.remove(w);
        } finally {
            lock.unlock();
        }
        tryTerminate();
        int c = ctl.get();
        if (runStateLessThan(c, STOP)) {
            if (!completedAbruptly) {
                int min = allowCoreThreadTimeOut ? 0 : corePoolSize;
                // ??????????????????????????????????????????????????????????????????????????????0??????????????????????????????
                if (min == 0 && !workQueue.isEmpty()) {
                    min = 1;
                }
                if (workerCountOf(c) >= min) {
                    return;
                }
            }
            // ???????????????????????????????????????????????????submit??????????????????????????????
            // ?????????????????????????????????????????????????????????????????????????????????
            addWorker(null, false);
        }
    }

    private final void reject(StageTask command) {
        handler.reject(command, this, name);
    }

    // ???????????????????????????shutDown?????????shutDownNow??????
    // ????????????????????????????????????
    @Override
    public void shutdown() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            checkShutdownAccess();
            advanceRunState(SHUTDOWN);
            interruptIdleWorkers();
            onShutdown();
        } finally {
            mainLock.unlock();
        }
        tryTerminate();
    }

    @Override
    public boolean isShutdown() {
        return !isRunning(ctl.get());
    }

    public boolean isTerminating() {
        int c = ctl.get();
        return !isRunning(c) && runStateLessThan(c, TERMINATED);
    }

    @Override
    public boolean isTerminated() {
        return runStateAtLeast(ctl.get(), TERMINATED);
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long nanos = unit.toNanos(timeout);
        final ReentrantLock lock = this.mainLock;
        lock.lock();
        try {
            for (; ; ) {
                if (runStateAtLeast(ctl.get(), TERMINATED)) {
                    return true;
                }
                if (nanos <= 0) {
                    return false;
                }
                nanos = termination.awaitNanos(nanos);
            }
        } finally {
            lock.unlock();
        }
    }

    protected final void finalize() {
        SecurityManager sm = System.getSecurityManager();
        if (sm == null || acc == null) {
            shutdown();
        } else {
            PrivilegedAction<Void> pa = () -> {
                shutdown();
                return null;
            };
            AccessController.doPrivileged(pa, acc);
        }
    }

    public void setCorePoolSize(int corePoolSize) {
        if (corePoolSize < 0) {
            throw new IllegalArgumentException();
        }
        int delta = corePoolSize - this.corePoolSize;
        this.corePoolSize = corePoolSize;
        if (workerCountOf(ctl.get()) > corePoolSize) {
            interruptIdleWorkers();
        } else if (delta > 0) {
            int k = Math.min(delta, workQueue.size());
            while (k-- > 0 && addWorker(null, true)) {
                if (workQueue.isEmpty()) {
                    break;
                }
            }
        }
    }

    public int getCorePoolSize() {
        return corePoolSize;
    }

    public boolean prestartCoreThread() {
        return workerCountOf(ctl.get()) < corePoolSize &&
                addWorker(null, true);
    }

    public int prestartAllCoreThreads() {
        int n = 0;
        while (addWorker(null, true))
            ++n;
        return n;
    }

    public boolean allowsCoreThreadTimeOut() {
        return allowCoreThreadTimeOut;
    }

    public void allowCoreThreadTimeOut(boolean value) {
        if (value && keepAliveTime <= 0) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        if (value != allowCoreThreadTimeOut) {
            allowCoreThreadTimeOut = value;
            if (value) {
                interruptIdleWorkers();
            }
        }
    }

    public void setMaximumPoolSize(int maximumPoolSize) {
        if (maximumPoolSize <= 0 || maximumPoolSize < corePoolSize) {
            throw new IllegalArgumentException();
        }
        this.maximumPoolSize = maximumPoolSize;
        if (workerCountOf(ctl.get()) > maximumPoolSize) {
            interruptIdleWorkers();
        }
    }

    public int getMaximumPoolSize() {
        return maximumPoolSize;
    }

    public void setKeepAliveTime(long time, TimeUnit unit) {
        if (time < 0) {
            throw new IllegalArgumentException();
        }
        if (time == 0 && allowsCoreThreadTimeOut()) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        long keepAliveTime = unit.toNanos(time);
        long delta = keepAliveTime - this.keepAliveTime;
        this.keepAliveTime = keepAliveTime;
        if (delta < 0) {
            interruptIdleWorkers();
        }
    }

    public long getKeepAliveTime(TimeUnit unit) {
        return unit.convert(keepAliveTime, TimeUnit.NANOSECONDS);
    }

    // ??????????????????????????????????????????
    public void purge() {
        tryTerminate();
    }

    public int getPoolSize() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            return runStateAtLeast(ctl.get(), TIDYING) ? 0
                    : workers.size();
        } finally {
            mainLock.unlock();
        }
    }

    public int getActiveCount() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            int n = 0;
            for (Worker w : workers)
                if (w.isLocked()) {
                    ++n;
                }
            return n;
        } finally {
            mainLock.unlock();
        }
    }

    public int getLargestPoolSize() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            return largestPoolSize;
        } finally {
            mainLock.unlock();
        }
    }

    public long getTaskCount() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            long n = completedTaskCount;
            for (Worker w : workers) {
                n += w.completedTasks;
                if (w.isLocked()) {
                    ++n;
                }
            }
            return n + workQueue.size();
        } finally {
            mainLock.unlock();
        }
    }

    public long getCompletedTaskCount() {
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            long n = completedTaskCount;
            for (Worker w : workers)
                n += w.completedTasks;
            return n;
        } finally {
            mainLock.unlock();
        }
    }

    public String toString() {
        long ncompleted;
        int nworkers, nactive;
        final ReentrantLock mainLock = this.mainLock;
        mainLock.lock();
        try {
            ncompleted = completedTaskCount;
            nactive = 0;
            nworkers = workers.size();
            for (Worker w : workers) {
                ncompleted += w.completedTasks;
                if (w.isLocked()) {
                    ++nactive;
                }
            }
        } finally {
            mainLock.unlock();
        }
        int c = ctl.get();
        String rs = (runStateLessThan(c, SHUTDOWN) ? "Running" :
                (runStateAtLeast(c, TERMINATED) ? "Terminated" :
                        "Shutting down"));
        return super.toString() +
                "[" + rs +
                ", pool size = " + nworkers +
                ", active threads = " + nactive +
                ", queued tasks = " + workQueue.size() +
                ", completed tasks = " + ncompleted +
                "]";
    }

    protected void beforeExecute(Thread t, StageTask r) {

    }

    protected void afterExecute(StageTask r, Throwable t) {
        if (null == t) {
            return;
        } else {
            log.error("occur error=" + t.toString() + ", stage task=" + r, t);
            // ???????????????bus?????????????????????????????????????????????
        }
    }

    protected void terminated() {

    }

    protected void onShutdown() {
    }

    public static class DirectFail implements StageRejected {

        public DirectFail() {

        }

        @Override
        public void reject(StageTask r, StageExecutor e, String reason) {
            log.error("rejected stage task=" + r + ", stage name=" + reason);
        }

    }

}