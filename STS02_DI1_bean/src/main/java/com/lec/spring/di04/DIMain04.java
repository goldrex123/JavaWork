package com.lec.spring.di04;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.Student;

public class DIMain04 {

	public static void main(String[] args) {
		System.out.println("Main start");
		
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:studentCtx.xml");
		System.out.println("--컨테이너 생성--");
		
		Student student = null;
		student = (Student)ctx.getBean("Hong");
		System.out.println(student);
		
		student = (Student)ctx.getBean("Joo");
		System.out.println(student);
		
		System.out.println();
		student.getScore().setKor(100);
		System.out.println(student);
		ctx.close();
		System.out.println("Main END");
	}

}
