package 평균점수_10039;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		for(int i = 0; i < 5; i++) {
			int num = sc.nextInt();
			if(num < 40) {
				sum+= 40;
				continue;
			}
			sum += num;
		}
		System.out.println(sum / 5);
	}

}
