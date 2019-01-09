package com.cvc.financeiro.transferencia.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

@Aspect
@Configuration
public class LoggerAspect {


    Logger logger = LogManager.getLogger(this.getClass());

   /* @Around("execution(* *(..)) && @annotation(LogThis)")
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
    }*/


    @Around("execution(* com.cvc.financeiro.transferencia..*.*(..))")
    public Object logTimeMethod(ProceedingJoinPoint joinPoint) throws Throwable {

	StopWatch stopWatch = new StopWatch();
	stopWatch.start();

	Object retVal = joinPoint.proceed();

	stopWatch.stop();

	StringBuffer logMessage = new StringBuffer();
	logMessage.append(joinPoint.getTarget().getClass().getName());
	logMessage.append(".");
	logMessage.append(joinPoint.getSignature().getName());
	logMessage.append("(");
	// append args
	Object[] args = joinPoint.getArgs();
	for (int i = 0; i < args.length; i++) {
	    logMessage.append(args[i]).append(",");
	}
	if (args.length > 0) {
	    logMessage.deleteCharAt(logMessage.length() - 1);
	}

	logMessage.append(")");
	logMessage.append(" execution time: ");
	logMessage.append(stopWatch.getTotalTimeMillis());
	logMessage.append(" ms");
	logger.info(logMessage.toString());
	return retVal;
    }

}
