package com.lec.java.casting;
/*
 * 암묵적 형변환(Implicit casting): 자바 언어가 자동으로 해주는 형변환
 * 
 * 		primitive type 에서 implicit casting 방향
 * 
 * 		byte → short → int → long → float → long  
 *                 		↑
 *                    char
 * 
 * 명시적 형변환(Explicit casting): 프로그래머가 직접 타입을 변환하는 것
 *      
 *      (변환하고자 하는 타입명)변수/값      
 */

public class CastingMain {
	public static void main(String[] args) {
		System.out.println("형변환 -Type Casting");
		byte num1  = 123;
		int num2 = 123;
		byte num3 =(byte)num2;
		double num4 =1234.56;
		System.out.println(num3);
		
		//명시적 형변환 - 데이터 손실 발생 주의!
		byte num5 = (byte)513;
		System.out.println(num5);
		
		double avg1 = (99 + 88 +78)/3;
		System.out.println(avg1);
		
		double avg2 = (double)(99 + 88 + 78)/3;
		System.out.println(avg2);
		
		
	}
}
