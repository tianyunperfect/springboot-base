package com.alvin.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Objects;

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
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        /*
         * 执行方法
         */
        Object result = joinPoint.proceed();
        /*
         * 执行方法之后
         */
        String split = "; ";
        String sb = "url=" + request.getRequestURL() + split +
                "method=" + request.getMethod() + split +
                "class_method=" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName() + split +
                "args=" + Arrays.toString(joinPoint.getArgs()) + split +
                "consumer time(ms) = " + (System.currentTimeMillis() - start);
        log.info(sb);

        return result;
    }
}