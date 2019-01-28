package one_4375;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int count = 0;
			int num = sc.nextInt();
			int r = 100;
			int a = 1;
			while (r > 0) {
				r = a % num;
				a = r * 10 + 1;
				count++;
			}
			System.out.println(count);
		}	
	}
}
