package com.memory.chapter1;

/**
 * 线程的工作内存与主内存同步时机(必会知识点)
 */
/*
JAVA工作内存和主内存模型

在多线程中，多个线程访问主存中的临界资源（共享变量）时，需要首先从主存中拷贝一份共享变量的值到自己的工作内存中，
然后在线程中每次访问该变量时都是访问的线程工作内存(高速缓存)中的共享的变量副本，
而不是每次都去主存中读取共享变量的值（因为CPU的读写速率和主存读写速率相差很大，如果CPU每次都访问主存的话那么效率会非常低）。

Java线程变量加载的大致流程是，将主内存的变量加载到工作内存进行处理，处理完毕后写会主内存。
 */

public class StudyJavaMemoryModel {
    /*
     工作内存和主内存数据交换时机
     先看一下如下代码，主线程运行时开启另一个线程，设置flag为true；但是发现主线程并没有结束；
     这个是大家在学习线程间可见性时，经常会遇到的例子，通常的解决办法是给flag，加上volatile 关键字，保证变量的可见性 ；
     对于线程安全问题，很多时候都不是必现的，但有一个奇怪的现象是，下面的程序每次运行都是必现，这又什么原因导致的呢？
     */
    public static void main(String[] args) {
        ThreadOne td = new ThreadOne();
        new Thread(td).start();


        //用于演示CPU切换到该线程时，是否会导致主线程工作内存失效？结果: 线程切换不会导致工作内存失效
        new Thread(new ThreadTwo()).start();


        while (true) {
            //TODO 以下三种方法，将导致主线程可以结束，因为这些方法让该主线程工作区的内存重新加载主内存内容。
            //System.out.println("===加载====");
            //File file = new File("D://temp.txt");
            //sleep(1000);

            if (td.isFlag()) {
                System.out.println("--- (如果执行这一步)说明主线程工作内存,从主存重新加载了 ---");
                break;
            }
        }
    }

    /*
     下面进行一下分析：
     为什么主线程没有对ThreadOne线程的变量变更可见呢？
     从内存存模型可知，主线程一直用工作内存的变量，没有重新加载主内存被ThreadOne线程改变的变量
     为什么主线程一直没有重新加载主内存的变量呢？
     只有工作内存失效的时候。工作内存才会重新加载主内存的变量
     那什么时候工作内存的变量会失效呢
     · 线程中获取锁时
     · CPU有空闲时间时（比如线程休眠，IO操作）

     所以针对上面的代码，在不使用volatile关键字下，有几种方式可以让工作区的内存重新去加载主内存内容
     ① 在方法中调用同步方法,比如System.out.println();
     ② CPU有空闲时间时（比如线程休眠sleep(1000);）
     ③ IO操作 File file = new File(“D://temp.txt”);等
     */
}


class ThreadOne implements Runnable {
    private boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("CPU切换到线程1-执行-将flag设置为true");
    }

    public boolean isFlag() {
        return flag;
    }
}



class ThreadTwo implements Runnable {
    @Override
    public void run() {
        try {
            /**
             * 用于演示线程切换，是否会导致工作内存失效？需要对照上面代码
             * 答案是：线程切换不会导致工作内存失效，去主存重新获取。因为CPU切换到线程2执行时，主线程仍然没有从主存刷新自己工作内存的值(主线程不会结束)
             */
            Thread.sleep(2000);
            System.out.println("CPU切换到线程2-执行1...");
            Thread.sleep(2000);
            System.out.println("CPU切换到线程2-执行2...");
            Thread.sleep(2000);
            System.out.println("CPU切换到线程2-执行3...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}