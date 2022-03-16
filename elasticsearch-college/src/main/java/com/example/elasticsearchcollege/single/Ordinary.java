package com.example.elasticsearchcollege.single;

/**
 * 只是演示枚举的普通用法；
 */
public enum Ordinary {
    SS("11");

    private String code;

    private Ordinary(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
