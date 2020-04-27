package com.lec.java.input02;

import java.util.Scanner;

// 문자열(String) 입력
// char 입력
public class Input02Main {

	public static void main(String[] args) {
		System.out.println("표준입력: String, char");
		Scanner sc = new Scanner(System.in);
		
//		//String 입력
//		System.out.println("이름을 입력하시오.");
//		String name = sc.nextLine(); //엔터를 입력할 때 까지의 모든 문자들을 문자열로 리턴
//		System.out.println("별명입력.");
//		String nick = sc.nextLine();
//		System.out.println(name + " " + nick);
		
		//char입력 (nextChar() 없다)
		System.out.println("성별입력");
		char gender = sc.next().charAt(0);
		System.out.println(gender);
		
		System.out.println("나이입력");
		int age = sc.nextInt();//키보드 버퍼 속 숫자 만 취해가고 마지막 엔터는 남아 있는 상태
		System.out.println("주소 입력");
		//숫자 입력 받은 뒤 문자열 입력 시에는 반드시 \n(줄바꿈) 을 consume(버퍼에서 제거) 해야한다
		sc.nextLine();
		String addr = sc.nextLine();
		
		System.out.println(age + " " + addr);
		sc.close();
	}

}

