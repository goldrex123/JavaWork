package practice.isogram;

import java.util.Arrays;
import java.util.Scanner;

/*	Isogram
	 문자열을 입력받으면 isogram 여부를 판단하여 true/false 를 출력하다가, quit 가 입력되면 종료
	isogram 이란?  : 중복된 알파벳이 없는 단어
	
	 isogram 예) Machine, isogram, Alphabet, quit
 */
public class Isogram {

	// TODO : 필요한 메소드 있으면 추가 작성

	public static void main(String[] args) {
		boolean right = false;
	
		Scanner sc = new Scanner(System.in);
		String str = "";
		while (true) {
			str = sc.nextLine();
			if (str.trim().equalsIgnoreCase("quit")) {
				System.out.println("종료");
				break;
			}
			str = str.toLowerCase();
			String[] spl = str.split("");

			for (int i = 0; i < str.length() - 1; i++) {
				if (str.substring(i + 1).indexOf(str.charAt(i)) != -1) {
					right = false;
					break;
				}
				
				else {
					right = true;
				}
			}
			System.out.println((right == true)? "맞아!" : "아냐!");
		}
		sc.close();
	} // end main()
} // end class
