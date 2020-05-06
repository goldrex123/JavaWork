package Number01;

import java.util.Scanner;

public class Problem1 {

	public static void main(String[] args) {
		String s = "AB";
		int n = 1;
		String answer = "";

		char c[] = s.toCharArray();
		
		for(int i = 0 ; i<c.length; i++){
			if(c[i] != ' '){
				c[i] = (char)(c[i] + n);
			}
		}

		answer = String.valueOf(c);
		System.out.println(answer);
		
		
	}

}
