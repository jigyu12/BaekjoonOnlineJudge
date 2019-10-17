package 꽃길_14620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static int n;
	static int map[][];
	static int ans;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		map	= new int[n+2][n+2];
		ans = Integer.MAX_VALUE;
		visited = new boolean[n+2][n+2];
		
		for(int i = 0; i < n+2; i++) {
			Arrays.fill(map[i], -1);
		}
		
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		dfs(0,0);
		System.out.println(ans);
	}

	private static void dfs(int cnt, int sum) {
		if(cnt == 3) {
			if(sum < ans) {
				ans = sum;
			}
			return ;
		}
		
		for(int i = 2; i < n; i++) {
			for(int j = 2; j < n; j++) {
				xx : if(!visited[i][j]) {
					visited[i][j] = true;
					int s = map[i][j];
					for(int k = 0; k < 4; k++) {
						if(visited[i+dx[k]][j+dy[k]]) {
							visited[i][j] = false;
							break xx;
						}
					}
					for(int k = 0; k < 4; k++) {
						s += map[i+dx[k]][j+dy[k]];
						visited[i+dx[k]][j+dy[k]] = true;
					}

					dfs(cnt+1,s+sum);
					
					for(int k = 0; k < 4; k++) {
						visited[i+dx[k]][j+dy[k]] = false;
					}
					visited[i][j] = false;
				}
			}
		}
	}
}
