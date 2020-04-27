package com.lec.java.while01;

/*
 	조건식이 true 인 동안 while 블럭 반복
 	
 	while(조건식 true / false){
 		.. 
 		..
 	}
 
 */
public class While01Main {

	public static void main(String[] args) {
		System.out.println("while 반복문");
		
		int count = 1;
		while(count <= 10) {
			System.out.println(count);
			count++;
		}
		System.out.println();
		
		int count2 = 10;
		while(count2 >= 1) {
			System.out.println(count2);
			count2--;
		}
		

	} // end main()
	
} // end class While01Main









