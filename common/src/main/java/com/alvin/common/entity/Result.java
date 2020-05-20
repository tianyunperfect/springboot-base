package com.alvin.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * @Description
 * @Author 田云
 * @Date 2020/5/1 20:54
 * @Version 1.0
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {
    private boolean success;
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> result(Boolean flag, ResultCode resultCode, T data) {
        return new Result<T>(flag, resultCode.ordinal(), resultCode.name(), data);
    }

    public static <T> Result<T> success(ResultCode resultCode, T data) {
        return result(true, resultCode, data);
    }

    public static <T> Result<T> success(T data) {
        return success(ResultCode.SUCCESS, data);
    }

    public static <T> Result<T> success() {
        return success(null);
    }

    public static <T> Result<T> failure(Integer code, String message) {
        return new Result<T>(false, code, message, null);
    }

    public static <T> Result<T> failure(ResultCode resultCode) {
        return new Result<T>(false, resultCode.ordinal(), resultCode.name(), null);
    }

    public static <T> Result<T> failure() {
        return failure(ResultCode.FAIL);
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("12");
        System.out.println(Result.success(strings));
    }
}