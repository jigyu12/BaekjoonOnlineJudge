package ¾Û_7579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm;
		try {
			nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			int[][] dp = new int[n+1][10002];
			String[] me = br.readLine().split(" ");
			int[] mem = new int[n];
			for (int i = 0; i < n; i++) {
				mem[i] = Integer.parseInt(me[i]);
			}
			String[] co = br.readLine().split(" ");
			int[] cost = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				cost[i] = Integer.parseInt(co[i]);
				sum += cost[i];
			}
			for(int i = 1; i <= n; i++) {
				for(int j = 2; j <= sum; j++) {
					if(j < cost[i-1]) {
						dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]);
					}
					else {
						
						dp[i][j] = Math.max(dp[i-1][j-cost[i-1]] + mem[i-1], 
								Math.max(dp[i-1][j], dp[i][j-1]));
					}
				}
			}
			for(int i = 1; i <= n; i++) {
				for(int j = 0; j <= sum; j++) {
					System.out.print(dp[i][j] + " ");
				}
				System.out.println();
			}
			int min = 10001;
			for(int i = 1; i <= n; i++) {
				for(int j = 0; j <= sum; j++) {
					if(dp[i][j] >= m) {
						if(min > j) {
							min = j;
							break;
						}
					}
				}
			}
			System.out.println(min);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
