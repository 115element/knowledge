package com.example.seata3.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import java.net.PortUnreachableException;

/**
 * 分布式事务调用方，若使用全局异常拦截，将会导致分布式事务失效
 * 解决办法在Seata1中《使用手动控制分布式事务》
 */


@RestController
@ControllerAdvice(basePackages = {
        "com.example.seata3.chain_test"
        , "com.example.seata3.one_off_two"
})
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public String processException(Exception e) throws PortUnreachableException {

        //某些特定的异常，我们设定不拦截，让其继续向上层抛出。
        if (e instanceof PortUnreachableException) {
            throw new PortUnreachableException(e.getMessage());
        }

        System.out.println(e.getMessage());
        return e.getMessage();
    }
}
