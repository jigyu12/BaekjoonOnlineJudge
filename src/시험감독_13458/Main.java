package 시험감독_13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int[] ar = new int[n];
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(s[i]);
		}
		
		String[] bc = br.readLine().split(" ");
		int b = Integer.parseInt(bc[0]);
		int c = Integer.parseInt(bc[1]);
		
		long ans = n;
		for(int i = 0; i < n; i++) {
			int num = ar[i] - b - 1;
			if(num >= 0) {
				ans += (num / c) + 1;
			}
			
		}
		
		System.out.println(ans);
	}

}
