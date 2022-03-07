package com.example.juc.typical.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//用于控制并发量
public class SemaphoreStudy {

    final static ExecutorService service = Executors.newCachedThreadPool();

    final static Semaphore semaphore = new Semaphore(3); //创建Semaphore信号量，初始化许可大小为3


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Runnable runnable = () -> {
                try {
                    semaphore.acquire(); //请求获取许可，如果有可获得的许可，才可继续往下执行，许可数减1，否则进入阻塞状态
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("[获取了一个许可]剩余可用的令牌数量" + semaphore.availablePermits());
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    semaphore.release(); //释放许可，许可数加1。
                    System.out.println("[释放了一个许可]剩余可用的令牌数量" + semaphore.availablePermits());
                }
            };

            service.execute(runnable);
        }
    }
}
