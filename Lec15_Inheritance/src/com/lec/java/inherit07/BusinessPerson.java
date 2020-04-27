package com.lec.java.inherit07;

public class BusinessPerson extends Person {
	private String company;

	public String getCompany() {return company;}
	public void setCompany(String company) {this.company = company;}
	
	//매소드 재정의(override)
//	public void showInfo() {
//		super.showInfo();
//		System.out.println("회사 : " + company);
//	}
	
	@Override //어노테이션 
	public void showInfo() {
		// TODO Auto-generated method stub
		super.showInfo();
	}
	//메소드 오버로딩
	public void showInfo(int id) {
		System.out.println("id: " + id);
		showInfo();
	}
	
	//final 메소드 오버라이딩 불가
//	@Override //단축키 = 알트+쉬프트+s
//	public void whoAreYou() {
//		// TODO Auto-generated method stub
//		super.whoAreYou();
//	}
	
	@Override
	public String toString() {
		return "BusinessPerson: " + getName() + " " + company;
	}
	
}
