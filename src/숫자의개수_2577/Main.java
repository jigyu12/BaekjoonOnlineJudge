package 숫자의개수_2577;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] num = String.valueOf(sc.nextInt() * sc.nextInt() * sc.nextInt()).split("");
		int[] count = new int[10];
		for(int i = 0; i < num.length; i++) {
			count[Integer.parseInt(num[i])]++;
		}
		for(int i = 0; i < count.length; i++) {
			System.out.println(count[i]);
		}
	}
}
