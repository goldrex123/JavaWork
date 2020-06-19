package ex3_1;

public class Operand {
	int value;

	public Operand(int value) {
		System.out.println("호출?");
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
}
