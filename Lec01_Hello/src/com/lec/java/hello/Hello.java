package com.lec.java.hello;
/*
 * Java 첫 프로그램.
 * [학습목표]
 * - 기본 출력 : println(), print() 
 * - 주석 (Comment)
 */
public class Hello {

	public static void main(String[] args) {
//		System.out.println("Hello Java!!"); //Line Comment
//		System.out.println("안녕하세요"); //println()은 화면 출력하고 줄바꿈
//		
//		System.out.println();
//		System.out.println(1 + 2);
//		System.out.println("1"+ "2");
//		System.out.println('A' + 'B');
//		System.out.println('1' + 2);
//		System.out.println();
//		System.out.println('J' + "ava");
//		
//		//print는 줄바꿈 안함
//		System.out.print("자바");
//		System.out.print("프레임워크");
//		System.out.println("풀스택과정");
//		System.out.println("2020-03-16");
		String str = "java";
		String str2 = "java";
		String str3 = new String("java");
		String str4 = new String();
		
		System.out.println(str==str2);
		System.out.println(str3==str4);
		System.out.println(str4);
	}
}