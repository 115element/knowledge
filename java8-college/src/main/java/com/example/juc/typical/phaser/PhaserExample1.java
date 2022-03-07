package com.example.juc.typical.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;


/**
 * 类Phaser 提供了动态增减parties计数，这点比CyclicBarrier类操作parties更加方便，
 * 通过若干个方法来控制多个线程之间同步运行的效果，还可以实现针对某一个线程取消同步运行的效果，而且支持在指定屏障处等待，
 * 在等待的同时还支持中断或者非中断等功能，使用java并发类对线程进行分组同步控制的时候，Phaser比CyclicBarrier类更加强大，建议使用。
 */

//等待其他线程执行到某个阶段

public class PhaserExample1 {

    private static final Random random = new Random(System.currentTimeMillis());


    public static void main(String[] args) {
        Phaser phaser = new Phaser();
        //创建5个任务
        for (int i = 0; i < 5; i++) {
            new Thread1(phaser).start();
        }
        //动态注册
        phaser.register();
        //等待其他线程完成工作
        phaser.arriveAndAwaitAdvance();
        System.out.println("All of worker finished the task");
    }


    private static class Thread1 extends Thread {
        private Phaser phaser;

        public Thread1(Phaser phaser) {
            this.phaser = phaser;
            //动态注册任务
            this.phaser.register();
        }

        @Override
        public void run() {
            try {
                System.out.println("The Thread [" + getName() + "] is working");
                TimeUnit.SECONDS.sleep(random.nextInt(5));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("The Thread [" + getName() + "] is finished");
            //等待其他线程完成工作
            phaser.arriveAndAwaitAdvance();
        }
    }

}
