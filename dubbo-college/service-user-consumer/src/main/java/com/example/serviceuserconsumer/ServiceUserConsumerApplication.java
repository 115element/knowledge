package com.example.serviceuserconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrix //开启熔断器
@EnableHystrixDashboard //开启熔断仪表盘
@SpringBootApplication
public class ServiceUserConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUserConsumerApplication.class, args);
    }

}
