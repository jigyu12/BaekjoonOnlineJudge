package 보석줍기_2208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int[] ar = new int[n];
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += Integer.parseInt(br.readLine());
			ar[i] = sum;
		}

		int ans = 0;
		int idx = n - m + 1;
		for(int i = n-1; i >= m-1; i--) {
			sum += ar[i];
			ar[i] = sum;
			if(i < idx) {
				if(ar[i] > ans) {
					ans = ar[i];
				}
			}
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();
	
		System.out.println(ans);
	}
}
