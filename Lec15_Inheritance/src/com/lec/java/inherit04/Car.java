package com.lec.java.inherit04;

public class Car extends Vehicle {
	
	int oil;
	
	public Car() {
		//부모클래스의기본 생성자 호출 --> Vehicle()
		//명시적으로 super 생성자가 없으면 부모의 기본 생성자를 호출하게 됨
		System.out.println("Car() 생성");
	}
	
	public Car(int oil) {
		//super()는 반드시 생성자 코드의  '첫 번째 문장' 이어야 함
		super(); // super: 부모를 의미, super() <-- 부모의 기본생성자 호출
		this.oil = oil;
		System.out.println("Car(int) 생성: oil = " + oil);
	}
	
	public Car(int speed, int oil) {
		super(speed);
		this.oil = oil;
		System.out.println("Car(int ,int) 생성 : speed= " + speed + " oil= " + oil );
	}
	
	public Car(double value) {
		this(555, (int)value); //자기 생성자 호출 , 생성자 위임(delegation)
		System.out.println("Car(double) 생성 : value= " + value);
	}
}
