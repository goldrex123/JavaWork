package 선택제어문.자가진단01;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int number;
		
		Scanner sc = new Scanner(System.in);
		
		number = sc.nextInt();
		
		if(number < 0) {
			System.out.println(number);
			System.out.println("minus");
		} else {
			System.out.println(number);
		}
		sc.close();
	}

}
