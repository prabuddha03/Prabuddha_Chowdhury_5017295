package org.example.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* org.example.service.BookService.*(..))")
    public void logBeforeMethodExecution(JoinPoint joinPoint) {
        System.out.println("Logging before method execution...");
        System.out.println("Method Name: " + joinPoint.getSignature().getName());
        System.out.println("Arguments: ");
        for (Object arg : joinPoint.getArgs()) {
            System.out.println("  " + arg);
        }
    }

    @After("execution(* org.example.service.BookService.*(..))")
    public void logAfterMethodExecution(JoinPoint joinPoint) {
        System.out.println("Logging after method execution...");
        System.out.println("Method Name: " + joinPoint.getSignature().getName());
    }
}
