package 분수합_1735;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s1 = br.readLine().split(" ");
		String[] s2 = br.readLine().split(" ");
		int a = Integer.parseInt(s1[0]);
		int b = Integer.parseInt(s1[1]);
		int c = Integer.parseInt(s2[0]);
		int d = Integer.parseInt(s2[1]);
		int down = b * d;
		int up = a * d + b * c;
		BigInteger dd = new BigInteger(String.valueOf(down));
		BigInteger uu = new BigInteger(String.valueOf(up));
		BigInteger gcd = dd.gcd(uu);
		dd = dd.divide(gcd);
		uu = uu.divide(gcd);
		System.out.println(uu + " " + dd);
	}
}
