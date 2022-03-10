package com.example.springbootprinciple.a_retry;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {


    //1.指定发生什么宜异常时进行重试
    //2.重试次数
    //3.重试间隔时间(毫秒)
    @Retryable(value = {Exception.class}, maxAttempts = 3, backoff = @Backoff(delay = 3000))
    public void ss(String a, String b) throws Exception {
        System.out.println("111");
        throw new Exception("ss");
    }


    //@Recover
    //当重试到达指定次数时，被注解的方法将被回调，可以在该方法中进行日志处理。需要注意的是发生的异常和入参类型一致时才会回调。
    //如果Retryable方法，重试后依然执行失败时，调用该方法。
    //用法：
    //①该方法第一个参数必须是异常，并且和上面方法抛出的异常保持一致。
    //②该方法的其它参数列表，必须和上面方法的参数列表一致。
    //③该方法的返回值必须要和上面方法的返回值一致。
    @Recover
    public void recover(Exception e, String a, String b) {
        System.out.println("Retryable fail call...");
    }
}
