package com.example.juc.typical.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;


//awaitAdvance演示
public class PhaserExample5 {

    private final static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        //初始化5个Parties
        Phaser phaser = new Phaser(5);

        //创建5个任务
        IntStream.rangeClosed(1, 5).forEach(i -> new ArrayTask(i, phaser).start());

        //当Phaser中当前阶段等于传入的阶段则该方法会阻塞，反之不会
        int phase = phaser.getPhase();
        System.out.println("Phase:" + phase);
        phaser.awaitAdvance(phase);
        System.out.println("All work finished");
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
                System.out.println(getName() + " start working");
                TimeUnit.SECONDS.sleep(random.nextInt(3));
                System.out.println(getName() + " end working");
                phaser.arriveAndDeregister();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
