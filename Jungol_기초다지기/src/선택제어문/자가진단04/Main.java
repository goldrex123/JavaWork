package 선택제어문.자가진단04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		double wei;
		
		Scanner sc = new Scanner(System.in);
		wei = sc.nextDouble();
		
		if(wei <= 50.80 ) {
			System.out.println("Flyweight");
		} else if(wei <= 61.23) {
			System.out.println("Lightweight");
		} else if(wei <= 72.57) {
			System.out.println("Middleweight");
		} else if(wei <= 88.45) {
			System.out.println("Cruiserweight");
		} else {
			System.out.println("Heavyweight");
		}
	}

}
