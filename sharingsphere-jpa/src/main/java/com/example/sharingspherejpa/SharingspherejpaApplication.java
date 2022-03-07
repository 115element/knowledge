package com.example.sharingspherejpa;

import org.apache.shardingsphere.core.strategy.keygen.SnowflakeShardingKeyGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Properties;

@EnableJpaAuditing
@SpringBootApplication
public class SharingspherejpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SharingspherejpaApplication.class, args);
    }


    @Bean
    public SnowflakeShardingKeyGenerator snow(){
        SnowflakeShardingKeyGenerator snowflake = new SnowflakeShardingKeyGenerator();
        Properties properties = new Properties();
        properties.setProperty("worker.id","123"); //工作区id
        properties.setProperty("max.tolerate.time.difference.milliseconds","5"); //容忍最大时钟回拨毫秒数
        // 如果时钟回拨的时间超过最大容忍的毫秒数阈值，则程序直接报错；
        // 如果在可容忍的范围内，默认分布式主键生成器，会等待时钟同步到最后一次主键生成的时间后再继续工作。
        snowflake.setProperties(properties);
        return snowflake;
    }

}
