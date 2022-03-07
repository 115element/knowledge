package com.example.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


/**
1. zuul1.x是一个机遇阻m塞I/O的API Gateway

2. zuul1.x机遇servlet2.5，使用阻塞架构，它不支持任何长连接，如websocket。zuul的设计模式和nginx较像，每次I/O操作都是从工作线程中选择一个执行，
   请求线程被阻塞到工作线程完成，但是差别是nginx用C++实现，zuul用java实现，而jvm本身会有第一次加载较慢的情况，使得zuul的性能相对较差

3. zuul2.x基于netty非阻塞、支持长连接，但Spring Cloud目前还没有整合。zuul2.x的性能较zuul1.x有较大提高。在性能方面，根据官网提供的基准测试，
   Spring Cloud Gateway的RPS（每秒请求数）是zuul的1.6倍

4. Spring Cloud Gateway 建立 在 Spring Framework 5、 Project Reactor 和 Spring Boot 2 之上， 使用 非 阻塞 API。

5. Spring Cloud Gateway 还 支持 WebSocket， 并且 与 Spring紧密集成， 拥有更好的开发体验
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

}

/**
 * 如果不做任何配置
 *
 * 那么就可以路由到Eureka上已经注册的服务
 * 访问方法： http://localhost:8080/服务的名字/服务里边的接口地址
 *
 * 因为Zuul配置了Eureka的地址，也注册到了EurekaServer上了
 */
