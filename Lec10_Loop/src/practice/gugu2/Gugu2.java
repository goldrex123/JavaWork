package practice.gugu2;

public class Gugu2 {

	public static void main(String[] args) {

		for (int i = 2; i <= 8; i += 3) {
			for (int j = 1; j <= 9; j++) {
				System.out.print(i + " x " + j + " = " + String.format("%3d", i * j) + "\t");
				System.out.print((i + 1) + " x " + j + " = " + String.format("%3d", (i + 1) * j) + "\t");
				if (i != 8)
					System.out.print((i + 2) + " x " + j + " = " + String.format("%3d", (i + 2) * j));

				System.out.println();
			}
			System.out.println();
		}
	}
}
