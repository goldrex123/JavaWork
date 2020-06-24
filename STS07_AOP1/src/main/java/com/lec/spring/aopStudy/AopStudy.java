package com.lec.spring.aopStudy;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.lec.spring.beans.Service;

public class AopStudy {

	public static void main(String[] args) {
		System.out.println("MAIN START");
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:aopStudyCtx.xml");
		
		Service service1 = ctx.getBean("service11", Service.class);
		Service service2 = ctx.getBean("service12", Service.class);
		
		service1.doAction();
		System.out.println();
		service2.doAction();
		System.out.println();
		
		System.out.println("main end");
	}
}
