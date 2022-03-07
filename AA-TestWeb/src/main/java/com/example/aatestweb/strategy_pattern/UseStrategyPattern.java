package com.example.aatestweb.strategy_pattern;


import com.example.aatestweb.strategy_pattern.factory.StrategyFactory;
import com.example.aatestweb.strategy_pattern.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UseStrategyPattern {

    @Autowired
    private StrategyFactory factory;

    /**
     * 策略模式用法
     * @param component
     */

    public void ppp(String component){

        TaskService taskService = factory.getStrategy(component);

        boolean result = taskService.process("AAA");
        System.out.println("这里通过不同的策略返回执行结果");
    }
}
