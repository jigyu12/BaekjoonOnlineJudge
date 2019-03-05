package Baaaaaaaaaduk2_Easy_16988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

	}
	
	private static int[][] map;
	private static boolean[][] visited;
	private static int ans;
	private static int n;
	private static int m;
	private static int comp;
	
	private static void cal(int x, int y) {

		if(visited[x][y]) {
			return ;
		}
		
		visited[x][y] = true;
		
		comp++;

		if(!visited[x-1][y] && map[x-1][y] == 2) {
			cal(x-1,y);
		}
		
		if(!visited[x+1][y] && map[x+1][y] == 2) {
			cal(x+1,y);
		}
		
		if(!visited[x][y-1] && map[x][y-1] == 2) {
			cal(x,y-1);

		}
		
		if(!visited[x][y+1] && map[x][y+1] == 2) {
			cal(x,y+1);
		}
		
		if(map[x-1][y] == 0 || map[x+1][y] == 0 || 
				map[x][y-1] == 0 || map[x][y+1] == 0) {
			comp = 0;
			return ;
		}
		
	}
	
	private static void insertbaduk(int index, int count) {
		
		if(count == 2) {
			visited = new boolean[n+2][m+2];
			int temp = 0;
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m; j++) {
					if(map[i][j] == 2 && !visited[i][j]) {
						comp = 0;
						cal(i,j);
						temp += comp;
					}
				}
			}
			if(temp > ans) {
				ans = temp;
			}
			return ;
		}
		
		for(int i = index; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					insertbaduk(i, count+1);
					map[i][j] = 0;
				}
			}
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		map = new int[n+2][m+2];
		ans = 0;
		
		for(int i = 0; i < n+2; i++) {
			Arrays.fill(map[i], 3);
		}
		
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					insertbaduk(i, 1);
					map[i][j] = 0;
				}
			}
		}
		System.out.println(ans);
	}
}
