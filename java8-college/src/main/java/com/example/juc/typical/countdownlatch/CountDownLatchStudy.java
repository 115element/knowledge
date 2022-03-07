package com.example.juc.typical.countdownlatch;

import java.util.concurrent.CountDownLatch;

//CountDownLatch只能使用一次
//CountDownLatch 简单的说就是一个线程等待，直到他所等待的其他线程都执行完成并且调用 countDown()方法发出通知后，当前线程才可以继续执行。

/**
 * CountDownLatch 的计数器只能使用一次。而 CyclicBarrier 的计数器可以使
 * 用 reset() 方法重置。所以 CyclicBarrier 能处理更为复杂的业务场景，比如如果
 * 计算发生错误，可以重置计数器，并让线程们重新执行一次。
 *
 * CyclicBarrier 还提供其他有用的方法，比如 getNumberWaiting 方法可以获
 * 得 CyclicBarrier 阻塞的线程数量。isBroken 方法用来知道阻塞的线程是否被中断。
 * 如果被中断返回 true，否则返回 false。
 */
public class CountDownLatchStudy {

    final static CountDownLatch latch = new CountDownLatch(50);

    public static void main(String[] args) {
        ThreadOne threadOne = new ThreadOne(latch);
        for (int i = 0; i < 50; i++) {
            new Thread(threadOne).start();
        }

        try {
            //todo 会等待上面50个线程结束，才执行
            latch.await();
            System.out.println("人齐了");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


class ThreadOne implements Runnable {
    private CountDownLatch latch;

    public ThreadOne(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 100000; i++) {
                if (i % 2 == 0) {
                    System.out.println(i);
                }
            }
        } finally {
            //让CountDownLatch维护的计数器减1
            latch.countDown();
        }
    }
}