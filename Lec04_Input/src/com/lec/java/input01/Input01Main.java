package com.lec.java.input01;

import java.util.Scanner;

/*
 * 표준 입력 (Standard Input) : 키보드로부터 입력
 * 			Scanner 객체 사용
 * 
 * 표준 출력 (Standard Output) : 모니터로 출력
 */
public class Input01Main {

	public static void main(String[] args) {
		System.out.println("표준 입력 : Scanner사용");
		
		Scanner sc = new Scanner(System.in); //import 필요 , Scanner 객체 생성
		
		//Scanner 사용할 입력 작업
		int num1, num2;
		System.out.print("숫자 1을 입력하세요: ");
		num1 = sc.nextInt(); //키보드로부터 int값 입력
		System.out.print("숫자 2을 입력하세요: ");
		num2 = sc.nextInt();
		System.out.println(num1 + " + " + num2 +" = "+(num1+num2));
		
		// 각 primitive 타입에 대해 nextXXX() 메소드 제공
//		sc.nextByte();
//		sc.nextShort();
//		sc.nextLong();
//		sc.nextFloat();
//		sc.nextDouble();
//		sc.nextBoolean();
		
		sc.close(); //Scanner 객체 사용한 뒤 반드시 close()를 해주자
	}
}
