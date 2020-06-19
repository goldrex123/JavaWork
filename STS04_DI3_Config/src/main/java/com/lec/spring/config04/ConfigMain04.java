package com.lec.spring.config04;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lec.beans.Score;

public class ConfigMain04 {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig04.class);
		
		Score score1 = ctx.getBean("score1", Score.class);
		Score score2 = ctx.getBean("score2", Score.class);
		
		// xml 나중에 적용
		System.out.println(score1);
		System.out.println(score2);
	}

}
