package 반복제어문3.형성평가03;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		for (int i = 1; i < (n * 2); i++) {
			if (i <= n) {
				for (int j = 1; j <= i; j++) {
					System.out.print("*");
				}
			}
			else {
				for(int j = 1; j <= (n*2) -i; j++) {
					System.out.print("*");
				}
			}
			System.out.println();
		}
		sc.close();
	}

}
