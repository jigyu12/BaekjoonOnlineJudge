package twodots_16929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static int m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean isCycle = false;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		
		map = new int[n+2][m+2];
		visited = new boolean[n+2][m+2];
		
		for(int i = 1; i <= n; i++) {
			String s = br.readLine();
			for(int j = 1; j <= m; j++) {
				map[i][j] = s.charAt(j-1) - 64;
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(!visited[i][j]) {
					visited[i][j] = true;
					for(int d = 0; d < 4; d++) {
						if(!visited[i+dx[d]][j+dy[d]] && map[i+dx[d]][j+dy[d]] == map[i][j]) {
							visited[i+dx[d]][j+dy[d]] = true;
							dfs(i+dx[d],j+dy[d],map[i][j],d);
						}
					}
				}
			}
		}
		if(isCycle) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		
	}

	private static void dfs(int x, int y, int v ,int d) {
		
		
		for(int i = 0; i < 4; i++) {
			if(isCycle) {
				return ;
			}
			if(!visited[x+dx[i]][y+dy[i]] && map[x+dx[i]][y+dy[i]] == v) {
				if((d+2) % 4 != i) {
					visited[x+dx[i]][y+dy[i]] = true;
					dfs(x+dx[i],y+dy[i],v,i);
				}
			}
			else if(visited[x+dx[i]][y+dy[i]] && map[x+dx[i]][y+dy[i]] == v
					&& (d+2) % 4 != i) {
				isCycle = true;
				return ;
			}
		}
	}
}
