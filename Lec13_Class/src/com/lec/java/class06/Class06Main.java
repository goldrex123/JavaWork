package com.lec.java.class06;

public class Class06Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습 : 성적처리");
		
		Score sc = new Score("준영",100,93,64);
		
		sc.displayInfo();
		System.out.println("총점 : " + sc.calcTotal());
		System.out.println("평균 : " + sc.calcAvg(sc.calcTotal()));
		System.out.println("프로그램 종료");
	} // end main()

} // end class Clas06Main










