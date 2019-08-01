package 공통부문문자열_5582;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String sa = br.readLine();
		String sb = br.readLine();
		int la = sa.length();
		int lb = sb.length();
		
		int[] a = new int[la+1];
		int[] b = new int[lb+1];
		int[][] dp = new int[la+1][lb+1];
		
		for(int i = 0; i < la; i++) {
			a[i+1] = sa.charAt(i);
		}
		for(int i = 0; i < lb; i++) {
			b[i+1] = sb.charAt(i);
		}
		
		int ans = 0;
	
		for(int i = 1; i <= la; i++) {
			for(int j = 1; j <= lb; j++) {
				if(a[i] == b[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					if(dp[i][j] > ans) {
						ans = dp[i][j];
					}
				}
			}
		}
		System.out.println(ans);
	}
}
