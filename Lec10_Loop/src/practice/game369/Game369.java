package practice.game369;

public class Game369 {
	public static void main(String[] args) {

		for (int i = 1; i <= 100; i++) {
			if ((i % 10 == 3 || i % 10 == 6 || i % 10 == 9) || (i / 10 == 3 || i / 10 == 6 || i / 10 == 9))
				System.out.print("*" + "\t");
			else
				System.out.print(i + "\t");
			if (i % 10 == 0)
				System.out.println();
		}

		System.out.println("----------------------------------------------------------------------------- string 사용");

		for (int i = 1; i <= 100; i++) {
			String str = i + "";

			if (str.contains("3") || str.contains("6") || str.contains("9")) {
				System.out.print("*" + "\t");
			} else {
				System.out.print(str + "\t");
			}
			if (i % 10 == 0)
				System.out.println();
		}
	}
}
