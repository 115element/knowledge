package com.example.sharingspherejpa.shardingalgorithm;

import lombok.extern.slf4j.Slf4j;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * @description 自定义标准分表策略
 * @date 2021/10/30 13:48
 */
@Slf4j
public class MyTablePreciseShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> tableNames, PreciseShardingValue<Long> shardingValue) {

        log.info("所有分片表名：" + tableNames);
        log.info("(逻辑表名、列名、列值)分片属性：" + shardingValue);

        /**
         * tableNames 对应分片库中所有分片表的集合
         * shardingValue 为分片属性，其中 logicTableName 为逻辑表，columnName 分片健（字段），value 为从 SQL 中解析出的分片健的值
         */
        for (String tableName : tableNames) {
            /**
             * 取模算法，分片健 % 表数量
             */
            String value = shardingValue.getValue() % tableNames.size() + "";
            if (tableName.endsWith(value)) {
                return tableName;
            }
        }
        throw new IllegalArgumentException();
    }
}