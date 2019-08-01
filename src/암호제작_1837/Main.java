package 암호제작_1837;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws IOException {
		String[] pk = br.readLine().split(" ");
		
		BigInteger p = new BigInteger(pk[0]);
		BigInteger k = new BigInteger(pk[1]);
		
		boolean[] sosu = new boolean[1000001];
		sosu[0] = true;
		sosu[1] = true;
		for(int i = 2; i < Math.sqrt(sosu.length); i++) {
			for(int j = i+i; j < sosu.length; j+=i) {
				if(!sosu[j]) {
					sosu[j] = true;
				}
			}
		}
		
		boolean good = true;
		BigInteger ans = new BigInteger("0");
		int idx = Integer.parseInt(k.toString());
		
		for(int i = 2; i < idx; i++) {
			if(!sosu[i]) {
				BigInteger div = new BigInteger(String.valueOf(i));
				
				if(p.mod(div).equals(new BigInteger("0"))) {
					good = false;
					ans = div;
					break;
				}
			}
		}
		
		if(good) {
			System.out.println("GOOD");
		}
		else {
			System.out.println("BAD "+ans.toString());
		}
	}

}
