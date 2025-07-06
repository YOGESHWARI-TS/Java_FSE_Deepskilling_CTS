package com.library.repository;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.Librarymanagement2.BookService.*(..))")
    public void logBefore(JoinPoint joinPoint) {
        System.out.println("[AOP-LOG] Before executing: " + 
            joinPoint.getSignature().getName() + 
            " with args: " + java.util.Arrays.toString(joinPoint.getArgs()));
    }

    @After("execution(* com.library.Librarymanagement2.BookService.*(..))")
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("[AOP-LOG] After executing: " + 
            joinPoint.getSignature().getName());
    }
}