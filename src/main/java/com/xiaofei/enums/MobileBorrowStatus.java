package com.xiaofei.enums;

/**
 * Created by yangrao on 2020/4/23.
 */
public enum MobileBorrowStatus {

    BORROWED(1, "已出借"),
    UNBORROWED(2, "未借出");
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    MobileBorrowStatus(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
