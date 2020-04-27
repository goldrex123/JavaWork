package 반복제어문2.형성평가08;
//1 2 3 4
//2 4 6 8
//3 6 9 12
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int a, b;

		Scanner sc = new Scanner(System.in);

		a = sc.nextInt();
		b = sc.nextInt();

		for (int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				System.out.print((i * j)  + " ");
			}
			System.out.println();
		}
		sc.close();
	}

}
