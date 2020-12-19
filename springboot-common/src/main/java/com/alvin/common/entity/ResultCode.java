package com.alvin.common.entity;

public enum ResultCode {
    // 基本
    SUCCESS(0, "success"),
    FAIL(-1, "fail"),
    UNKNOWN(-2, "unknown"),

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

    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
