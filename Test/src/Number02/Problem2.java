package Number02;

import java.util.Scanner;

public class Problem2 {

	public static void main(String[] args) {
		
		String str1;
		String str2;
		String str3;
		
		Scanner sc = new Scanner(System.in);
		
		str1 = sc.nextLine();
		str2 = sc.nextLine();
		str3 = sc.nextLine();
		
		System.out.print(str1.substring(0, 2) + str2.substring(0, 1) + str3.substring(0, 1));
		
		sc.close();
	}

}
