package com.lec.spring.aop02;

import com.lec.spring.beans.Service;

public class MyService21 extends Service {

	@Override
	public void doAction() {
		// 공통기능이 없다
		
		printInfo();
	}
	
	public void hahaha() {
		System.out.println("hahaha");
	}
}
