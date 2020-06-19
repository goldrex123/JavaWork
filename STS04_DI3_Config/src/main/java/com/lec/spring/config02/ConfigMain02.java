package com.lec.spring.config02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.lec.beans.Score;
import com.lec.beans.Student;

public class ConfigMain02 {

	public static void main(String[] args) {
		//'java' 설정 파일을 사용한 컨텍스트 생성
		
		AnnotationConfigApplicationContext ctxA = new AnnotationConfigApplicationContext(AppConfig02.class);
		System.out.println("-- ctxA 생성");
		
		Score score1 = null;
		score1 = ctxA.getBean("score1", Score.class);
		System.out.println(score1);
		
		Student student1 = null;
		student1 = ctxA.getBean("stu1", Student.class);
		System.out.println(student1);
		ctxA.close();
	}

}
