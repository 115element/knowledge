package com.example.spring_circular_dependency.circle5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Transactional注解 不会导致循环依赖出现问题
 */
@Service
public class H {

    @Autowired
    H h;

    @Transactional
    public void test(){
        System.out.println("123");
    }
}
