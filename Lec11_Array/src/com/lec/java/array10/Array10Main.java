package com.lec.java.array10;

/* Enhanced for (향상된 for) 문
 	
 	for (배열타입 변수 : 배열이름) { ... }
 	
 */
public class Array10Main {

	public static void main(String[] args) {
		System.out.println("Enhanced for (향상된 for) 문");
		int[] arr = { 11, 22, 33, 44, 55 };

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println();

		System.out.println("Enhanced for (향상된 for) 문 사용");
		for (int value : arr) {
			System.out.println(value);
		}

		System.out.println();
		System.out.println("2차원 배열 Enhanced for (향상된 for) 문 사용");
		int[][] arr2 = { { 1, 2 }, { 3, 4, 5, 6 }, { 7, 8, 9 } };

		for (int[] row : arr2) {
			for (int value : row) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	} // end main()

} // end class Array10Main
