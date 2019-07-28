package 피보나치함수_1003;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		int[][] ar = new int[41][2];
		ar[0][0] = 1;
		ar[0][1] = 0;
		ar[1][0] = 0;
		ar[1][1] = 1;
		for(int i = 2; i < ar.length; i++) {
			ar[i][0] = ar[i-1][0] + ar[i-2][0];
			ar[i][1] = ar[i-1][1] + ar[i-2][1];
		}
		for(int i = 0; i < test; i++) {
			int num = sc.nextInt();
			System.out.println(ar[num][0] + " " + ar[num][1]);
		}
	}
}
