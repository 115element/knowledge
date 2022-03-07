package com.example.onerequestcount.counter;


/**
 * ThreadLocal是JDK包提供的，它提供线程本地变量，如果创建一乐ThreadLocal变量，那么访问这个变量的每个线程都会有这个变量的一个副本，在实际多线程操作的时候，操作的是自己本地内存中的变量，从而规避了线程安全问题，如下图所示
 */
public class CounterImprove {

    //public static ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
    public static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(() -> 0);

    public static int getCounter() {
        Integer integer = threadLocal.get();
        System.out.println("getCounter:::" + integer);
        return integer;
    }

    public static void restoreCounter() {
        threadLocal.set(0);
        System.out.println("restoreCounter:::");
    }

    public static void addOne() {
        Integer integer = threadLocal.get();
        integer += 1;
        threadLocal.set(integer);
        System.out.println("addOne:::" + integer);
    }

}
