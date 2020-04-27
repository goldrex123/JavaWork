package Number06;

//class Money {
//
//	public String country = "Canada";
//
//	public String getC() {
//		return country;
//	}
//
//}
//
//class Yen extends Money {
//
//	public String getC() {
//		return super.country;
//	}
//}
//
//public class Euro extends Money {
//
//	public String getC(int x) {
//		return super.getC();
//	}
//
//	public static void main(String[] args) {
//		System.out.print(new Yen().getC()+ " " + new Euro().getC());
//	}
//
//}

// country가 private  타입이어서 yen의 getC메소드에서 country변수를 사용할 수 없다

class Euro {
	public static void parse(String str) {

		float f = 0;
		try {
			f = Float.parseFloat(str);
		} catch (NumberFormatException nfe) {
			f = 0;
		} finally {
			System.out.println(f);
		}

	}

	public static void main(String[] args) {

		parse("invalid");

	}
}

//float f가 try {...} 안의 지역 변수이기 때문에 catch절이나 finall절에서 사용 불가능