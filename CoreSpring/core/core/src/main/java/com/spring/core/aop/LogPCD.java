package com.spring.core.aop;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Component
@Aspect
public class LogPCD {
	
	@Pointcut("target(com.spring.core.aop.Vanilla)")
	public void pointcutMethod() {}
	
	@Before("pointcutMethod()")
	public void beforeAdviceOnVanilla(JoinPoint joinPoint)
	{
		System.out.println("Execution Before Vanilla");
	}

}
