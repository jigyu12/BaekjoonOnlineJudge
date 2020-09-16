package 내리막길_1520;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int[][] map;
	static int[][] dp;
	static int n, m;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		
		map = new int[n+2][m+2];
		dp = new int[n+2][m+2];
		
		for(int i = 0; i < n+2; i++) {
			Arrays.fill(map[i], 10001);
		}
		
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		
		
		System.out.println(findCaseCount(1,1));
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				System.out.print(dp[i][j]+ " ");
			}
			System.out.println();
		}
	}

	private static int findCaseCount(int x, int y) {
		
		if(x == n && y == m) {
			return 1;
		}
		
		for(int i = 0; i < 4; i++) {
			if(map[x+dx[i]][y+dy[i]] < map[x][y]) {
				if(dp[x+dx[i]][y+dy[i]] > 0) {
					return dp[x+dx[i]][y+dy[i]]+1;
				}
				else {
					dp[x][y] = findCaseCount(x+dx[i], y+dy[i]);
				}
			}
		}
		
		return dp[x][y];
	}

}
