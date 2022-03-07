package com.example.cas_aba;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 演示解决CAS的ABA问题
 * 数据库有个锁称为乐观锁，是一种基于数据版本实现数据同步的机制，每次修改一次数据，版本就会进行累加。
 * 同样，Java也提供了相应的原子引用类AtomicStampedReference<V>
 */

public class CasAbaResolve {
    //第一个参数：初始值   第二个参数：初始版本
    static AtomicStampedReference<Integer> ai = new AtomicStampedReference<>(4, 0);

    public static void main(String[] args) {
        new Thread(() -> {
            //四个参数分别是预估内存值，更新值，预估版本号，初始版本号
            //只有当预估内存值==实际内存值，并且预估版本号==实际版本号，才会进行修改。
            boolean b = ai.compareAndSet(4, 5, 0, 1);
            System.out.println(Thread.currentThread().getName() + "是否成功将ai的值修改为5：" + b);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            b = ai.compareAndSet(5, 4, 1, 2);
            System.out.println(Thread.currentThread().getName() + "是否成功将ai的值修改为4：" + b);
        }, "A").start();

        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            boolean b = ai.compareAndSet(4, 10, 0, 1);
            System.out.println(Thread.currentThread().getName() + "是否成功将ai的值修改为10：" + b);
        }, "B").start();

        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println("ai最终的值为：" + ai.getReference());
        System.out.println("ai最终的版本为：" + ai.getStamp());

        /**
         * 可以看到，最终线程B并没有成功修改ai的值；
         * 说明解决了ABA问题。
         */
    }
}
