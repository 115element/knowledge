package com.example.jpacollege.jpa.table_strategy1;

import org.hibernate.cfg.ImprovedNamingStrategy;


//此类的作用就是指定表名和字段名的生成策略
public class MySQLUpperCaseStrategy extends ImprovedNamingStrategy {

    private static final long serialVersionUID = 1383021413247872469L;

    @Override
    public String tableName(String tableName) {
        return tableName.toUpperCase();
    }
}
