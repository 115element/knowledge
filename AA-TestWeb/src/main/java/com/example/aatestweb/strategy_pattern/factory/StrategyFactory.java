package com.example.aatestweb.strategy_pattern.factory;

import com.example.aatestweb.strategy_pattern.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class StrategyFactory {

    //Spring会帮你注入指定的实现类
    //key   【Service的name】
    //value 【实现类】
    @Autowired
    Map<String, TaskService> notify = new ConcurrentHashMap<>();

    public TaskService getStrategy(String component){
        if (notify.containsKey(component)) {
            return notify.get(component);
        } else {
            throw new RuntimeException("not strategy defined");
        }
    }
}
