package ¼öÀÇÇÕ_11720;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		sc.nextLine();
		int sum = 0;
        String[] word = sc.nextLine().split("");
		for(int i = 0; i < num; i++) {
            sum += Integer.parseInt(word[i]);
		}
		System.out.println(sum);
	}
}
