package com.teamwill.leasing.Config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class LoggingAspect {


    @Before("execution(* com.teamwill.leasing.Service.Impl.*.*(..))")
    public void logMethodEntry(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toString();
        log.info("Begin of method :" + name + " : ");
    }
    @After("execution(* com.teamwill.leasing.Service.Impl.*.*(..))")
    public void logMethodEnd(JoinPoint joinPoint) {
        String name = joinPoint.getSignature().toString();
        log.info("End of method :" + name + " : ");
    }
    @AfterThrowing(value= "execution(* com.teamwill.leasing.Service.Impl.*.*(..))", throwing= "exception")
    public void afterThrowingAdvice(JoinPoint jp, Throwable exception) {
        log.error("Inside afterThrowingAdvice() method  = " + jp.getSignature().toString() + " method");
        log.error("Exception= " + exception);
    }

}
