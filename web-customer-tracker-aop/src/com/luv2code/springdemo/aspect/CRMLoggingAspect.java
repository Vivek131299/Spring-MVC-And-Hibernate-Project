package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class CRMLoggingAspect {

	// setup logger
	// Here, we are using Logger just to print out to the console INSTEAD of println statements 
	// because Logger prints to the Logger Output Stream instead of Standard Output Stream like println.
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	
	// Setup pointcut declarations
	// for Controller
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	// for Service
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	// for DAO
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	
	// Combine all those pointcut declarations
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	
	// add @Before Advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		// display the method we are calling
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @Before: calling method: " + theMethod); // Printing using Logger to the console.
		
		// Display the arguments to the method
		// get the arguments
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args and display it
		for (Object tempArg : args) {
			myLogger.info("=====>> argument: " + tempArg);
		}
	}
	
	
	
	// add @AfterReturning Advice
	@AfterReturning(pointcut="forAppFlow()", 
					returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		// display method we are returning from
		String theMethod = theJoinPoint.getSignature().toShortString();
		myLogger.info("=====>> in @AfterReturning: from method: " + theMethod); // Printing using Logger to the console.
		
		// display data returned
		myLogger.info("=====>> result: " + theResult);
		
	}
}
