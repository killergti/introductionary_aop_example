package com.devexperts.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

/**
 * @author ifedorenkov
 */
@Aspect
public class AspectForBenchmark {

    @Around(value = "within(com.devexperts.service..*) && this(com.devexperts.service.PersonService)")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            Thread.sleep(12);
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
        Object result =  pjp.proceed();
        try {
            Thread.sleep(34);
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
        return result;
    }

}
