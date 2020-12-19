package com.alvin.advice;

import com.alvin.annotation.ResponseResult;
import com.alvin.common.entity.Result;
import com.alvin.common.entity.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;

/**
 * @Description 封装返回的数据
 * @Author 田云
 * @Date 2020/12/19 11:44
 * @Version 1.0
 */
@ControllerAdvice
public class ResponseResultAdvice implements ResponseBodyAdvice<Object> {

    /**
     * 请求中是否包含了 响应需要被包装的标记，如果没有，则直接返回，不需要重写返回体
     *
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        ResponseResult annotation = methodParameter.getMethod().getDeclaringClass().getAnnotation(ResponseResult.class);
        //先判断类上面有没有注释，再判断方法上有没有注释
        if (annotation == null) {
            annotation = methodParameter.getMethod().getAnnotation(ResponseResult.class);
        }
        return annotation == null ? false : true;
    }

    /**
     * 对 响应体 进行包装; 除此之外还可以对响应体进行统一的加密、签名等
     *
     * @param responseBody 请求的接口方法执行后得到返回值(返回响应)
     */
    @Override
    public Object beforeBodyWrite(Object responseBody, MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class<? extends HttpMessageConverter<?>> aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        //自定义的错误异常
        if (responseBody instanceof ResultCode) {
            ResultCode code = (ResultCode) responseBody;
            if (code == ResultCode.SUCCESS) {
                return Result.success();
            } else {
                return Result.failure(code);
            }
        }
        return Result.byObject(responseBody);
    }
}
