package com.xtgj.j2ee.chapter10.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LogPrint {
	@Pointcut("execution(* com.xtgj.j2ee.chapter10..*.*(..))")
	private void anyMethod() {
	}// 声明一个切入点

	@Before("anyMethod() && args(userName)")
	// 定义前置通知
	public void doAccessCheck(String userName) {
		System.out.println("doAccessCheck");
	}

	@AfterReturning(pointcut = "anyMethod()", returning = "revalue")
	// 定义后置通知
	public void doReturnCheck(String revalue) {
		System.out.println("doReturnCheck");
	}

	@AfterThrowing(pointcut = "anyMethod()", throwing = "ex")
	// 定义例外通知
	public void doExceptionAction(Exception ex) {
		System.out.println("doExceptionAction");
	}

	@After("anyMethod()")
	// 定义最终通知
	public void doReleaseAction() {
		System.out.println("doReleaseAction");
	}

	@Around("anyMethod()")
	// 环绕通知
	public Object doBasicProfiling(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("doBasicProfiling");
		return pjp.proceed();
	}
}
