package 선택제어문.자가진단06;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int age;
		char gender;
		
		Scanner sc = new Scanner(System.in);
		
		gender = sc.next().charAt(0);
		age = sc.nextInt();
		
		if(gender == 'M') {
			if(age >= 18)
				System.out.println("MAN");
			else
				System.out.println("BOY");
		}
		else {
			if(age >= 18)
				System.out.println("WOMAN");
			else
				System.out.println("GIRL");			
		}
		sc.close();
	}

}
