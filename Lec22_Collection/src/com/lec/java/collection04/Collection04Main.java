package com.lec.java.collection04;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Collection04Main {

	public static void main(String[] args) {
		System.out.println("ArrayList 연습");
		Scanner sc =new Scanner(System.in);
		
		ArrayList<MemberModel> list = new ArrayList<MemberModel>();
		
		for(int i= 0 ; i<3; i++) {
			System.out.print("아이디 입력  : ");
			String name = sc.nextLine();
			System.out.print("패스워드 입력  : ");
			String pw = sc.nextLine();
			
			MemberModel mm = new MemberModel(name, pw);
			list.add(mm);
		}
		
//		
//		for(MemberModel m : list) {
//			m.displayInfo();
//		}
		Iterator<MemberModel> itr = list.iterator();
		while(itr.hasNext()) {
			itr.next().displayInfo();
		}
		sc.close();
		System.out.println("\n프로그램 종료");
	} // end main()

} // end class












