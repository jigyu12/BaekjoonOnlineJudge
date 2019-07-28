package 문자열반복_2675;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for(int i = 0; i < test ; i++) {
			int num = sc.nextInt();
			String[] s = sc.next().split("");
			for(int j = 0; j < s.length; j++) {
				for(int k = 0; k < num; k++) {
					System.out.print(s[j]);
				}
			}
			System.out.println();
		}
	}
}
