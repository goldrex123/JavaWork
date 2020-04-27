package com.lec.java.inherit03;

public class BusinessPerson extends Person { //단일 상속
	String company;
	
	public void showInfo() {
		whoAmI();
		System.out.println("회사는 " + company + " 입니다.");
	}
}
