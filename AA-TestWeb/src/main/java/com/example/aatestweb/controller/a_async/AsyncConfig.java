package com.example.aatestweb.controller.a_async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.AsyncConfigurer;

import java.lang.reflect.Method;
import java.util.concurrent.*;

//TODO 我们可以自定义配置@Async使用的线程池

public class AsyncConfig implements AsyncConfigurer {

    private Logger log = LoggerFactory.getLogger(AsyncConfig.class);


    /**
     * ThreadPoolTaskExecutor的处理流程 当池子大小小于corePoolSize，就新建线程，并处理请求
     * 当池子大小等于corePoolSize，把请求放入workQueue中，池子里的空闲线程就去workQueue中取任务并处理
     * 当workQueue放不下任务时，就新建线程入池，并处理请求，如果池子大小撑到了maximumPoolSize，就用RejectedExecutionHandler来做拒绝处理
     * 当池子的线程数大于corePoolSize时，多余的线程会等待keepAliveTime长时间，如果无请求可处理就自行销毁
     */
    @Override
    @Bean(name = "threadPoolTaskExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolExecutor taskExecutor = new ThreadPoolExecutor(
                300,
                400,
                30,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>());
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy()); //交由调用线程处理策略
        log.info("@Retryable使用的线程池初始化完成");
        return taskExecutor;
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new SpringAsyncExceptionHandler();
    }
}


//未捕获异常执行策略
class SpringAsyncExceptionHandler implements AsyncUncaughtExceptionHandler {

    @Override
    public void handleUncaughtException(Throwable throwable, Method method, Object... objects) {
        System.out.println("Exception occurs in async method " + throwable.getMessage());
    }
}
