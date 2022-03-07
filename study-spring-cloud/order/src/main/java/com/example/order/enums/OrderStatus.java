package com.example.order.enums;


public enum OrderStatus {

    NEW(0,"新订单"),
    FINISHED(1,"完结"),
    CANCEL(2,"取消"),
    ;

    private final Integer code;
    private final String message;

    public Integer getCode() {
        return code;
    }
    public String getMessage() {
        return message;
    }

    OrderStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
