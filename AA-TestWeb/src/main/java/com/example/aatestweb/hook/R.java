package com.example.aatestweb.hook;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class R implements Serializable {
    private String code;
    private String msg;
    private Object data;

    public static R ok() {
        return new R("0");
    }

    public static R ng() {
        return new R("1");
    }

    public static R code(String code) {
        return new R(code);
    }

    public R(String code) {
        this.code = code;
    }
}
