package com.alvin.common.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

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
        return new Result<>(flag, resultCode.getCode(), resultCode.getMessage(), data);
    }

    //region success封装
    public static <T> Result<T> success(ResultCode resultCode, T data) {
        return result(true, resultCode, data);
    }

    public static <T> Result<T> success(T data) {
        return success(ResultCode.SUCCESS, data);
    }

    public static <T> Result<T> success() {
        return success(null);
    }
    //endregion


    //region failure封装
    public static <T> Result<T> failure(Integer code, String message) {
        return new Result<>(false, code, message, null);
    }

    public static <T> Result<T> failure(ResultCode resultCode) {
        return new Result<>(false, resultCode.getCode(), resultCode.getMessage(), null);
    }

    public static <T> Result<T> failure() {
        return failure(ResultCode.FAIL);
    }
    //endregion

    public static <T> Result<T> byObject(T t) {
        return byObject(t,ResultCode.UNKNOWN);
    }
    /**
     * 通过对象输出结果
     * 当对象为 true 或者不为 null 的时候返回正常
     *
     * @param t          t
     * @param resultCode 结果代码
     * @return {@link Result<T>}
     */
    public static <T> Result<T> byObject(T t, ResultCode resultCode) {
        if (t instanceof Boolean) {
            if ((Boolean) t) {
                return Result.success();
            }
        } else if (t != null) {
            return Result.success(t);
        }
        return Result.failure(resultCode);
    }

    public static void main(String[] args) {
        System.out.println(Result.byObject(null, ResultCode.UNKNOWN));
        System.out.println(Result.byObject(false, ResultCode.UNKNOWN));
    }
}
