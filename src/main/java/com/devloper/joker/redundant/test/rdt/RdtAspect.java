package com.devloper.joker.redundant.test.rdt;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
@Aspect
public class RdtAspect {

    @Resource
    private RdtAsyncService rdtAsyncService;

    @Pointcut("execution(* com.devloper.joker.redundant.test.repository.*.*.save(..))")
    public void saveAspect() {
    }

    @After("saveAspect()")
    public void saveAfter(JoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        rdtAsyncService.updateRelevant(args);
    }



}
