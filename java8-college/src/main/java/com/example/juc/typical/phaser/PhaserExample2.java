package com.example.juc.typical.phaser;

import java.util.Random;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * 使用Phaser设置多个阶段
 * 这边使用的案例是运动员，模拟多个运动员参加多个项目。
 */

public class PhaserExample2 {

    private static final Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) {
        //初始化5个parties
        Phaser phaser = new Phaser(5);
        for (int i = 0; i < 6; i++) {
            new Athlete(phaser, i).start();
        }
    }


    private static class Athlete extends Thread {
        private Phaser phaser;
        private int no; //运动员编号

        public Athlete(Phaser phaser, int no) {
            this.phaser = phaser;
            this.no = no;
        }

        @Override
        public void run() {
            try {
                System.out.println(no + "：当前处于第：" + phaser.getPhase() + "阶段");
                System.out.println(no + "：start running");
                TimeUnit.SECONDS.sleep(random.nextInt(5));
                System.out.println(no + "：end running");
                //等待其他运动员完成跑步
                phaser.arriveAndAwaitAdvance();


                System.out.println(no + "：当前处于第：" + phaser.getPhase() + "阶段");
                System.out.println(no + "：start bicycle");
                TimeUnit.SECONDS.sleep(random.nextInt(5));
                System.out.println(no + "：end bicycle");
                //等待其他运动员完成骑行
                phaser.arriveAndAwaitAdvance();


                System.out.println(no + "：当前处于第：" + phaser.getPhase() + "阶段");
                System.out.println(no + "：start long jump");
                TimeUnit.SECONDS.sleep(random.nextInt(5));
                System.out.println(no + "：end long jump");
                //等待其他运动员完成跳远
                phaser.arriveAndAwaitAdvance();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
