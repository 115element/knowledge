package com.example.onerequestcount.counter;

import java.util.concurrent.atomic.AtomicInteger;


//这里统计需要使用锁，因为请求可能同时进来.请看CounterImprove.

public class Counter {

    public static AtomicInteger atomicInteger = new AtomicInteger();

    public static int getCounter(){
        int i = atomicInteger.get();
        System.out.println(i);
        return i;
    }

    public static void restore(){
        System.out.println("计数器重置...");
        atomicInteger.set(0);
    }

    public static void addOne(){
        System.out.println("计数器+1...");
        int i = atomicInteger.incrementAndGet();
        System.out.println(i);
    }

}
