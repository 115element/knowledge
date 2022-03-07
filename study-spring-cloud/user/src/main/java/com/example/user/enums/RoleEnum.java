package com.example.user.enums;



public enum RoleEnum {

    BUYER(1,"买家"),
    SELLER(2,"卖家"),
    ;

    private final Integer code;
    private final String message;

    RoleEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
