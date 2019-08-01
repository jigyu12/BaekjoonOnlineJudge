package 출근경로_5569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 int w = Integer.parseInt(st.nextToken());
		 int h = Integer.parseInt(st.nextToken());
		
		 int[][][][] dp = new int[2][2][w+2][h+2];
		 
		 dp[0][0][1][1] = 1;
		 dp[1][0][1][1] = 1;
		 
		 for(int i = 1; i <= w; i++) {
			 for(int j = 1; j <= h; j++) {
				 dp[0][0][i][j] += dp[0][0][i][j-1];
				 dp[0][0][i][j] += dp[0][1][i][j-1];
				 
				 if(i >= 2) dp[0][1][i][j] += dp[1][0][i][j-1];
				 
				 dp[1][0][i][j] += dp[1][0][i-1][j];
				 dp[1][0][i][j] += dp[1][1][i-1][j];
				 
				 if(j >= 2) dp[1][1][i][j] += dp[0][0][i-1][j];
				 
				 dp[0][0][i][j] %= 100000;
				 dp[0][1][i][j] %= 100000;
				 dp[1][0][i][j] %= 100000;
				 dp[1][1][i][j] %= 100000;

			 }
		 }
	
		 System.out.println((dp[0][0][w][h] + dp[0][1][w][h] + dp[1][0][w][h] + dp[1][1][w][h]) % 100000);
	}
}