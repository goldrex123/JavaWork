package 선택제어문.자가진단09;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a,b,c;
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		
		int min = (a<b) ? ((a<c) ? a : c ) : b;
	
		
		System.out.println(min);
		
		sc.close();
	}

}
