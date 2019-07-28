package 방번호_1475;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] s = sc.nextLine().split("");
		boolean[] set = new boolean[10];
		int[] count = new int[10];
		for (int i = 0; i < s.length; i++) {
			if(s[i].equals("6") || s[i].equals("9")){
				if(!set[6] && !set[9]) {
					count[9]++;
				}
				if(!set[6]) {
					set[6] = true;
					continue;
				}
				else if(!set[9]) {
					set[6] = false;
					continue;
				}
			}
			
			count[Integer.parseInt(s[i])]++;
			
		}
		int ans = -1;
//		for (int i = 0; i < count.length; i++) {
//			System.out.print(count[i]);
//		}
//		System.out.println();
		for (int i = 0; i < count.length; i++) {
			if (count[i] > ans) {
				ans = count[i];
			}
		}
		System.out.println(ans);
	}
}
