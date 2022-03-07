package com.example.aatestweb.diyschedule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.SchedulingException;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.config.TriggerTask;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledFuture;

/**
 * 基于接口SchedulingConfigurer的动态定时任务
 * 此种方法实现SchedulingConfigurer 类，采用多线程方式跑定时任务，所以模拟了两个实现类
 */

@Slf4j
@Configuration
public class TaskSchedulingConfigurer implements SchedulingConfigurer {

    private ScheduledTaskRegistrar taskRegistrar;
    private Set<ScheduledFuture<?>> scheduledFutures = null;
    private static final Map<String, ScheduledFuture<?>> taskFutures = new ConcurrentHashMap<>();

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        //设置调度任务的线程池
        scheduledTaskRegistrar.setScheduler(Executors.newScheduledThreadPool(10));
        this.taskRegistrar = scheduledTaskRegistrar;
    }

    public static Map<String, ScheduledFuture<?>> getTaskFutures() {
        return taskFutures;
    }

    @SuppressWarnings("unchecked")
    public Set<ScheduledFuture<?>> getScheduledFutures() {
        if (scheduledFutures == null) {
            try {
                //spring版本不同选择不同字段scheduledFutures
                scheduledFutures = (Set<ScheduledFuture<?>>) BeanUtils.getProperty(taskRegistrar, "scheduledTasks");
            } catch (Exception e) {
                throw new SchedulingException("not found scheduleFutures field");
            }
        }
        return scheduledFutures;
    }

    /**
     * 添加任务
     */
    public void addTriggerTask(String taskId, TriggerTask triggerTask, boolean isEditTask) {
        if (!taskFutures.containsKey(taskId)) {
            log.info("当前任务【{}】,{}任务内容", taskId, isEditTask ? "已更新，更新" : "不存在，新增");
            TaskScheduler scheduler = taskRegistrar.getScheduler();
            ScheduledFuture<?> future = scheduler.schedule(triggerTask.getRunnable(), triggerTask.getTrigger());
            taskFutures.put(taskId, future);
        } else {
            if (isEditTask) {
                editTriggerTask(taskId, triggerTask);
            } else {
                log.info("任务已存在，不需要重复添加");
            }
        }
    }

    /**
     * 取消任务
     */
    public void cancelTriggerTask(String taskId) {
        log.info("{},取消任务", taskId);
        ScheduledFuture<?> future = taskFutures.get(taskId);
        if (future != null) {
            future.cancel(true);
        }
        taskFutures.remove(taskId);
        getScheduledFutures().remove(future);
        log.info("{},任务取消完成", taskId);
    }

    /**
     * 编辑任务(就是先删除，在增加任务)
     */
    public void editTriggerTask(String taskId, TriggerTask triggerTask) {
        cancelTriggerTask(taskId);
        addTriggerTask(taskId, triggerTask, true);
    }

    /**
     * 任务编号
     */
    public Set<String> taskIds() {
        return taskFutures.keySet();
    }


    /**
     * 是否存在任务
     */
    public boolean hasTask(String taskId) {
        return taskFutures.containsKey(taskId);
    }

    /**
     * 任务调度是否已经初始化完成
     */
    public boolean inited() {
        return this.taskRegistrar != null && this.taskRegistrar.getScheduler() != null;
    }

}
