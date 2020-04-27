package com.lec.java.oop03;

public class HybridCar extends Car{

	private int elec;

	public int getElec() {return elec;}
	public void setElec(int elec) {this.elec = elec;}
	
	@Override
	public void displayInfo() {
		System.out.println("--- HybridCar 정보 ---");
		System.out.println("speed : " + getSpeed());
		System.out.println("Oil : " + getOil());
		System.out.println("electricity : " + elec);
	}
}
