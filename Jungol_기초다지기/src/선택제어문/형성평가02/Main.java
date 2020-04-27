package 선택제어문.형성평가02;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a;
		
		Scanner sc = new Scanner(System.in);
		a = sc.nextInt();
		
		if(a>0)
		{
			System.out.println("plus");
		}
		else if (a<0) {
			System.out.println("minus");
		}
		else {
			System.out.println("zero");
		}
		sc.close();
	}

}
