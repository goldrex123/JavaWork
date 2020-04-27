package 선택제어문.형성평가05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int month;
		Scanner sc = new Scanner(System.in);
		month = sc.nextInt();
		
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			System.out.println("31");
			break;
		case 2:
			System.out.println("28");
			break;
		case 4: case 6: case 9: case 11:
			System.out.println("30");
			break;
		}
		
		sc.close();
	}

}
