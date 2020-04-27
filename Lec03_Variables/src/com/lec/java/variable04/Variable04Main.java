package com.lec.java.variable04;

public class Variable04Main {

	public static void main(String[] args) {
		System.out.println("변수 -char, boolean, String");
		
		//char - 문자 하나를 저장하기 위한 데이터 타입(2바이트)
		char c1 = 'A'; //char리터럴은  홀따옴표
		//문자열 리터럴은 쌍따옴표
		System.out.println(c1);
		char c2 = '한';
		char c3 = '글';
		System.out.println(c2);
		System.out.println(c3);
		
		
		char c4 = 0xae01;
		System.out.println(c4);
		char c5 = 1234;
		System.out.println(c5);
		// println()은 char를 문자로 출력한다.
		// 그러나 다른 정수형으로 변환되면 해당 코드값을 정수로 출력
		char c6 = '!';
		System.out.println(c6);
		char c7 = 33;
		System.out.println(c7);
		
		System.out.println(c7 + 1);
		System.out.println((char)(c7 + 1));
		
		char c8 = 'A';
		char c9 = 'a';
		System.out.println(c8 + "-"+ (int)c8);
		System.out.println(c9 + "-"+ (int)c9);
		
		//1. 까마귀     
		//2. 가마우지
		//3. 직박구리
		//2-1-3
		
		//1.aaAA
		//2.AaAa
		//3.AAaa
		//4.aAaA
		//3-2-4-1
		
		//boolean(논리형) : true , false
		boolean b1 = true;
		boolean b2 = false;
		System.out.println(b1);
		System.out.println(b2);
		System.out.println(10 < 20);
		System.out.println(10 > 20);
		
		boolean b3 = 10<20;
		System.out.println(b3);
		
		//String타입 , 기본타입이 아니다
		
		String name = "Hong";
		String nick = "Thunder";
		
		System.out.println(name + nick);
	}

}
