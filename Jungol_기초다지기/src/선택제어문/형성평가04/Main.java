package 선택제어문.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int number;

		Scanner sc = new Scanner(System.in);
		System.out.print("Number? ");
		number = sc.nextInt();

//		switch (number) {
//		case 1:
//			System.out.println("dog");
//			break;
//		case 2:
//			System.out.println("cat");
//			break;
//		case 3:
//			System.out.println("chick​");
//			break;
//		default:
//			System.out.println("I don't know.");
//		}
		
		if(number == 1)
			System.out.println("dog");
		else if (number == 2)
			System.out.println("cat");
		else if (number == 3)
			System.out.println("chick");
		else
			System.out.println("I don't know.");
		
		sc.close();
	}

}
