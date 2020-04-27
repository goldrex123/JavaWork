package com.lec.java.array09;

/* ragged array: column(열)의 개수가 일정하지 않은 배열

	가변 배열 선언 방법: 행의 개수만 지정을 하고, 열의 개수는 비워둠
	열(column)이 몇 개가 될 지 모르기 때문에 메모리 할당이 되지 않습니다.
 */
public class Array09Main {

	public static void main(String[] args) {
		System.out.println("Ragged Array(가변 배열)");
		
		int[][] arr1 = new int[3][]; //int[] 3개짜리 2차원 배열 객체만 생성
		arr1[0] = new int[] {10};
		arr1[1] = new int[] {11,12};
		arr1[2] = new int[] {13,14,15};
		
//		int[] temp = arr1[1];
//		arr1[1] = arr1[2];
//		arr1[2] = temp;  // 서로 바꾸는 것도 가능
		
		for (int x = 0; x < arr1.length; x++) {
			for (int y = 0; y < arr1[x].length; y++) {
				System.out.print(arr1[x][y] + " ");  //NullPointerException 
			}
			System.out.println();
		}
		
	} // end main()

} // end class Array09Main

