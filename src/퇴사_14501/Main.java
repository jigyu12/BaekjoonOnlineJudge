package 퇴사_14501;

import java.util.Scanner;

public class Main {

	private static int max;
	private static int count;
	private static int time[];
	private static int pay[];

	public static int dfs(int sum, int num) {
		int a = num;
		if (a + time[a]>= count) {
			if (a + time[a] == count) {
				sum += pay[a];
			}
			if (sum > max) {
				max = sum;
			}
			return 1;
		}
		sum += pay[a];
		for (int i = a + time[a]; i < count; i++) {
			dfs(sum, i);
		}

		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		count = sc.nextInt();
		time = new int[count];
		pay = new int[count];
		max = 0;
		for (int i = 0; i < count; i++) {
			time[i] = sc.nextInt();
			pay[i] = sc.nextInt();
		}
		for (int i = 0; i < count; i++) {
			dfs(0, i);
		}
		System.out.println(max);
	}
}
