package com.example.logmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//http://127.0.0.1:9111/api/v1/stat/test02

@SpringBootApplication
public class LogMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogMonitorApplication.class, args);
    }

}
