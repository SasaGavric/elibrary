package com.sasagavric.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EmailAspect {
	
	@AfterThrowing(pointcut = "execution( * com.sasagavric.spring.*.*.*(..) )", throwing="exc")
	public void adviceForEverything(JoinPoint theJoinPoint, Throwable exc) {
		
		//coming soon...
		
	}

}
