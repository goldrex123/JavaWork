package com.lec.java.loop03;

public class Loop03Main {

	public static void main(String[] args) {
		System.out.println("중첩 for 문 nested for");

		// 구구단 출력 : 중첩 for 사용
//		for (int i = 2; i <= 9; i++) {
//			System.out.println(i + "단");
//			for (int j = 1; j <= 9; j++) {
//				System.out.println(i + " x " + j + " = " + (i * j));
//			}
//		}
		System.out.println();
		// 구구단 출력 : 중첩 while 문 사용

		int i = 2;
		while(i <= 9)
		{			
			System.out.println(i + "단");
			int j = 1;
			while(j <= 9)
			{
				System.out.println(i + " x " + j + " = " + (i * j));
				j++;
			}
			i++;
		}
		
		System.out.println("\n프로그램 종료");

	} // end main()

} // end class
