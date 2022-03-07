package com.example.logmonitor.entity;


import lombok.Data;

@Data
public class Result {
    private String code;
    private String msg;
    private Object data;

    public Result(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
