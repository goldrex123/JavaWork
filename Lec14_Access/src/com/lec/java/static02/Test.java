package com.lec.java.static02;

public class Test {
	int num; //인스턴스 변수
	static int sNum;
	
	
	public void show() {
		System.out.println("인스턴스 num = " + num);
		System.out.println("클래스  sNum = " + sNum);		
	}
	
	public static void show2() {
//		System.out.println("인스턴스 num = " + num); // static 메소드에 non-static 인스턴스 변수 사용 불가
		System.out.println("클래스  sNum = " + sNum);		
	}
}
