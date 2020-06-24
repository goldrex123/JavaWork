package com.lec.spring.aopStudy;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.lec.spring.beans.Logger;

@Aspect
public class LogAspectStudy {

	@Pointcut("within(com.lec.spring.aopStudy.*)")
	public void pc1() {
		
	}
	@Pointcut("within(com.lec.spring.aopStudy.*)")
	public void pc2() {
		
	}
	
//	@Before("pc1()")
	@Before("execution(* com.lec.spring.aopStudy.*1.*Action(..))")
	public void beforeAs() {
		System.out.print("[Before]");
		new Logger().logIn();
	}
	
	@After("pc2()")
	public void afterAs() {
		System.out.print("[After]");
		new Logger().logOut();
	}
	
}
