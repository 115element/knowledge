package com.example.springbootprinciple.a_async;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {


    //标识该方法异步执行，放入线程池执行
    @Async
    public void ss(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("异步执行！！！");
    }
}
