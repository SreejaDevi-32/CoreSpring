package com.spring.basic.aop;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.ProceedingJoinPoint;

import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	/*
	 * @Pointcut("execution(* com.spring.basic.controllers.OrderController.getOrderDetails(..))")
	 * @Pointcut("within(com.spring.basic.controllers.OrderController)")
	 * @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
	 * @Pointcut("target(com.spring.basic.controllers.OrderController)")
	
	*/
	@Pointcut("target(com.spring.basic.controllers.OrderController)")
	public void pointcutMethod() { }
	
	
	@Around("pointcutMethod()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable
	{
		long start = System.currentTimeMillis();
		Object value = joinPoint.proceed();
		long end = System.currentTimeMillis();
		long duration = (end - start);
		System.out.println("Duration of OrderController controller "+duration);
		System.out.println("Proceed value "+value);
		return value;
	}
}