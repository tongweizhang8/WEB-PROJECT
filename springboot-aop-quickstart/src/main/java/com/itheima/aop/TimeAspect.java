package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Slf4j
@Component
//@Aspect //AOP类
public class TimeAspect {

    @Around("execution(* com.itheima.service.impl.*.*(..))")//切入点表达式
    public void RecordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        //1.记录开始时间
        long begin = System.currentTimeMillis();
        //2.调用原始方法运行
        Object proceed = joinPoint.proceed();
        //3.记录结束时间，计算方法耗时
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "耗时：" + (end - begin) + "毫秒");
    }
}
