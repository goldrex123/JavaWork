package Number04;

import java.util.Arrays;
import java.util.Scanner;

public class Problem4 {

	public static void main(String[] args) {
		final int MAX_SIZE = 3;

		Scanner sc = new Scanner(System.in);
		int[] arr = new int[MAX_SIZE];

		int i = 0;
		while (true) {
			arr[i] = sc.nextInt();
			if (arr[i] == 0)
				break;
			i++;
			if (i > arr.length - 1) {
				arr = Arrays.copyOf(arr, arr.length + MAX_SIZE);
			}
		}

		int max = arr[0];
		int min = arr[0];
		
		for (int j = 0; j < arr.length; j++) {
			if (max < arr[j])
				max = arr[j];
			if ((arr[j] != 0) && (min > arr[j]))
				min = arr[j];

		}
		System.out.println("max = " + max);
		System.out.println("min = " + min);

		sc.close();
	}

}
