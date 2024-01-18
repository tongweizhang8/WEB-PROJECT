package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2) //指定切面的优先级，值越小优先级越高
@Slf4j
@Component
//@Aspect
public class MyAspect5 {

    //切入点表达式的写法：execution(访问权限符 返回值类型 方法全类名(参数列表))
    @Before("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void before(){
        log.info("before ...5");
    }

    @After("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
    public void after(){
        log.info("after ...5");
    }

}
