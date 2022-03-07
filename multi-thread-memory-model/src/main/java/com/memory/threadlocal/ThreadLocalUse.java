package com.memory.threadlocal;

/**
 * 多个 ThreadLocal 在 THREAD 中的 threadLocals 里是怎么存储的?
 *
 * 它们的数量对应关系：
 * 一个 Thread 里面只有一个ThreadLocalMap ，而在一个 ThreadLocalMap 里面却可以有很多的 ThreadLocal，每一个 ThreadLocal 都对应一个 value。
 * 因为一个 Thread 是可以调用多个 ThreadLocal 的，所以 Thread 内部就采用了 ThreadLocalMap 这样 Map 的数据结构来存放 ThreadLocal 和 value。
 */

public class ThreadLocalUse {

    private final static ThreadLocal<String> X = new ThreadLocal<>();
    private final static ThreadLocal<String> Y = new ThreadLocal<>();

    public static void main(String[] args) {
        X.set("这是在主线程中");
        Y.set("这是主线程中的另外一个ThreadLocal成员");
        System.out.println("线程名字：" + Thread.currentThread().getName() + "---" + X.get());

        //线程a
        new Thread(new Runnable() {
            @Override
            public void run() {
                X.set("这是在线程a中");
                System.out.println("线程名字：" + Thread.currentThread().getName() + "---" + X.get());
            }
        }, "线程a").start();

        //线程b
        new Thread(new Runnable() {
            @Override
            public void run() {
                X.set("这是在线程b中");
                System.out.println("线程名字：" + Thread.currentThread().getName() + "---" + X.get());
            }
        }, "线程b").start();

        //线程c
        new Thread(() -> {
            X.set("这是在线程c中");
            System.out.println("线程名字：" + Thread.currentThread().getName() + "---" + X.get());
        }, "线程c").start();
    }
}

