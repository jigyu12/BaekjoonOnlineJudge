package 점프_1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] map;
	static long[][] dp;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n+22][n+22];
		dp = new long[n+22][n+22];
		
		
		for(int i = 11; i < n+11; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 11; j < n+11; j++) {
				map[i][j] = Integer.parseInt(s[j-11]);
				if(map[i][j] == 0) {
					map[i][j] = 10;
				}
			}
		}
		
		find(11,11);

		System.out.println(dp[11][11]);
	}

	private static long find(int x, int y) {
		
		if(x == n+10 && y == n+10) {
			return 1;
		}
		
		if(dp[x][y] > 0) {
			return dp[x][y];
		}
		
		if(map[x+map[x][y]][y] > 0) {
			dp[x][y] += find(x+map[x][y], y);
		}
		
		if(map[x][y+map[x][y]] > 0) {
			dp[x][y] += find(x, y+map[x][y]);
		}
		
		return dp[x][y];
	}

}
