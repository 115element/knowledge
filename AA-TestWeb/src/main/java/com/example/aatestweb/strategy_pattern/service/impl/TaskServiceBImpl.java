package com.example.aatestweb.strategy_pattern.service.impl;

import com.example.aatestweb.strategy_pattern.service.TaskService;
import org.springframework.stereotype.Service;


@Service(value = "b")
public class TaskServiceBImpl implements TaskService {
    @Override
    public boolean process(String parameter) {
        System.out.println("执行了B策略");
        return false;
    }
}
