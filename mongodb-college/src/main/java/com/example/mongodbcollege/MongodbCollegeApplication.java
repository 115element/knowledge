package com.example.mongodbcollege;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 先安装MongoDB数据库，请看Docker篇，和当前项目版本是对应的。
 */
@SpringBootApplication
public class MongodbCollegeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MongodbCollegeApplication.class, args);
    }

}
