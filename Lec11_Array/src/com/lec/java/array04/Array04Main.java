package com.lec.java.array04;

import java.util.Arrays;
import java.util.Scanner;

/* 연습
 * 길이 5개 int 형 배열을 선언하고
 * 사용자로부터 5개 정수를 입력받아 초기화 한뒤 
 * 
 * 총점, 평균, 최대값, 최소값  출력해보기
 */
public class Array04Main {

	public static void main(String[] args) {
		System.out.println("배열 연습");
		int[] arr = new int[5];
		int total = 0;
		double avg = 0;
		Scanner sc = new Scanner(System.in);
		
		int max = arr[0];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
			total += arr[i];
			if(arr[i] > max)
				max = arr[i];
		}
		avg = total / (double)arr.length;

//		Arrays.sort(arr);

		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg);
//		System.out.println("최소값 : " + arr[0]);
		System.out.println("최대값 : " + max);
//
//		sc.close();
	
	} // end main()

} // end class Array04Main
