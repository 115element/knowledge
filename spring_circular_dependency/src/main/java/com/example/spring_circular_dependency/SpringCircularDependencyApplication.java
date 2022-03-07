package com.example.spring_circular_dependency;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;


@ComponentScan(value = {"com.example.spring_circular_dependency.circle5"})
@SpringBootApplication
@EnableAsync
public class SpringCircularDependencyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCircularDependencyApplication.class, args);
    }

}

//  查看 JVM 装载类的方法#
//   那么如何查看类的装载，或者说哪些类会被装载呢？
//
//   ##### 添加JVM启动参数 ###
//   -verbose:class         [打印加载的所有类，和该类属于那个Jar包]
//   -XX:+TraceClassPaths   [打印ClassPath下的jar，也就是加载了那些jar]