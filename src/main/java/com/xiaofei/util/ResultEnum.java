package com.xiaofei.util;


/**
 * Created by yangrao on 2020/4/23.
 */
public enum ResultEnum {
    Success(2000, "success"),
    Fail(5000, "fail");
    private Integer code;
    private String message;


    ResultEnum(Integer code, String message){
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
