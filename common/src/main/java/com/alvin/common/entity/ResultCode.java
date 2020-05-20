package com.alvin.common.entity;

public enum ResultCode {
    // 基本
    SUCCESS(1, "success"),
    FAIL(-1, "fail"),
    UNKNOW(-2, "unknow"),
    ;
    /**
     * 代码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}