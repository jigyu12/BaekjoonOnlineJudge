package 수들의합2_2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			int[] ar = new int[n];
			String[] s = br.readLine().split(" ");
			int sum = 0;
			for(int i = 0; i < n; i++) {
				sum += Integer.parseInt(s[i]);
				ar[i] = sum;
			}
			int count = 0;
			for(int i = 0; i < n; i++) {
				for(int j = i; j < n; j++) {
					if(i > 0) {
						if(ar[j] - ar[i-1] == m) {
							count++;
						}
					}
					else {
						if(ar[j] == m) {
							count++;
						}
					}
				}
			}
			System.out.println(count);
		} catch (IOException e) {
		}
	}
}

