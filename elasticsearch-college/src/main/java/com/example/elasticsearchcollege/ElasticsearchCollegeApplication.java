package com.example.elasticsearchcollege;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 1.先安装ES-7.12.1版本，
 * 2.安装方法看Docker篇
 */
@SpringBootApplication
public class ElasticsearchCollegeApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchCollegeApplication.class, args);
    }

}
