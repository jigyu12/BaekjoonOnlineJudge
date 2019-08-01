package 최대공약수_2824;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int aa = Integer.parseInt(br.readLine());
		String[] sa = br.readLine().split(" ");
		int bb = Integer.parseInt(br.readLine());
		String[] sb = br.readLine().split(" ");
		BigInteger a = new BigInteger("1");
		for(int i = 0; i < sa.length; i++) {
			a = a.multiply(new BigInteger(sa[i]));
		}
		BigInteger b = new BigInteger("1");
		for(int i = 0; i < sb.length; i++) {
			b = b.multiply(new BigInteger(sb[i]));
		}
		
		BigInteger gcd = a.gcd(b);
		if(gcd.toString().length() >= 10) {
			String[] g = gcd.toString().split("");
			for(int i = g.length-9; i < g.length; i++) {
				bw.write(g[i]);
			}
		}
		else {
			bw.write(gcd.toString());
		}
		bw.flush();
			
	}
}
