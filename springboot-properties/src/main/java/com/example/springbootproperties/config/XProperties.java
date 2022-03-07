package com.example.springbootproperties.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class XProperties {


    @Value("${s:没有配置}")
    private String s;

    @PostConstruct
    public void p(){
        System.err.println(s);
    }

    /**
     * 证明了配置是以最终激活的为主，提前加载的配置，会被后来加载的覆盖掉
     */
}
