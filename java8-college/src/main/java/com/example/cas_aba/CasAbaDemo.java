package com.example.cas_aba;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 演示CAS算法的ABA问题
 */

public class CasAbaDemo {

    //线程操作资源，原子类ai的初始值为4
    static AtomicInteger ai = new AtomicInteger(4);

    public static void main(String[] args) {
        new Thread(() -> {
            //利用CAS将ai的值改为5
            boolean b = ai.compareAndSet(4, 5);
            System.out.println(Thread.currentThread().getName() + "是否成功将ai的值修改为5：" + b);
            //休眠1秒
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //利用CAS将ai的值改回4
            b = ai.compareAndSet(5, 4);
            System.out.println(Thread.currentThread().getName() + "是否成功将ai的值修改为4：" + b);
        }, "A").start();

        new Thread(() -> {
            //模拟此线程执行较慢情况
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //利用CAS将ai的值从4改为10
            boolean b = ai.compareAndSet(4, 10);
            System.out.println(Thread.currentThread().getName() + "是否成功将ai的值修改为10：" + b);
        }).start();

        //等待其它线程完成，为什么是2，因为一个是main线程，一个是后台的GC线程
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println("ai最终的值为：" + ai.get()); //10
        /**
         * 可以看到，线程B最终是将ai的值修改成功了。
         *
         * 上面例子模拟的是A、B两个线程操作一个资源ai，A的执行速度比B的快，
         * 在B执行前，A就已经将ai的值改为5之后马上又把ai的值改回为4，但是B不感知，所以最后B就修改成功了。
         *
         * 比如有两个单身狗A、B，A在某个时间段内找到女朋友但是又分开了，但是没告诉B，此时B还是会在A是单身狗的情况下带A去打游戏。
         */
    }

}
