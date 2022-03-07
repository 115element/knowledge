package com.example.aatestweb.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data(staticConstructor = "of")
@ApiModel(description = "响应对象")
public class Result<T> {
    private static final int SUCCESS_CODE = 0;
    private static final String SUCCESS_MESSAGE = "成功";

    @ApiModelProperty(value = "响应码", name = "code", required = true, example = "" + SUCCESS_CODE)
    private String code;
    @ApiModelProperty(value = "响应消息", name = "msg", required = true, example = SUCCESS_MESSAGE)
    private String msg;
    @ApiModelProperty(value = "响应数据", name = "data")
    private T data;


    public static Result success(Object t) {
        return Result.of().setCode("0").setMsg("success").setData(t);
    }

    public static Result failure(String msg) {
        return Result.of().setCode("1").setMsg(msg);
    }

    public static Result error() {
        return Result.of().setCode("1").setMsg("internal error");
    }
}
