package com.lec.java.inner01;

/*
 Inner Class(내부 클래스)
 1. Member inner class(멤버 내부 클래스): 다른 클래스 내부에서 선언된 클래스
 2. Static inner class(static 내부 클래스): 다른 클래스의 내부에서 static으로 선언된 클래스
 3. Local class(지역 클래스)
   1) Local inner class(지역 내부 클래스): 메소드 내부에서 선언된 클래스
   2) Anonymous inner class(익명 내부 클래스): 이름이 없는 local class
*/

public class Inner01Main {

	public static void main(String[] args) {
		System.out.println("Member Inner Class(멤버 내부 클래스)");
		
		//외부 클래스의 인스턴스 생성
		TestOuter out = new TestOuter(100);
		
		// 멤버 내부 클래스의 인스턴스 생성
		// 멤버 내부 클래스의 이름: [외부클래스 이름].[멤버 내부클래스 이름]
		// [외부클래스 이름].[내부클래스 이름] 참조변수 =
		//      [외부클래스 인스턴스].new 내부클래스 생성자();
		TestOuter.TestInner in = out.new TestInner(111);
		
		in.printOuterValue();
		in.printInnerValue();
		
		System.out.println();
		
		//하나의 외부 클래스 인스턴스를 이용해서
		// 멤버 내부 클래스의 인스턴스 여러개 생성가능
		TestOuter.TestInner in2 = out.new TestInner(123);
		in2.printOuterValue();
		in2.printInnerValue();
		
		System.out.println();
		
		TestOuter out2 = new TestOuter(12);
		TestOuter.TestInner in4 = out2.new TestInner(14);
		TestOuter.TestInner in5 = out2.new TestInner(15);
		
		in4.printOuterValue();
		in4.printInnerValue();
		
		System.out.println();
		
		in5.printOuterValue();
		in5.printInnerValue();
		
		System.out.println();
		
		TestOuter.TestInner in7 = new TestOuter(30).new TestInner(330);
		in7.printOuterValue();
		in7.printInnerValue();
		
	} // end main()

} // end class Inner01Main
















