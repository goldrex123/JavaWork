package com.lec.java.variable02;
//자바의 기본 자료형(primitive data type)
//정수 타입: byte(1바이트), short(2바이트), int(4바이트), long(8바이트)
//실수 타입: float(4바이트), double(8바이트)
//문자 타입: char(2바이트)
//논리 타입: boolean
public class Variable02Main {
	public static void main(String[] args) {
		System.out.println("정수타입 변수들");
		
		System.out.println("byte : " + Byte.MIN_VALUE + " ~ " + Byte.MAX_VALUE);		
		byte num1 = -128, num2 = 0, num3 = 123;
//		byte num4 = 1234;
		
		System.out.println("short : " + Short.MIN_VALUE + " ~ " + Short.MAX_VALUE);
		short num5 = -12345;
		short num6 = 12345;
//		short num7 = 32768;
		
		System.out.println("int : " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
//		int num9 = 9876543210;
		
		System.out.println("long : " + Long.MIN_VALUE + " ~ " + Long.MAX_VALUE);
		long num10 = 9876543210l;
		// 리터럴 : literal
		// 코드상에 직접 입력한 값들
		// 정수 리터럴은 int로 형변환 하려 한다.
		// 실수 리터럴은 double로 형변환 하려 한다.
		// ""리터럴은 문자열(String)으로 형변환 하려 한다.
		long num11 = 9876543210l; // <-- long형 리터럴로 인식
		long num12 = 12;
		long num13 = 12l;
		int num14 = 12;
//		int num15 = (int)12l;
		
		//값의 경계선
		byte num15 = Byte.MAX_VALUE;
		byte num16 = (byte)(num15 + 1);
		System.out.println(num15);
		System.out.println(num16);
		
		// 정수 표기법
		int number1 = 11; //10진수
		int number2 = 0xB; //16진수
		int number3 = 013; // 8진법
		int number4 = 0b1011; //2진법
		System.out.println(number1);
		System.out.println(number2);
		System.out.println(number3);
		System.out.println(number4);
		
		System.out.println(String.format("%x", number1));
		System.out.println(String.format("%o", number1));
		
		System.out.println(Integer.toHexString(number1));
		System.out.println(Integer.toOctalString(number1));
		System.out.println(Integer.toBinaryString(number1));
		
	}//end main
}//end class
