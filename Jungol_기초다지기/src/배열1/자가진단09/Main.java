package 배열1.자가진단09;

import java.util.Arrays;
//95 100 88 65 76 89 58 93 77 99
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int[] arr = new int[10];

		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0, k = 1; j < arr.length - i - 1; j++, k++) {
				if (arr[j] < arr[k]) {
					int temp = arr[k];
					arr[k] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}
}
