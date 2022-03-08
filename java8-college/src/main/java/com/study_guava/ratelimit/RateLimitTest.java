package com.study_guava.ratelimit;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Semaphore：从线程个数限流
 * RateLimiter：从速率限流  目前常见的算法是漏桶算法和令牌算法
 */

public class RateLimitTest {

    @Test
    public void t1() {
        //速率是每秒1个许可
        RateLimiter rateLimiter = RateLimiter.create(1.0);
        double acquire = rateLimiter.acquire(); //返回获取令牌的等待时间
        System.out.println(acquire);
        boolean b = rateLimiter.tryAcquire(1, 1, TimeUnit.SECONDS); //permits令牌个数、timeout等待超时时间、时间单位
        System.out.println(b);
        //上面的写法是RateLimiter最常用的写法，注意：
        //acquire是阻塞的且会一直等待到获取令牌为止，它有一个返回值为double型，意思是从阻塞开始到获取到令牌的等待时间，单位为秒
        //tryAcquire是另外一个方法，它可以指定超时时间，返回值为boolean型，即假设线程等待了指定时间后仍然没有获取到令牌，那么就会返回给客户端false，客户端根据自身情况是打回给前台错误还是定时重试
    }


    /**
     * Semaphore使用方法
     * 控制线程执行数，原理：
     * 在信号量上我们定义两种操作：
     * acquire(获取)当一个线程调用acquire操作时，它要么通过成功获取信号量（信号量减一），
     * 要么一直等下去，直到有线程释放信号量，或超时。
     * release(释放)实际上会将信号量的值加1，然后唤醒等等待的线程。
     * 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数控制
     */
    @Test
    public void t2() {
        Semaphore semaphore = new Semaphore(1);

        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire(); //申请一个请求
                    System.out.println("执行一次");
                    semaphore.release(); //释放一个请求
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
        System.out.println("主线程结束");
    }


//
//    守护线程与非守护线程
//    简单理解
//
//    ①非守护线程不执行结束,程序就不会终止
//    ②守护线程啥都不做,就是监控非守护线程,
//    ③java进程剩下非守护线程时,进程就会关闭
//
//    一般我们创建的多线程都是非守护线程.
//    但是也有例外,例如在junit环境中 创建的多线程都变成了守护线程模式.
//    所以测试时,就会搞不清状况: 为什么用了多线程,结果跑不出来,
//    其实都是因为守护子线程没有运行结束, 测试进程就已经运行结束了.

//    junit case 的特点
//    编写junit 中的Test函数时, 如果用到多线程,主要注意
//
//    @Test函数是不会等待子线程运行结束的,只要@Test函数执行结束就立即结束.
//    所有junit user case 中的@test函数 是依次执行的.
//    所以编写测试用例时,如果用到多线程,要在test方法的结尾添加 awaitTermination(方法 ),用例如下:
//
//    @Test
//    public void test2() {
//        ExecutorService es = … ;
//        …
//        try{
//            es.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    main() 的多线程是非守护线程
//    在 main 中创建的多线程是非守护线程模式,所以只要子线程未执行结束, main线程会处于等待状态 ,这是程序进程也不会结束.


    //TODO： 在测试注解方法中，子线程未结束时，程序也会终止。
    @Test
    public void t4() {
        new Thread(() -> {
            while (true) {
                System.out.println("1");
            }
        }).start();
        System.out.println("2");
    }


    //TODO： 在main方法中，子线程未结束时，程序不会终止。
    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                System.out.println("1");
            }
        }).start();

        System.out.println("2");
    }


}
