package com.lec.spring.environment;

import java.io.IOException;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.io.support.ResourcePropertySource;

public class EnvMain {

	public static void main(String[] args) {
		System.out.println("main start");
		
		ConfigurableApplicationContext ctx = new GenericXmlApplicationContext();
		ConfigurableEnvironment env = ctx.getEnvironment();
		MutablePropertySources propertySources = env.getPropertySources();
		
		// PropertySources 에 PropertySource 추가
		try {
			//PropertySource 하나를 생성하여 propertysources에 추가 : addLast()  <-- 끝에 추가 
			propertySources.addLast(new ResourcePropertySource("classpath:admin.auth"));
			
			// 이제, Environment 를 통해 원하는 property에 접근 가능
			// 굳이 어느 PropertySource의 어느 property를 지정할 필요가 없다
			// 어느 property 에 대한 것만 요청 하면
			// propertysources 에 소속된 모든 propertysource를 다 스캔해서 찾아낸다
			System.out.println(env.getProperty("admin.id"));
			System.out.println(env.getProperty("admin.pw"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		GenericXmlApplicationContext gCtx = (GenericXmlApplicationContext)ctx;
		gCtx.load("classpath:appCtx1.xml");
		gCtx.refresh();
		
		AdminConnection adminConnection = gCtx.getBean("adminConnection", AdminConnection.class);
		System.out.println("admin ID : " + adminConnection.getAdminId());
		System.out.println("admin pw : " + adminConnection.getAdminPw());
		
		gCtx.close();
		System.out.println("종료");
	}

}

