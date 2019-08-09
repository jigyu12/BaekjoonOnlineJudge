package 미로탐색_2178;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node{
		int x;
		int y;
		int c;
		
		public Node(int x, int y, int c) {
			this.x = x;
			this.y = y;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", c=" + c + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int[][] map = new int[n+2][m+2];
		
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split("");
			for(int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		
		Queue<Node> qu = new LinkedList<>();
		qu.add(new Node(1,1,1));
		int ans = 10001;
		
		while(!qu.isEmpty()) {
			Node no = qu.poll();
			
			int x = no.x;
			int y = no.y;
			int c = no.c;
			
			if(c > ans) {
				continue;
			}
			
			if(x == n && y == m) {
				if(c < ans) {
					ans = c;
				}
				continue;
			}
			
			if(map[x-1][y] == 1) {
				qu.add(new Node(x-1,y,c+1));
				map[x-1][y] = 0;
			}
			
			if(map[x+1][y] == 1) {
				qu.add(new Node(x+1,y,c+1));
				map[x+1][y] = 0;
			}
			
			if(map[x][y-1] == 1) {
				qu.add(new Node(x,y-1,c+1));
				map[x][y-1] = 0;
			}
			
			if(map[x][y+1] == 1) {
				qu.add(new Node(x,y+1,c+1));
				map[x][y+1] = 0;
			}
		}
		System.out.println(ans);
	}

}
