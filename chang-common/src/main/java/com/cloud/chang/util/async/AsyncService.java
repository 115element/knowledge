package com.cloud.chang.util.async;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import java.util.concurrent.locks.ReentrantLock;

import com.cloud.chang.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

  private static Logger log = LoggerFactory.getLogger(AsyncService.class);

  private Map<String, LinkedBlockingQueue<AsyncTask>> queueMap =
      new HashMap<String, LinkedBlockingQueue<AsyncTask>>();

  // every entity thread
  private int defaultThreadNum = 3;
  // unite: second
  private int queuePullTimeout = 10;

  private static ReentrantLock LOCK = new ReentrantLock();

  private List<TaskHold> threadHoldList = new ArrayList<TaskHold>();

  @PostConstruct
  private void init() throws Exception {

  }

  public void asyncRun(AsyncTask task) {
    TaskRun run = new TaskRun(task);
    Thread t = new Thread(run);
    t.start();
  }

  public void addTask(AsyncTask task) {
    try {
      String queueKey = task.getClass().getName();
      if (queueMap.containsKey(queueKey)) {
        LinkedBlockingQueue<AsyncTask> queue = queueMap.get(queueKey);
        queue.offer(task);
        log.debug("add to queueKey[" + queueKey + "]");
      } else {
        LOCK.lock();
        try {
          if (!queueMap.containsKey(queueKey)) {
            LinkedBlockingQueue<AsyncTask> queue = new LinkedBlockingQueue<AsyncTask>();
            queue.offer(task);
            queueMap.put(queueKey, queue);
            log.debug("add to queueKey[" + queueKey + "]");
            reStartThread();
          } else {
            LinkedBlockingQueue<AsyncTask> queue = queueMap.get(queueKey);
            queue.offer(task);
            log.debug("add to queueKey[" + queueKey + "]");
          }
        } finally {
          LOCK.unlock();
        }
      }
    } catch (Throwable e) {
      log.error("addTask error", e);
    }
  }

  private void reStartThread() {
    for (int i = 0; i < threadHoldList.size(); i++) {
      TaskHold hold = threadHoldList.get(i);
      hold.stop();
    }
    Set<String> classNames = queueMap.keySet();
    for (final String className : classNames) {
      for (int i = 0; i < defaultThreadNum; i++) {
        LinkedBlockingQueue<AsyncTask> queue = queueMap.get(className);
        TaskHold hold = new TaskHold(queue, queuePullTimeout);
        threadHoldList.add(hold);
        Thread t = new Thread(hold);
        t.start();
        log.debug("start queue[" + className + "][" + i + "]");
      }
    }
  }

  public static Class<?> loadClass(String classpath) {
    try {
      return Util.class.getClassLoader().loadClass(classpath);
    } catch (ClassNotFoundException e) {
      throw new RuntimeException(e);
    }
  }


  public static Object newInstance(Class<?> clazz) {
    try {
      return clazz.newInstance();
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  public static Object newInstance(String clazz) {
    return newInstance(loadClass(clazz));
  }

}


class TaskHold implements Runnable {

  private static Logger log = LoggerFactory.getLogger(TaskHold.class);

  private boolean stop = false;


  private LinkedBlockingQueue<AsyncTask> queue;

  private int queuePullTimeout = 10;

  public TaskHold(LinkedBlockingQueue<AsyncTask> queue, int queuePullTimeout) {
    this.queue = queue;
    this.queuePullTimeout = queuePullTimeout;
  }

  @Override
  public void run() {
    while (true) {
      if (this.stop) {
        break;
      }
      try {
        AsyncTask task = queue.poll(queuePullTimeout, TimeUnit.SECONDS);
        if (task != null) {
          try {
            Object result = task.run();
            task.callback(result);
          } catch (Throwable e) {
            log.error(e.getMessage(), e);
            task.callback(null, e);
          }
        }
      } catch (Throwable e1) {
        log.error(e1.getMessage(), e1);
      }
    }
  }

  public void stop() {
    this.stop = true;
  }

}


class TaskRun implements Runnable {

  private static Logger log = LoggerFactory.getLogger(TaskRun.class);

  private AsyncTask task;

  public TaskRun(AsyncTask task) {
    this.task = task;
  }

  @Override
  public void run() {
    try {
      Object result = task.run();
      task.callback(result);
    } catch (Throwable e) {
      log.error(e.getMessage(), e);
      task.callback(null, e);
    }
  }

}
