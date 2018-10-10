package com.cvc.financeiro.transferencia.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggerAspect {


    Logger logger = LogManager.getLogger(this.getClass());

    @Around("execution(* *(..)) && @annotation(LogThis)")
    public Object around(ProceedingJoinPoint point)
		    throws Throwable {

        long start = System.currentTimeMillis();

        Object result = point.proceed();

	logger.info("Logando com aspect - ",
		    MethodSignature.class.cast(point.getSignature()).getMethod().getName(),
		    point.getArgs(),
		    result,
		    System.currentTimeMillis() - start);

        return result;
    }

}
