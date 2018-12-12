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
			int minus = x - y;

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
				System.out.println("enter!@#");
				while (a != start + 1 || b != end + 1) {
					if (Integer.parseInt(bst.toString()) < count) {
						break;
					}
					if (a - b == minus) {
						while (a != x || b != y) {
							a++;
							b++;
							count++;
							System.out.println(a + " " + b + " " + count);
							find = true;
							continue;
						}
						break;
					}

					int c = (end - b + 1);
					a += c;
					if(a == start) {
						a++;
						b++;
						count++;
					}
					if (a > start) {
						a -= start;
					}
					
					count += c;
					System.out.println(a + " " + b + " " + count);

				}
			} else if (start <= end) {
				System.out.println("enter");
				while (a != start + 1 || b != end + 1) {
					if (Integer.parseInt(bst.toString()) < count) {
						break;
					}
					if (a - b == minus) {
						while (a != x || b != y) {
							a++;
							b++;
							count++;
							System.out.println(a + " " + b + " " + count);
							find = true;
							continue;
						}
						break;
					}

					int c = (start - a + 1);
					b += c;
					if(b == end) {
						a++;
						b++;
						count++;
					}
					if (b > end) {
						b -= end;
					}
					a = 1;
					count += c;
					 System.out.println(a + " " + b + " " + count);

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
