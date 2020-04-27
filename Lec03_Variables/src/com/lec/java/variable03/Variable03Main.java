package com.lec.java.variable03;
//실수형 자료 타입: float(4바이트), double(8바이트)
//정수형 자료 타입의 기본형은 int
//실수형 자료 타입의 기본형은 double
public class Variable03Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("변수 - 실수타입");
		
		double number1 = 3.141592;
//		float number2 = 3.14; //기본적으로 실수는 double로 인식
		//float <- double 불가
		
		float number3 = 3.14f;
		
		System.out.println(Float.MIN_VALUE + " ~ " + Float.MAX_VALUE);
		System.out.println(Double.MIN_VALUE + " ~ " + Double.MAX_VALUE);
		//실수값의 최소값은 0보다 크고 1보다 작은 수의 깊이
		
		float number4 = 1.23456789f;
		double number5 = 1.23456789;
		System.out.println(number4);
		System.out.println(number5);
		// float와 double은 저장할 수 있는 값의 크기만이 아니라
		// 소숫점 이하 정밀도(precision)의 차이가 있다.
		
		//실수 표기법
		double number6 = 123;
		double number7 = 1.23e2; // 지수표기법
		System.out.println(number6);
		System.out.println(number7);
		
		double number8 = 0.0001213;
		double number9 = 1.213e-4;
		
		
		
	}

}
