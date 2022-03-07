package com.example.sharingspherejpa.shardingalgorithm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @description 自定义标准分库策略
 * @date 2021/10/30 13:48
 */
@Slf4j
public class MyDBPreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {


    /**
     * databaseNames 所有分片库的集合
     * shardingValue 为分片属性，其中 logicTableName 为逻辑表，columnName 分片健（字段），value 为从 SQL 中解析出的分片健的值
     */
    @Override
    public String doSharding(Collection<String> databaseNames, PreciseShardingValue<Long> shardingValue) {

        log.info("所有分片数据库："+databaseNames);
        log.info("(逻辑表名、列名、列值)分片属性："+shardingValue);

        /**
         * databaseNames 所有分片库的集合
         * shardingValue 为分片属性，其中 logicTableName 为逻辑表，columnName 分片健（字段），value 为从 SQL 中解析出的分片健的值(也就是id的值)
         */
        for (String databaseName : databaseNames) {
            String value = shardingValue.getValue() % databaseNames.size() + "";
            if (databaseName.endsWith(value)) {
                return databaseName;
            }
        }
        throw new IllegalArgumentException();
    }
}