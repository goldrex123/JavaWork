package 선택제어문.자가진단02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int wei, hei;
		int ob;
		Scanner sc = new Scanner(System.in);
		
		hei = sc.nextInt();
		wei = sc.nextInt();
		
		ob = wei + 100 - hei;
		
		if(ob > 0 ) {
			System.out.println(ob);
			System.out.println("Obesity");
		} else {
			System.out.println(ob);
		}
	}

}
