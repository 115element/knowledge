package com.example.order.enums;


public enum PayStatus {
    WAIT(0,"等待支付"),
    SUCCESS(1,"已支付"),
    ;

    private Integer code;
    private String message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private PayStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
