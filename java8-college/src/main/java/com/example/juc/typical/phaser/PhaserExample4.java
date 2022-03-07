package com.example.juc.typical.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

//利用arrive只监听线程完成第一部分任务

public class PhaserExample4 {

    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        //初始化6个Parties
        Phaser phaser = new Phaser(6);
        //创建5个任务
        IntStream.rangeClosed(1, 5).forEach(i -> new ArrayTask(i, phaser).start());

        //等待5个任务的第一部分完成
        phaser.arriveAndAwaitAdvance();
        System.out.println("all work finished");
    }

    private static class ArrayTask extends Thread {
        private Phaser phaser;

        public ArrayTask(int name, Phaser phaser) {
            super(String.valueOf(name));
            this.phaser = phaser;
        }

        @Override
        public void run() {
            try {
                //模拟第一部分工作
                System.out.println(getName() + "start working");
                TimeUnit.SECONDS.sleep(random.nextInt(3));
                System.out.println(getName() + "end working");
                //该方法表示到达但不会使线程阻塞
                phaser.arrive();

                //模拟第二部分工作
                TimeUnit.SECONDS.sleep(random.nextInt(3));
                System.out.println(getName() + "do other thing");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
