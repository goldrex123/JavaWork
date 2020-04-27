package 반복제어문1.형성평가03;

//55 100 48 36 0 101
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int n;
		int cnt = 0;
		int sum =0;
		double avg = 0;
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			n = sc.nextInt();
			if(n < 0 || n > 100) break;
			cnt++;
			sum += n;
		}
		
		avg = (double)sum / cnt;
		
		System.out.println("sum : " + sum);
		System.out.println("avg : " + String.format("%.2f",avg));
		sc.close();
	}

}
