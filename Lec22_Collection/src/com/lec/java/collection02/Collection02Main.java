package com.lec.java.collection02;

import java.util.ArrayList;
import java.util.Iterator;

public class Collection02Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		// String 타입을 담는 ArrayList를 만들고
		// 5개 이상의 String을 저장하고
		// set(), remove() 등의 메소드 사용하여
		// 임의의 것을 수정, 삭제 도 해보시고
		// 3가지 방식으로 출력해보세요
		// for, Enhanced-for, Iterator
		ArrayList<String> list = new ArrayList<String>();

		list.add("자바");
		list.add("c");
		list.add("c++");
		list.add("php");
		list.add("html");

		System.out.println("for문 출력");
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}

		System.out.println("\n");

		list.set(2, "oracle");
		list.remove(4);
		System.out.println("향상된 for문 출력");
		for (String e : list) {
			System.out.print(e + " ");
		}

		System.out.println("\n");

		int n = (int) (Math.random() * list.size());
		list.set(n, "c#");
		Iterator<String> itr = list.iterator();
		System.out.println("Iterator 출력");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
