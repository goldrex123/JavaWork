package Number01;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		
		double num1;
		double num2;
		
		Scanner sc =new Scanner(System.in);
		
		num1 = sc.nextDouble();
		num2 = sc.nextDouble();
		
		System.out.println(String.format("%.1f", (num1+num2)));
		System.out.println(String.format("%.1f", (num1*num2)));
		
		sc.close();
	}

}
