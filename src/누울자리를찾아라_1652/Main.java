package 누울자리를찾아라_1652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] map;
	static boolean[][][] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		map = new int[n+2][n+2];
		visited = new boolean[n+2][n+2][2];
		
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split("");
			for(int j = 1; j <= n; j++) {
				if(s[j-1].equals(".")) {
					map[i][j] = 1;
				}
			}
		}
		
		int garo_max = 0;
		int sero_max = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(map[i][j] == 1) {
					if(!visited[i][j][0]) {
						visited[i][j][0] = true;
						int len = dfs(i,j,0) + 1;
						if(1 < len) {
							++garo_max;
						}
					}
					
					if(!visited[i][j][1]) {
						visited[i][j][1] = true;
						int len = dfs(i,j,1) + 1;
						if(1 < len) {
							++sero_max;
						}
					}
				}
			}
		}

		System.out.println(garo_max + " " + sero_max);
	}

	private static int dfs(int i, int j, int k) {
		if(k == 0) {
			int add = 0;
			
			if(!visited[i][j-1][k] && map[i][j-1] == 1) {
				visited[i][j-1][k] = true;
				add += dfs(i,j-1,k) + 1;
			}
			
			if(!visited[i][j+1][k] && map[i][j+1] == 1) {
				visited[i][j+1][k] = true;
				add += dfs(i,j+1,k) + 1;
			}
			
			return add;
		}
		
		else {
			int add = 0;
			
			if(!visited[i-1][j][k] && map[i-1][j] == 1) {
				visited[i-1][j][k] = true;
				add += dfs(i-1,j,k) + 1;
			}
			
			if(!visited[i+1][j][k] && map[i+1][j] == 1) {
				visited[i+1][j][k] = true;
				add += dfs(i+1,j,k) + 1;
			}
			
			return add;
		}

	}

}
