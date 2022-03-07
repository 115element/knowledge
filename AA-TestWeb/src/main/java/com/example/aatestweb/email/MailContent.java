package com.example.aatestweb.email;

import java.util.HashMap;
import java.util.Map;

public class MailContent {
    public static final Map<String, String> typeMap = new HashMap<String, String>() {
        {
            put("flowRate", "流量命中率");
            put("originStatus", "回源失败率");
            put("edgeStatus", "错误状态码占比");
        }
    };

    public static final Map<String, String> symbolMap = new HashMap<String, String>() {
        {
            put("less", "低于");
            put("more", "高于");
            put("more_equal", "大于等于");
            put("less_equal", "小于等于");
        }
    };
}