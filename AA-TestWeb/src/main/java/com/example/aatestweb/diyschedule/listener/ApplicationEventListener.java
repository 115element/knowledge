package com.example.aatestweb.diyschedule.listener;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.*;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.context.event.ContextStoppedEvent;

@Slf4j
@Configuration
public class ApplicationEventListener implements ApplicationListener<ApplicationEvent> {

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        // 在这里可以监听到Spring Boot的生命周期
        if (event instanceof ApplicationStartingEvent) {
            log.info("应用程序启动中");
        } else if (event instanceof ApplicationEnvironmentPreparedEvent) { // 初始化环境变量
            log.info("初始化环境变量");
        } else if (event instanceof ApplicationPreparedEvent) { // 初始化环境变量完成，初始化上下文context完成
            log.info("初始化环境变量完成，初始化上下文context完成");
        } else if (event instanceof ContextRefreshedEvent) { // 应用刷新
            log.info("应用刷新");
        } else if (event instanceof ApplicationReadyEvent) {// 应用已启动完成
            log.info("应用已启动完成");
            this.init();
        } else if (event instanceof ContextStartedEvent) { // 应用启动，Spring2.5新增的事件，当容器调用ConfigurableApplicationContext的 Start()方法开始/重新开始容器时触发该事件。
            log.info("应用启动好了");
        } else if (event instanceof ApplicationFailedEvent) {
            log.info("应用启动失败");
        } else if (event instanceof ContextStoppedEvent) { // 应用停止，Spring2.5新增的事件，当容器调用ConfigurableApplicationContext 的Stop()方法停止容器时触发该事件。
            log.info("应用停止");
        } else if (event instanceof ContextClosedEvent) { // 应用关闭，当ApplicationContext被关闭时触发该事件。容器被关闭时，其管理的所有 单例Bean都被销毁。
            log.info("应用关闭");
        } else {
            log.info("其他事件" + event.toString());
        }
    }


    public void init(){
        log.info("执行一些初始化方法....");
    }
}
