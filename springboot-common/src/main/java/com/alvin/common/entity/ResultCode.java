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

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}