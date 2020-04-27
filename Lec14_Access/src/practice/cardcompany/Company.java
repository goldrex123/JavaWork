package practice.cardcompany;

public class Company {
	
	int cardNum = 10000;
	
	private Company() {
		
	}
	
	private static Company instance = null;
	public static Company getInstance() {
		if(instance == null) {
			instance = new Company();
		}
		return instance;
	}
	// 필요한 변수, 메소드, 생성자 정의하기
	
	public Card createCard() {
		return new Card(++cardNum);
	}
} // end class