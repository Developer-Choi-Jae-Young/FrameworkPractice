package com.kh.lclinic.common.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
public class LoggingAop {
	@Pointcut("execution(* com.kh.lclinic..*.*(..))")
	public void cut() {

	}

	@Before("cut()")
	public void before(JoinPoint jp) {
		MethodSignature ms = (MethodSignature) jp.getSignature();
		Object[] args = jp.getArgs();

		log.info("--------------------- before method --------------------");
		log.info("method: {}", ms);
		log.info("args: {}", args);
		log.info("--------------------------------------------------------");
	}

	@AfterReturning(value = "cut()", returning = "obj")
	public void afterReturning(JoinPoint jp, Object obj) {
		log.info("---------------- afterReturning method -----------------");
		log.info("method: {}", jp.getSignature());
		log.info("args: {}", obj);
		log.info("--------------------------------------------------------");
	}

	@Around("cut()")
	public Object around(ProceedingJoinPoint pjp) throws Throwable {
		long start = System.currentTimeMillis();

		Object result = pjp.proceed();

		long end = System.currentTimeMillis();

		log.info("-------------------- around method ---------------------");
		log.info("method: {}", pjp.getSignature());
		log.info("time: {}ms", (end - start));
		log.info("--------------------------------------------------------");

		return result;
	}
}
