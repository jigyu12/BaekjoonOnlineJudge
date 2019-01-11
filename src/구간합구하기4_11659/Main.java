package 구간합구하기4_11659;

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
			int[] sumAr = new int[n];
			int sum = 0;
			String[] s = br.readLine().split(" ");
			for(int i = 0; i < n; i++) {
				int num = Integer.parseInt(s[i]);
				sum += num;
				sumAr[i] = sum;
			}
			for(int i = 0; i < m; i++) {
				String[] t = br.readLine().split(" ");
				int a = Integer.parseInt(t[0]);
				int b = Integer.parseInt(t[1]);
				if(a <= 1) {
					System.out.println(sumAr[b-1]);
				}
				else {
					System.out.println(sumAr[b-1] - sumAr[a-2]);
				}
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
