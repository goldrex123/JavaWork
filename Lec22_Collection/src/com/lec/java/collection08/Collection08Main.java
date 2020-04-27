package com.lec.java.collection08;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Collection08Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");

		Scanner sc= new Scanner(System.in);
		// MyClass 타입을 저장할 수 있는 HashSet 인스턴스 생성
		// 데이터 3개 이상 저장해보고 iterator, enahnce-for 등을
		// 사용하여 출력해보기
		HashSet<MyClass> set = new HashSet<MyClass>();
		
		for(int i= 0; i<3; i++) {
			System.out.println("id 입력 : ");
			int id = sc.nextInt();
			sc.nextLine();
			System.out.println("name 입력 : ");
			String name = sc.nextLine();
			
			MyClass mc = new MyClass(id, name);
			
			set.add(mc);
		}
		
		System.out.println("size = " + set.size());
		// 검색: Iterator, enhanced for
		System.out.println();
		System.out.println("Iterator");
		Iterator<MyClass> itr = set.iterator();
		
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();
		System.out.println("enhanced for");
		// TODO

		// forEach() 메소드 사용
		System.out.println();
		System.out.println("forEach() 사용");
		// TODO
		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()
} // end class
