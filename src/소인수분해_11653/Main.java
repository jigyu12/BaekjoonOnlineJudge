package 소인수분해_11653;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] ar = new boolean[10000001];
		ar[0] = true;
		ar[1] = true;
		int num = Integer.parseInt(br.readLine());
		for(int i = 0; i < ar.length; i++) {
			if(!ar[i]) {
				for(int j = i; j < ar.length; j+=i) {
					ar[j] = true;
				}
			}
		}
		while(num > 1) {
			for(int i = 2; i < ar.length; i++) {
				if(ar[i] && num % i == 0) {
					while(num % i == 0) {
						num /= i;
						System.out.println(i);
					}
				}
			}
		}
	}
}
