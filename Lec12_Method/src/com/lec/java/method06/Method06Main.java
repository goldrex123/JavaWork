package com.lec.java.method06;

/* Method Overloading (메소드 중복 정의)
	 같은 이름으로 메소드를 매개변수 리스트를 달리하여 중복 정의, 
	 즉, 이름이 같아도 메소드 signature 가 다르면 중복정의 가능.
	
  Method Signature 란
	   메소드 이름 + 매개변수 리스트 (parameter list)
	
	 1. 매개변수의 개수가 다르거나
	 2. 매개변수의 자료형이 다르거나
	 3. 매개변수의 순서가 다를 때
	 위 3개를 '매개변수 리스트' 라 한다
	
    메소드의 리턴 타입만 다른 경우는 중복 정의할 수 없다!!

     메소드 오버로딩의 장점:
	동일한 동작을 하는 메소드에 대해 매개변수만 달리하여 중복정의 하면
	이 메소드를 사용하는 입장에선 여러타입의 이름을 익힐 필요가 없다. 

 */

public class Method06Main {

	public static void main(String[] args) {
		System.out.println("Method Overloading (메소드 중복 정의)");

		sayHello();
		System.out.println();
		sayHello("남윤주");
		System.out.println();
		sayHello(27);
		System.out.println();
		sayHello("김준영", 26);
		System.out.println();
		sayHello(27, "김준영");
		System.out.println();
		
		byte b = 10;
		sayHello(b); //short타입 메소드로 사용 
		System.out.println();
		
		//메소드 오버로딩의 장점 
		System.out.println(10);
		System.out.println(3.14);
		System.out.println("Hello");
		System.out.println(new int[4]);
		
		System.out.println("\n프로그램 종료");
	} // end main()

	public static void sayHello() {
		System.out.println("sayHello() <-- signature");
		System.out.println("안녕하세요");
	}

//	public static int sayHello() {
//	} //리턴 타입만 다른 것은 오버로딩 안된다.

	public static void sayHello(String name) {
		System.out.println("sayHello(String) <-- signature");
		System.out.println("안녕하세요!!");
		System.out.println("제 이름은" + name + "입니다");
	}

	public static void sayHello(int age) {
		System.out.println("sayHello(int) <-- signature");
		System.out.println("안녕하세요!!");
		System.out.println("제 나이는 " + age + " 입니다");
	}
	
	public static void sayHello(short age) {
		System.out.println("sayHello(short) <-- signature");
		System.out.println("안녕하세요!!");
		System.out.println("제 나이는 " + age + " 입니다");
	}

	public static void sayHello(String name, int age) {
		System.out.println("sayHello(String, int) <-- signature");
		System.out.println("안녕하세요!!");
		System.out.println("제 이름은 " + name + " 입니다");
		System.out.println("제 나이는 " + age + " 입니다");
	}
	
	public static void sayHello(int ag, String name) {
		System.out.println("sayHello(int, String) <-- signature");
		System.out.println("안녕하세요!!");
		System.out.println("제 나이는 " + ag + " 입니다");
		System.out.println("제 이름은 " + name + " 입니다");
	}

} // end class
