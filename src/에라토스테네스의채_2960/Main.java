package 에라토스테네스의채_2960;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		boolean[] ar = new boolean[1001];
		ar[0] = true;
		ar[1] = true;
		int count = 0;
		int num = 0;
		xx : for(int i = 0; i < n+1; i++) {
			if(!ar[i]) {
				for(int j = i ; j < n+1; j+=i) {
					
					if(ar[j]) {
						continue;
					}
					ar[j] = true;
					count++;
					if(count == k) {
						num = j;
						break xx;
					}
				}
			}
		}
		System.out.println(num);
	}
}
