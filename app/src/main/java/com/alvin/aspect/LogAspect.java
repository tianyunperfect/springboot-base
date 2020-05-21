package com.alvin.aspect;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 日志切片
 *
 * @author tianyunperfect
 * Created on 2019/9/19
 */
@Component
@Aspect
@Slf4j
public class LogAspect {

    @Pointcut("execution(public * com.alvin.controller..*.*(..))")
    public void webLog() {
    }

    @Around("webLog()")
    public Object webAop(ProceedingJoinPoint joinPoint) throws Throwable {
        /*
         * 执行方法之前
         */
        long start = System.currentTimeMillis();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        /*
         * 执行方法
         */
        Object result = joinPoint.proceed();
        /*
         * 执行方法之后
         */
        StringBuilder sb = new StringBuilder();
        String split = "; ";
        sb.append("url=").append(request.getRequestURL()).append(split);
        sb.append("method=").append(request.getMethod()).append(split);
        sb.append("class_method=").append(joinPoint.getSignature().getDeclaringTypeName()).append(".").append(joinPoint.getSignature().getName()).append(split);
        sb.append("args=").append(new Gson().toJson(joinPoint.getArgs())).append(split);
        sb.append("consumer time(ms) = ").append(System.currentTimeMillis() - start);
        log.info(sb.toString());

        return result;
    }
}