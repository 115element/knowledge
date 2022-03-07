package com.example.juc.typical.cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

//CyclicBarrier可以重复使用
//CyclicBarrier 是所有线程都进行等待，直到所有线程都准备好进入 await()方法之后，所有线程同时开始执行！

/**
 * CountDownLatch 的计数器只能使用一次。而 CyclicBarrier 的计数器可以使
 * 用 reset() 方法重置。所以 CyclicBarrier 能处理更为复杂的业务场景，比如如果
 * 计算发生错误，可以重置计数器，并让线程们重新执行一次。
 *
 * CyclicBarrier 还提供其他有用的方法，比如 getNumberWaiting 方法可以获
 * 得 CyclicBarrier 阻塞的线程数量。isBroken 方法用来知道阻塞的线程是否被中断。
 * 如果被中断返回 true，否则返回 false。
 */

public class CyclicBarrierStudy {

    final static CyclicBarrier cb = new CyclicBarrier(3, () -> {
        System.out.println("三人都已经到达会议室");
    });

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
                System.out.println("A等待其他人到达...");
                cb.await();
                System.out.println("=");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(4);
                System.out.println("B等待其他人到达...");
                cb.await();
                System.out.println("=");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
                System.out.println("C等待其他人到达...");
                cb.await();
                System.out.println("=");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
