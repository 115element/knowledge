package com.example.aatestweb.cron;


import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 表达式生成器
 * 有很多的cron表达式在线生成器，这里给大家推荐几款
 * http://www.pdtools.net/tools/becron.jsp
 * 或者
 * http://cron.qqe2.com/
 */

@Component
@EnableScheduling
public class CronStudy {
    /**
     * cron 表达式是一个字符串，该字符串由 6 个空格分为 7 个域，每一个域代表一个时间含义。
     * 通常定义 “年” 的部分可以省略，实际常用的由 前六部分组成;
     * <p>
     * 格式：{秒数}  {分钟}  {小时}  {日期}  {月份}  {星期}  {年份(可为空)}
     * ————————————————————————————————————————————————————————————————————————————————
     * 字段               允许值                   允许的特殊字符
     * 秒                 0-59                     , - * /
     * 分                 0-59                     , - * /
     * 小时               0-23                     , - * /
     * 日期               1-31                     , - * ? / L W C
     * 月份               1-12 或者 JAN-DEC         , - * /
     * 星期               1-7 或者 SUN-SAT          , - * ? / L C #
     * 年（可选）          留空, 1970-2099           , - * /
     * ————————————————————————————————————————————————————————————————————————————————
     * 以下符号解释：
     * * 表示所有值；
     * ? 表示未说明的值，即不关心它为何值；
     * - 表示一个指定的范围；
     * , 表示附加一个可能值；
     * / 符号前表示开始时间，符号后表示每次递增的值；
     * <p>
     * 例如：
     * 可用格式： 1,2,3表示1或者2或者3
     * 可用格式： 1-5表示一个范围1~5
     * 可用格式： * / 2 表示被2整除的数字，比如小时，那就是每隔两个小时
     */

//  一些cron表达式案例
//  */5 * * * * ?       每隔5秒执行一次
//  0 */1 * * * ?       每隔1分钟执行一次
//  0 0 5-15 * * ?      每天5-15点整点触发
//  0 0/3 * * * ?       每三分钟触发一次
//  0 0-5 14 * * ?      在每天下午2点到下午2:05期间的每1分钟触发
//  0 0/5 14 * * ?      在每天下午2点到下午2:55期间的每5分钟触发
//  0 0/5 14,18 * * ?   在每天下午2点到2:55期间和下午6点到6:55期间的每5分钟触发
//  0 0/30 9-17 * * ?   朝九晚五工作时间内每半小时
//  0 0 10,14,16 * * ?  每天上午10点，下午2点，4点
//
//  0 0 12 ? * WED              表示每个星期三中午12点
//  0 0 17 ? * TUES,THUR,SAT    每周二、四、六下午五点
//  0 10,44 14 ? 3 WED          每年三月的星期三的下午2:10和2:44触发
//  0 15 10 ? * MON-FRI         周一至周五的上午10:15触发
//  0 0 23 L * ?                每月最后一天23点执行一次
//  0 15 10 L * ?               每月最后一日的上午10:15触发
//  0 15 10 ? * 6L              每月的最后一个星期五上午10:15触发
//  0 15 10 * * ? 2005          2005年的每天上午10:15触发
//  0 15 10 ? * 6L 2002-2005    2002年至2005年的每月的最后一个星期五上午10:15触发
//  0 15 10 ? * 6#3             每月的第三个星期五上午10:15触发
//
//  "30 * * * * ?"              每半分钟触发任务
//  "30 10 * * * ?"             每小时的10分30秒触发任务
//  "30 10 1 * * ?"             每天1点10分30秒触发任务
//  "30 10 1 20 * ?"            每月20号1点10分30秒触发任务
//  "30 10 1 20 10 ? *"         每年10月20号1点10分30秒触发任务
//  "30 10 1 20 10 ? 2011"      2011年10月20号1点10分30秒触发任务
//  "30 10 1 ? 10 * 2011"       2011年10月每天1点10分30秒触发任务
//  "30 10 1 ? 10 SUN 2011"     2011年10月每周日1点10分30秒触发任务
//  "15,30,45 * * * * ?"        每15秒，30秒，45秒时触发任务
//  "15-45 * * * * ?"           15到45秒内，每秒都触发任务
//  "15/5 * * * * ?"            每分钟的每15秒开始触发，每隔5秒触发一次
//  "15-30/5 * * * * ?"         每分钟的15秒到30秒之间开始触发，每隔5秒触发一次
//  "0 0/3 * * * ?"             每小时的第0分0秒开始，每三分钟触发一次
//  "0 15 10 ? * MON-FRI"       星期一到星期五的10点15分0秒触发任务
//  "0 15 10 L * ?"             每个月最后一天的10点15分0秒触发任务
//  "0 15 10 LW * ?"            每个月最后一个工作日的10点15分0秒触发任务
//  "0 15 10 ? * 5L"            每个月最后一个星期四的10点15分0秒触发任务
//  "0 15 10 ? * 5#3"           每个月第三周的星期四的10点15分0秒触发任务
    @Scheduled(cron = "*/2 * * * * ?")
    public void sendMailExpiredCertificate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = dateTimeFormatter.format(LocalDateTime.now());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务1："+format);
    }


    @Scheduled(cron = "${sync.status.check.task}")
    public void ParamAuto() {
//        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String format = dateTimeFormatter.format(LocalDateTime.now());
//        System.out.println("任务2："+format);
    }


}
