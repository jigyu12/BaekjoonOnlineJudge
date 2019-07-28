package 양념반후라이드반_16917;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	private static int a;
	private static int b;
	private static int c;
	private static int x;
	private static int y;
	private static int ans;
	private static int low;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		a = Integer.parseInt(s[0]);
		b = Integer.parseInt(s[1]);
		c = Integer.parseInt(s[2]);
		x = Integer.parseInt(s[3]);
		y = Integer.parseInt(s[4]);
		ans = 0;
		low = x < y ? x : y;
		
		if(a + b < 2 * c) {
			ans += ( low * a + low * b);
			x -= low;
			y -= low;
			if(x < y) {
				if(b < 2 * c) {
					ans += y * b;
				}
				else {
					ans += y * 2 * c;
				}
			}
			else {
				if(a < 2 * c) {
					ans += x * a;
				}
				else {
					ans += x * 2 * c;
				}
			}
		}
		else {
			ans += ( low * 2 * c);
			x -= low;
			y -= low;
			if(x < y) {
				if(b < 2 * c) {
					ans += y * b;
				}
				else {
					ans += y * 2 * c;
				}
			}
			else {
				if(a < 2 * c) {
					ans += x * a;
				}
				else {
					ans += x * 2 * c;
				}
			}
		}
		System.out.println(ans);
	}
}
