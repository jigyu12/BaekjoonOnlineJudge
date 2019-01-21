package 피보나치수2_2748;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			BigInteger[] ar = new BigInteger[91];
			ar[0] = new BigInteger("0");
			ar[1] = new BigInteger("1");
			for(int i = 2; i < ar.length; i++) {
				ar[i] = ar[i-2].add(ar[i-1]);
			}
			int num = Integer.parseInt(br.readLine());
			System.out.println(ar[num].toString());
		} catch (NumberFormatException | IOException e) {
		}
	}
}
