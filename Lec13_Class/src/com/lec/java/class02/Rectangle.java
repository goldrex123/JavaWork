package com.lec.java.class02;

public class Rectangle {

	double width;
	double height;

	public Rectangle() {
		System.out.println("Rectangle() 생성");
		width = 100;
		height = 100; // 디폴트 값 지정 가능
		System.out.println("가로 : " + width);
		System.out.println("세로 : " + height);
	}

	public Rectangle(double w, double h) {
		System.out.println("Rectangle(w,h) 생성");
		width = w;
		height = h;
		System.out.println("가로 : " + width);
		System.out.println("세로 : " + height);
	}

	public double calcPerimeter() {
		return (2 * width) + (2 * height);
	}
	public double calcArea() {
		return width * height;
	}

}
