package com.lec.beans;

public class DAO {
	String uid; // DAO 객체 식별용 필드

	public DAO(String uid) {
		System.out.printf("DAO(%s) 생성\n", uid);
		this.uid = uid;
	}

	public DAO() {
		System.out.println("기본 생성자 호출");
	}
	
	@Override
	public String toString() {
		return String.format("[DAO: %s]", this.uid);
	}
}

class DAOEx extends DAO{
	public DAOEx() {
		super();
		System.out.println("DAOEx() 생성");
	}
	
	public DAOEx(String uid) {
		super(uid);
		System.out.printf("DAOEx(%s) 생성\n", uid);
	}
	
	@Override
	public String toString() {
		return String.format("[DAOEx: %s]", this.uid);
	}
}




