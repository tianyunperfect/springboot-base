package com.alvin.advice;

import com.alvin.common.entity.Result;
import com.alvin.common.entity.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class ExceptionHandle ...
 *s
 * @author tianyunperfect
 * Created on 2019/9/19
 */
@ControllerAdvice
@Slf4j
public class ExceptionAdvice {

    /**
     * 统一异常处理
     * @param e 异常
     * @return Result
     */
    @ResponseBody
    @ExceptionHandler
    public Result exceptionHandle(Exception e) {
        e.printStackTrace();
        log.error("系统异常：{}", e.toString());
        return Result.failure(ResultCode.UNKNOWN.ordinal(), e.getMessage());
    }
}
