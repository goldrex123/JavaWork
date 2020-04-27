package com.lec.java.array02;

/*  배열의 선언과 초기화
 	
 	배열 선언 따로, 초기화 따로
		타입[] 이름 = new 타입[배열의 길이];
		
	배열을 선언과 동시에 초기화 1
		타입[] 이름 = new 타입[] {a, b, c, ...};
		
	배열을 선언과 동시에 초기화 2
		타입[] 이름 = {a, b, c, ...};
		
	배열의 길이를 자동으로 알 수 있는 방법
		배열이름.length 
 */
public class Array02Main {

	public static void main(String[] args) {
		System.out.println("배열의 선언과 초기화");

		int[] korean = new int[3];

		korean[0] = 100;
		korean[1] = 90;
		korean[2] = 80;

		for (int i = 0; i < korean.length; i++) {
			System.out.println(korean[i]);
		}
		System.out.println();
		// 선언과 동시에 초기화
		int[] english = new int[] { 30, 20, 30 };
		for (int i = 0; i < english.length; i++) {
			System.out.println(english[i]);
		}
		System.out.println();

		int[] math = { 99, 88, 77, 66 }; // new int[] {99,88,77,66}
		for (int i = 0; i < math.length; i++) {
			System.out.println(math[i]);
		}
		System.out.println();
		int total = 0;
		double avg = 0;//수학 점수들의 총점과 평균계산
		for (int i = 0; i < math.length; i++) {
			total += math[i];
		}
		avg = total / (double)math.length;
		System.out.println(total);
		System.out.println(avg);
		
		System.out.println(); 
		System.out.println(math); //배열변수 출력 
	} // end main()

} // end class Array02Main
