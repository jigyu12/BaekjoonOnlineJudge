package 빙산_2573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node{
		int x;
		int y;
		int h;
		
		public Node(int x, int y, int h) {
			this.x = x;
			this.y = y;
			this.h = h;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", h=" + h + "]";
		}

	}
	
	static int n;
	static int m;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		
		map = new int[n][m];
		
		Queue<Node> qu = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(map[i][j] > 0) {
					qu.add(new Node(i,j,map[i][j]));
				}
			}
		}
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		int time = 0;
		int ans = -1;
		Queue<Node> bfs = new LinkedList<>();
		xx : while(!qu.isEmpty()) {
			int size = qu.size();
			boolean[][] visited = new boolean[n][m];
			int bf = 0;
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(!visited[i][j] && map[i][j] > 0) {
						++bf;
						if(bf == 2) {
							ans = time;
							break xx;
						}
						bfs.add(new Node(i,j,0));
						while(!bfs.isEmpty()) {
							Node no = bfs.poll();
							
							int x = no.x;
							int y = no.y;

							for(int k = 0; k < 4; k++) {
								if(!visited[x+dx[k]][y+dy[k]] && map[x+dx[k]][y+dy[k]] > 0) {
									bfs.add(new Node(x+dx[k],y+dy[k],0));
									visited[x+dx[k]][y+dy[k]] = true;
								}
							}
						}
					}
				}
			}
			
			for(int s = 0; s < size; s++) {
				Node no = qu.poll();
				
				int x = no.x;
				int y = no.y;
				int h = no.h;
				
				int zerocnt = 0;
				for(int i = 0; i < 4; i++) {
					if(map[x+dx[i]][y+dy[i]] == 0) {
						zerocnt++;
					}
				}

				h -= zerocnt;
				
				if(h <= 0) {
					h = 0;
				}
				
				qu.add(new Node(x,y,h));
			}
			
			for(int s = 0; s < size; s++) {
				Node no = qu.poll();
				
				int x = no.x;
				int y = no.y;
				int h = no.h;
				
				map[x][y] = h;
				if(h > 0) {
					qu.add(no);
				}
			}
			time++;
		}
		
		if(ans == -1) {
			System.out.println(0);
		}
		else {
			System.out.println(ans);
		}
	}
}
