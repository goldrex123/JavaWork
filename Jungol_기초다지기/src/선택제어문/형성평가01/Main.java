package 선택제어문.형성평가01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a,b;
		int result;
		
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		result = (a>b) ? (a-b) : (b-a);
		System.out.println(result);
		
		sc.close();
	}

}
