package com.example.jpacollege.jpa_querydls_and_dynamicsql.entity.vo;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

@Data
public class JpaReq {
    private String zone;
    private String ttl;
    private String value;
    private List<String> statusList = Lists.newArrayList();
}