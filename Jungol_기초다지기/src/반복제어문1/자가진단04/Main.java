package 반복제어문1.자가진단04;
//1 2 3 4 5 6 7 8 9 10 100
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n;
		int count = 0;
		int total = 0;
		double avg = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			n = sc.nextInt();
			count++;
			total += n;
			if(n >= 100) break;
		}
		avg = (double)total / count;
		System.out.println(total);
		System.out.println(avg);
//		System.out.println(Math.round(avg * 10) / 10.0);
//		System.out.println(avg);
		
		sc.close();
	}

}
