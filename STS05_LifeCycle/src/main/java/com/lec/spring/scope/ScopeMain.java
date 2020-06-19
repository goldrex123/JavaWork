package com.lec.spring.scope;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.beans.Score;

public class ScopeMain {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx02.xml");
		System.out.println("--ctx생성");
		
		Score score11 = ctx.getBean("score1", Score.class);
		Score score12 = ctx.getBean("score1", Score.class);
		System.out.println(score11);
		System.out.println(score12);
		
		if(score11 == score12) {
			System.out.println("같아");
		} else {
			System.out.println("달라");
		}
		
		score12.setComment("zz");
		System.out.println(score11);
		System.out.println(score12);
		
		// scope = prototype
		// getBean() 할때마다 bean 인스턴스가 새로이 생성됨
		Score score21 = ctx.getBean("score2" , Score.class);
		System.out.println(score21);
		Score score22 = ctx.getBean("score2" , Score.class);
		System.out.println(score22);
		
		score21.setComment("21임");
		score22.setComment("22임");
	
		System.out.println(score21);
		System.out.println(score22);
		
		
		if(score21 == score22) {
			System.out.println("같아");
		} else {
			System.out.println("달라");
		}
		
		ctx.close();
		System.out.println("종료");
	}

}
