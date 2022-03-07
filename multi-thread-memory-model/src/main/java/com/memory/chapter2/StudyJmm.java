package com.memory.chapter2;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class StudyJmm {

    public static Object o = new Object();

    public static void main(String[] args) throws InterruptedException {
        (new StudyJmm.Thread1()).start();
        (new StudyJmm.Thread2()).start();
        (new StudyJmm.Thread3()).start();

        TimeUnit.SECONDS.sleep(3);
        System.out.println("<主线程>-修改成员变量");
        o = null;
        System.out.println("<主线程>-将值已修改,并已经刷新至主存,因为该方法有Synchronized修饰");
    }


    public static class Thread1 extends Thread {
        public void run() {
            while (o != null) {
            }
            System.out.println("A线程已经将副本更新为主存中的新值");
        }
    }

    public static class Thread2 extends Thread {
        public void run() {
            while (o != null) {
            }
            System.out.println("B线程已经将副本更新为主存中的新值");
        }
    }

    public static class Thread3 extends Thread {
        public void run() {
            while (o != null) {
                try {
                    //todo 经过测试：以下三种方式是可以导致主存和线程副本进行同步的
                    //todo 如果没有以下三种方法，线程副本没有和主存同步

                    //方法①
                    //TimeUnit.SECONDS.sleep(2);

                    //方法②
                    //System.out.println("该方法源码实现有同步锁");

                    //方法③
                    //File file = new File("D:\\demo.txt"); // 文件的路径
                    //if (file.exists()) { // 文件存在
                    //    boolean d = file.delete(); // 删除文件
                    //} else { // 文件不存在
                    //    boolean c = file.createNewFile(); // 创建新文件
                    //}
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C线程已经将副本更新为主存中的新值");
        }
    }

}