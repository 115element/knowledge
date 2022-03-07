package com.example.onerequestcount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import java.util.concurrent.atomic.AtomicInteger;

/*
统计MySQL总压力:

--show global status where Variable_name in('com_select','com_insert','com_delete','com_update');
查询出当前四种操作的总次数
x1
y1
z1
w1
--select sleep(60)
延时60秒
--show global status where Variable_name in('com_select','com_insert','com_delete','com_update');
一分钟后四种操作的总次数
x2
y2
z2
w2

计算每秒 各种操作的次数
每秒查询： （x1-x2）/60
每秒插入： （y1-y2）/60
每秒删除： （z1-z2）/60
每秒更新： （w1-w2）/60

 */


@ServletComponentScan(basePackages = "com.example.onerequestcount.filter")
@SpringBootApplication
public class OnerequestcountApplication {

    AtomicInteger atomicInteger = new AtomicInteger();

    public static void main(String[] args) {
        SpringApplication.run(OnerequestcountApplication.class, args);
    }

}
