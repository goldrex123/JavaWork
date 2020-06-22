package com.lec.spring.aop02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import com.lec.spring.beans.Logger;

// aspect : advisor 들을 모아놓은 객체
// advisor : advice + pointcut
// advice : 공통기능 (메소드)

// 이 클래스가 aspect 역할을 할 클래스임을 명시
@Aspect
public class LogAspect {
	
	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc1() {
		
	}
	
	@Pointcut("within(com.lec.spring.aop02.*)")
	public void pc2() {
		
	}
	
//	@Before("within(com.lec.spring.aop02.*)") // Pointcut
	@Before("pc1()")
	public void beforeAdvice() {
		System.out.print("Before ");
		new Logger().logIn(); //콩통코드 . advice()
	}
	
//	@After("pc2()")
//	@After("within(com.lec.spring.aop02.*)")
//	@After("execution(* com.lec.spring.aop02.MyService22.*(..))")
	@After("execution(* com.lec.spring.aop02.*2.*(..))")
	public void afterAdvice() {
		System.out.print("After ");
		new Logger().logOut();
	}
	
	// Around advice : 메소드 실행을 제어하는 가장 강력한 코드
	//	직접 해당 메소드를 호출하고 결과나 예외 처리도 가능
	@Around("within(com.lec.spring.aop02.*)")
	public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable{
		//joinpoint 메소드 이름
		String signatureStr = joinPoint.getSignature().toShortString();
		
		
		// joinpoint 메소드 수행 전
		System.out.println("Around " + signatureStr + " 시작");
		long st = System.currentTimeMillis(); // 시작 시간 기록
		
		// joinpoint 메소드 수행
		try {
			Object obj = joinPoint.proceed();
			return obj;
		} finally {
			// joinpoint 메소드 수행 후
			long et = System.currentTimeMillis();
			System.out.println("Around " + signatureStr + " 종료, 경과시간 : " + (et-st));
		}
		
		
	}
}










