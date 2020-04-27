package 선택제어문.자가진단05;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double d1,d2;
		
		Scanner sc = new Scanner(System.in);
		
		d1 = sc.nextDouble();
		d2 = sc.nextDouble();
		
		if(d1 >= 4.0 && d2 >= 4.0) {
			System.out.println("A");
		} else if(d1 >= 3.0 && d2 >= 3.0) {
			System.out.println("B");
		} else {
			System.out.println("C");
		}
		
	}

}
