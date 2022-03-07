package com.fiber_thread.fiber;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;
import co.paralleluniverse.strands.SuspendableRunnable;

import java.util.concurrent.ExecutionException;

//首先像前面说的那样，java 原生没有提供纤程支持，需要依赖于 Quasar的库，所以需要将依赖包，通过pom.xml导入到本地仓库
// 纤程：是用户态的线程，是线程中的线程，切换和调度不需要经过OS(操作系统)。；轻量级的线程 - 线程
public class HelloFiber {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start = System.currentTimeMillis();
        int size = 10000;

        Fiber<Void>[] fibers = new Fiber[size];
        for (int i = 0; i < fibers.length; i++) {
            fibers[i] = new Fiber<Void>(new SuspendableRunnable() {
                @Override
                public void run() throws SuspendExecution, InterruptedException {
                    calc();
                }
            });
        }

        for (int i = 0; i < fibers.length; i++) {
            fibers[i].start();
        }

        for (int i = 0; i < fibers.length; i++) {
            fibers[i].join();
            /*
             * Thread之三：Thread Join()的用法
             * join()的使用场景
             *
             * ①在很多情况下，主线程创建并启动子线程，如果子线程中要进行大量的耗时运算，主线程将可能早于子线程结束。
             * 如果主线程需要知道子线程的执行结果时，就需要等待子线程执行结束了。主线程可以sleep(xx),但这样的xx时间不好确定，
             * 因为子线程的执行时间不确定，join()方法比较合适这个场景。
             *
             * ②解释一下，是主线程等待子线程的终止。也就是说主线程的代码块中，如果碰到了t.join()方法，
             * 此时主线程需要等待（阻塞），等待子线程结束了(Waits for this thread to die.),才能继续执行t.join()之后的代码块。
             */
        }

        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }

    private static void calc() {
        int result = 0;
        for (int m = 0; m < 10000; m++) {
            for (int i = 0; i < 200; i++) {
                result += i;
            }
        }
    }
}
