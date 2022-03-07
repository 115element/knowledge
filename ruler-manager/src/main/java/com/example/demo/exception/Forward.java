package com.example.demo.exception;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class Forward extends RuntimeException {

    private final String path;

    @Getter
    private final Map<String,Object> attrs;

    public Forward(String path) {
        super(null,null,false,false);
        this.path = path;
        attrs = new HashMap<>();
    }

    public String getPath() {
        return path;
    }

    public Forward withAttr(String key,Object value) {
        attrs.put(key, value);
        return this;
    }
}
