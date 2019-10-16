package 게임_1103;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static class Node{
		int x;
		int y;
		int cnt;
		
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}

	}
	
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean isCycle = false;
	static int ans;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		
		map = new int[n+18][m+18];
		dp = new int[n+18][m+18];
		visited = new boolean[n+18][m+18];
		
		for(int i = 9; i < 9+n; i++) {
			String[] s = br.readLine().split("");
			for(int j = 9; j < 9+m; j++) {
				if(!s[j-9].equals("H")) {
					map[i][j] = Integer.parseInt(s[j-9]);
				}
			}
		}

		visited[9][9] = true;

		dfs(9,9,0);

		if(isCycle) {
			System.out.println(-1);
		}
		else {
			System.out.println(dp[9][9]+1);
		}
		
	}

	private static int dfs(int x, int y,int cnt) {
		for(int i = 0; i < 4; i++) {
			if(isCycle) {
				return -1;
			}
			if(!visited[x+(dx[i] * map[x][y])][y+(dy[i] * map[x][y])]
					&& map[x+(dx[i] * map[x][y])][y+(dy[i] * map[x][y])] > 0) {
				
				if(dp[x+(dx[i] * map[x][y])][y+(dy[i] * map[x][y])] == 0) {
					visited[x+(dx[i] * map[x][y])][y+(dy[i] * map[x][y])] = true;
					int num = dfs(x+(dx[i] * map[x][y]),y+(dy[i] * map[x][y]),cnt+1) + 1;
					dp[x][y] = (dp[x][y] < num) ? num : dp[x][y];
					visited[x+(dx[i] * map[x][y])][y+(dy[i] * map[x][y])] = false;
				}
				
				else {
					int num = dp[x+(dx[i] * map[x][y])][y+(dy[i] * map[x][y])] + 1;
					dp[x][y] = (dp[x][y] < num) ? num : dp[x][y];
				}
				
			}
			else if(visited[x+(dx[i] * map[x][y])][y+(dy[i] * map[x][y])]) {
				isCycle = true;
			}

		}
		
		return dp[x][y];
	}
}
