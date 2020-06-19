package com.lec.spring.config03;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.beans.Score;

public class ConfigMain03 {

	public static void main(String[] args) {
		// XML 설정으로부터 생성 (xml안에 java설정 포함됨)
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:appCtx03.xml");
		System.out.println("--ctx 생성");
		
		Score score = null;
		
		score = ctx.getBean("score1", Score.class);
		System.out.println(score);
		score = ctx.getBean("score2", Score.class);
		System.out.println(score);
		
		ctx.close();
	}

}
