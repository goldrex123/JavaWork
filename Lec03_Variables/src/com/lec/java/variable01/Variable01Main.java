package com.lec.java.variable01;
/*
변수 (Variables) :
	값을 담는 공간.  변수이름(variable name)을 부여해서 관리
	
변수는 사용하기 전에 먼저 '선언(declaration)' 해야 한다
변수 선언:
	변수타입 변수이름;

변수의 초기화 (initialization)
변수에 최초로 값(value) 을 대입 (assignment) 하는 것.
변수(지역변수)를 사용/참조하려면 그전에 반드시 초기화가 되어야 함.

*/
public class Variable01Main {

	public static void main(String[] args) {
		System.out.println("변수(Variables)");
		
		int num1;
		int num2;
		
		num1 = 10; // num1에 10을 대입한다 , 대입연산자(=)사용
		
		num2 = 20;
//		num3 = 30; // 선언안된 변수 사용 불가, cannot be resolved

		
		System.out.println("num1 =  "+ num1);
		System.out.println("num2"
				+ " =  "+ num2);
		
		num1= 123;
		System.out.println("num1 =  "+ num1);
		System.out.println("num1 + num2 = " + (num1+num2));
		System.out.println("num1 - num2 = " + (num1-num2));
		System.out.println("num1 * num2 = " + (num1*num2));
		System.out.println("num1 / num2 = " + (num1/num2));
	} //end main
}//end class