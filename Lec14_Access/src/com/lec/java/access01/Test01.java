package com.lec.java.access01;

public class Test01 {

	private int privateNum; //자기 자신 클래스에서만
	int defaultNum; // 자기자신과 같은 패키지의 있는 클래스
	protected int protectedNum; //자기자신, 같은 패키지, 상속받은 클래스
	public int publicNum; //어디서든 사용 가능

	private void privateMethod() {}

	void defaultMethod() {}

	protected void protectedMethod() {}

	public void publicMethod() {}
}
