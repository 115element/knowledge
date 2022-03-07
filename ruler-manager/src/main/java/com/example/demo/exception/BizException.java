package com.example.demo.exception;

import lombok.Getter;

import java.util.function.Supplier;

public class BizException extends RuntimeException {

    @Getter
    private final int status;

    public Supplier<BizException> sup() {
        return () -> this;
    }

    public BizException(int status, String format, Object... args) {
        super(String.format(format, args), null, false, false);
        this.status = status;
    }

    public static BizException badRequest(String format, Object... args) {
        return new BizException(400, format, args);
    }

    public static BizException unauthorized(String format, Object... args) {
        return new BizException(401, format, args);
    }
    public static BizException paymentRequired(String format, Object... args) {
        return new BizException(402, format, args);
    }

    public static BizException forbidden(String format, Object... args) {
        return new BizException(403, format, args);
    }

    public static BizException notFound(String format, Object... args) {
        return new BizException(404, format, args);
    }

    public static BizException conflict(String format, Object... args) {
        return new BizException(409, format, args);
    }

    public static BizException internalServerError(String format, Object... args) {
        return new BizException(500, format, args);
    }

    public static BizException ok(String format, Object... args) {
        return new BizException(200, format,args);
    }

    public static BizException ok() {
        return new BizException(200, "");
    }

}
