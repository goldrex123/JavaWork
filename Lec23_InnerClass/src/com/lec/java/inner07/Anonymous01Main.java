package com.lec.java.inner07;

/*
  Anonymous inner class(익명 내부 클래스):
   이름이 없는 local inner class
   이름이 없기 때문에 생성자를 만들 수가 없습니다.
   클래스의 정의와 동시에 인스턴스를 생성합니다.
*/
public class Anonymous01Main {

	public static void main(String[] args) {
		System.out.println("Anonymous Inner Class(익명 내부 클래스)");

		Person p = new Person("hulk");
		Readable r = p.createInstance(55);
		r.readInfo();

		Readable r2 = new Readable() {

			@Override
			public void readInfo() {
				System.out.println("r2의 readInfo 입니다.");
			}
		};
		r2.readInfo();

		Readable r3 = new Readable() {

			@Override
			public void readInfo() {
				System.out.println("r3의 readInfo 입니다.");
			}
		};
		r3.readInfo();

		new Readable() {

			public void readInfo() {
				System.out.println("따끈따끈한 readInfo");
			}
		}.readInfo();
		Movable mo = new Movable() {

			@Override
			public void move(int times) {
				System.out.println("move() " + times * speed);
			}
		};

		mo.move(2);
		mo.move(10);
		
		Myclass my1 = new Myclass();
		my1.aaa();
		my1.bbb();
		
		Myclass my2 = new Myclass() {
			@Override
			public void aaa() {
				System.out.println("AAA");
			}
		};
		my2.aaa();
		
		Myclass my3 = new Myclass() {
			//알트 쉬프트 s, v

			@Override
			public void aaa() {
				// TODO Auto-generated method stub
				super.aaa();
			}

			@Override
			public void bbb() {
				// TODO Auto-generated method stub
				super.bbb();
			}
			
		};
	} // end main()
} // end class Anonymous01Main

abstract class Movable {
	int speed = 100;

	public abstract void move(int times);

}

class Myclass{
	public void aaa() {
		System.out.println("aaa");
	}
	public void bbb() {
		System.out.println("bbb");
	}
}







