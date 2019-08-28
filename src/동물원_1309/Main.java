package 동물원_1309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [][] dp = new int[n][3];
		Arrays.fill(dp[0], 1);
		
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < 3; j++) {
				switch(j) {
				case 0:
					dp[i][0] += ((dp[i-1][0] + dp[i-1][1] + dp[i-1][2]) % 9901);
					break;
				case 1:
					dp[i][1] += ((dp[i-1][0] + dp[i-1][2]) % 9901);
					break;
				case 2:
					dp[i][2] += ((dp[i-1][0] + dp[i-1][1]) % 9901);
					break;
				}
			}
		}
		
		int ans = 0;
		for(int j = 0; j < 3; j++) {
			ans += dp[n-1][j];
		}
		System.out.println(ans % 9901);
	}
}
