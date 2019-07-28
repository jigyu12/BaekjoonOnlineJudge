package 돌게임_9655;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		BigInteger b = new BigInteger("123");
		if(num % 2 == 0) {
			System.out.println("CY");
		}
		else {
			System.out.println("SK");
		}
		
	}
}
