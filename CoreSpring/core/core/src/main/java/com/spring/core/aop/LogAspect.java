/*
package com.spring.core.aop;
 

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {
	
	@Pointcut("execution(* com.spring.core.aop.IceCreamPage.orderIceCream(..))")
	public void pointcutMethod() {}

	@Before("execution(* com.spring.core.aop.*.*(..))")
	public void logBefore() {
		System.out.println("Logging IceCream Page");
	}
	
	@After("pointcutMethod()")
	public void logAfter() {
		System.out.println("Logging after Ice Cream Page");
	}
	
	@Around("pointcutMethod()")
	public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("Around Aspect is called before method Execution");
		Object value =joinPoint.proceed();
		System.out.println("Around Aspect is called After method execution"+value);
		return value;
	}
	
	@AfterReturning(pointcut="pointcutMethod()",returning ="result")
	public void logAfterReturning(Object result) {
		System.out.println("After Returning Aspect"+result);
		
	}
	
	@AfterThrowing(pointcut="pointcutMethod()",throwing = "ex")
	public void logAfterThrowing(Exception ex)
	{
		System.out.println("After Throwing Aspect"+ex);
	}
}
*/