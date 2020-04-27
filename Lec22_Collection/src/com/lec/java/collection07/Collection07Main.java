package com.lec.java.collection07;

import java.util.HashSet;
import java.util.Iterator;

public class Collection07Main {

	public static void main(String[] args) {
		System.out.println("HashSet 연습");
		
		// String 타입을 저장할 수 있는 HashSet 를 생성하고
		// 5개 이상의 데이터는 저장, 수정, 삭제 등의 동작을 해보고,
		// iterator, enhanced-for 문을 사용해서 출력해보기
		HashSet<String> set = new HashSet<String>();
		
		set.add("java");
		set.add("c");
		set.add("c++");
		set.add("c#");
		set.add("oracle");
		
		Iterator<String> itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		System.out.println();
		
		set.remove("c");
		set.add("kotlin");
		System.out.println("수정 후 ");
		for(String x : set ) {
			System.out.println(x);
		}
		System.out.println();
		
		set.remove("c#");
		System.out.println("삭제 후 ");
		itr = set.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
		
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class
















