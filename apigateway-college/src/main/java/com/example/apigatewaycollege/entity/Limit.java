package com.example.apigatewaycollege.entity;

import lombok.Data;
import lombok.ToString;

@Data
public class Limit {
    private long limit;//数据刷新时间
    private long frequency;//频率
    private long timestamp;
}
