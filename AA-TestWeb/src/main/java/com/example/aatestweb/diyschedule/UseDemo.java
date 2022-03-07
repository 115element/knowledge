package com.example.aatestweb.diyschedule;


import com.example.aatestweb.hook.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.config.TriggerTask;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class UseDemo {

    @Autowired
    TaskSchedulingConfigurer taskSchedulingConfigurer;

    /**
     * 新增任务
     *
     * @param taskId 任务1
     * @param cron   0 0/1 * * * ?
     * @return
     */
    public R createTask(String taskId, String cron) {
        try {
            taskSchedulingConfigurer.addTriggerTask(taskId, createTriggerTask(cron), false);
            return R.ok().setMsg("任务创建完成");
        } catch (Exception e) {
            log.error("任务新增失败:", e);
        }
        return R.ng().setMsg("任务新增失败");
    }


    public TriggerTask createTriggerTask(String cron) {
        return new TriggerTask(() -> {
            try {
                //TODO 业务逻辑执行。。。
                System.out.println("执行你的业务逻辑。。。");
            } catch (Exception e) {
                log.error("任务出错,{}", e);
            }
        }, new CronTrigger(cron));
    }


    /**
     * 删除任务
     *
     * @param taskId
     */
    public R deleteTask(String taskId) {
        try {
            taskSchedulingConfigurer.cancelTriggerTask(taskId);
            log.info("取消任务完成，{}", taskId);
            return R.ok().setMsg("任务取消完成");
        } catch (Exception e) {
            log.error("任务取消失败", e);
        }
        return R.ng().setMsg("任务取消失败");
    }


    /**
     * 编辑任务(就是先删除，在增加任务)
     * @param @param taskId 任务1
     * @param @param cron   0 0/1 * * * ?
     * @return
     */
    public R editTask(String taskId, String cron) {
        try {
            taskSchedulingConfigurer.editTriggerTask(taskId, createTriggerTask(cron));
            log.info("修改任务完成，{}", taskId);
            return R.ok().setMsg("任务修改完成");
        } catch (Exception e) {
            log.error("任务修改失败", e);
        }
        return R.ng().setMsg("任务修改失败");
    }

}
