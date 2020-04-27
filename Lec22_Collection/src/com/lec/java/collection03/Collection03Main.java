package com.lec.java.collection03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection03Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		Scanner sc = new Scanner(System.in);
		
		// Student 타입을 담는 ArrayList를 만드고
		// 사용자로부터 3개의 Student 데이터 을 입력받아서 (id, name, kor, eng, math)
		// 3가지 방법으로 출력해보세요.
		// for, Enhanced-for, Iterator
		Student stu =new Student();
		Score scr = new Score();
		
		ArrayList<Student> list = new ArrayList<Student>();
		
		for(int i = 0; i<3 ; i++) {
			System.out.print("id : ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.print("name : ");
			String name = sc.nextLine();
			System.out.print("kor : ");
			int kor = sc.nextInt();
			System.out.print("eng : ");
			int eng = sc.nextInt();
			System.out.print("math : ");
			int math = sc.nextInt();
			Student std = new Student(id, name, new Score(kor, eng, math));
			
			list.add(std);
		}
		
//		for(int i = 0; i<list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		Iterator<Student> itr = list.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
