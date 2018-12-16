package 수정렬하기_2750;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] ar = new int[num];
		for(int i = 0; i < num; i++) {
			ar[i] = sc.nextInt();
		}
		Arrays.sort(ar);
		for(int i = 0; i < num; i++) {
			System.out.println(ar[i]);
		}
	}
}
