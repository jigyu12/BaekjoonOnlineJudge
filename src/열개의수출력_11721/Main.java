package 열개의수출력_11721;

import java.util.Scanner;
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String[] word = sc.nextLine().split("");
		int i = 0;
		while(i != word.length) {
			System.out.print(word[i]);
			if(i % 10 == 9 && i != 1) {
				System.out.println();
			}
			i++;
		}
	}
}