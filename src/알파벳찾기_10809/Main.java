package 알파벳찾기_10809;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int[] ar = new int[26];
		for (int i = 0; i < 26; i++) {
			ar[i] = -1;
		}
		for (int i = s.length()-1; i >= 0; i--) {
			char c = s.charAt(i);
			ar[c - 97] = i;
		}
		for (int i = 0; i < 26; i++) {
			System.out.printf("%d ", ar[i]);
		}
	}
}
