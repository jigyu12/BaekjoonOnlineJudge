package 로봇_1726;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node{
		int x;
		int y;
		int d;
		int c;
		
		public Node(int x, int y, int d, int c) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", d=" + d + ", c=" + c + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int[][] map = new int[n+6][m+6];
		boolean[][][] visited = new boolean[n+6][m+6][4];
		for(int i = 3; i < n+3; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 3; j < m+3; j++) {
				int num = Integer.parseInt(s[j-3]);
				if(num == 0) {
					map[i][j] = 1;
				}
			}
		}
		
		Node start = new Node(0,0,0,0);
		Node end = new Node(0,0,0,0);
		
		for(int i = 0; i < 2; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]) + 2;
			int y = Integer.parseInt(s[1]) + 2;
			int d = Integer.parseInt(s[2]) - 1;
			if(d == 2) {
				d = 1;
			}
			else if(d == 1) {
				d = 2;
			}
			if(i == 0) start = new Node(x,y,d,0);
			else end = new Node(x,y,d,0);
		}
		
		Queue<Node> qu = new LinkedList<>();
		qu.add(start);
		
		int ans = Integer.MAX_VALUE;
		
		while(!qu.isEmpty()) {
			Node no = qu.poll();

			int x = no.x;
			int y = no.y;
			int d = no.d;
			int c = no.c;
			
			if(ans < c) {
				continue;
			}
			
			if(x == 3 && y == 4 && d == 1) {
				d = 1;
			}
			if(x == end.x && y == end.y && d == end.d) {
				if(ans > c) {
					ans = c;
				}
				break;
			}
			
			visited[x][y][d] = true;

			if(!visited[x+dx[d]][y+dy[d]][d] && map[x+dx[d]][y+dy[d]] == 1) {
				qu.add(new Node(x+dx[d],y+dy[d],d,c+1));
				
				if(!visited[x+(dx[d]*2)][y+(dy[d]*2)][d] && map[x+(dx[d]*2)][y+(dy[d]*2)] == 1) {
					qu.add(new Node(x+(dx[d]*2),y+(dy[d]*2),d,c+1));
					
					if(!visited[x+(dx[d]*3)][y+(dy[d]*3)][d] && map[x+(dx[d]*3)][y+(dy[d]*3)] == 1) {
						qu.add(new Node(x+(dx[d]*3),y+(dy[d]*3),d,c+1));
					}
				}
			}
			
			
			if(!visited[x][y][(d+1) % 4]) {
				qu.add(new Node(x,y,(d+1) % 4,c+1));
			}
			if(!visited[x][y][(d+3) % 4]) {
				qu.add(new Node(x,y,(d+3) % 4,c+1));
			}
		}
		
		System.out.println(ans);
		

	}

}
