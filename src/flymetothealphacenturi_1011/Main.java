package flymetothealphacenturi_1011;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int i = 0; i < test; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int dist = end - start;
			int count = 2;
			int year = 1;
			if (dist == 2) {
				System.out.println(2);
				continue;
			} else if (dist == 1) {
				System.out.println(1);
				continue;
			} else if (dist > 2) {
				while (dist >= 0) {
					dist -= (2 * year++);
					if (dist <= year) {
						System.out.println(++count);
						break;
					} else if (dist <= year * 2) {
						count += 2;
						System.out.println(count);
						break;
					}
					count += 2;
				}
			}
		}
	}
}
