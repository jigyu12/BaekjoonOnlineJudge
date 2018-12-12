package Ä«À×´Þ·Â_6064;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		for (int i = 0; i < test; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();

			int a = 1;
			int b = 1;
			int count = 0;
			boolean find = false;
			BigInteger bst = new BigInteger(String.valueOf(start));
			BigInteger bed = new BigInteger(String.valueOf(end));
			BigInteger gcd = bst.gcd(bed);
			bst = bst.divide(gcd);
			bed = bed.divide(gcd);
			bst = bst.multiply(bed).multiply(gcd);
			if (start > end) {
				count += (y - b);
				a += (y - b);
				b += (y - b);
				while (Integer.parseInt(bst.toString()) >= count) {
					if(a == x) {
						find = true;
						break;
					}
					a += end;
					count += end;
					if (a > start) {
						a -= start;
					}
				}
			} else if (start < end) {
				count += (x - a);
				b += (x - a);
				a += (x - a);
				while (Integer.parseInt(bst.toString()) >= count) {
					
					if(b == y) {
						find = true;
						break;
					}
					b += start;
					count += start;
					if (b > end) {
						b -= end;
					}
				}
			}
			if (find) {
				System.out.println(count + 1);
			} else {
				System.out.println(-1);
			}
		}
	}
}
