package com.example.aop.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ParameterAOP {
    @Pointcut("execution(* com.example.aop.controller..*.*(..))")
    private void cut(){

    }
    @Before()
    public void before(){

    }
    public void afterReturn(){

    }
}
