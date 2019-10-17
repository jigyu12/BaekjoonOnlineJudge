package 아맞다우산_17244;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node{
		int x;
		int y;
		int things;
		int cnt;
		
		public Node(int x, int y, int things, int cnt) {
			this.x = x;
			this.y = y;
			this.things = things;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", things=" + things + ", cnt=" + cnt + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		
		int n = Integer.parseInt(nm[1]);
		int m = Integer.parseInt(nm[0]);
		
		int[][] map = new int[n][m];
		
		boolean[][][] visited = new boolean[n][m][(1<<6)];
		
		int thingscnt = 0;
		Node start = new Node(0,0,1,0) , end= new Node(0,0,1,0);
		
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split("");
			for(int j = 0; j < m; j++) {
				switch(s[j]) {
				case "#":
					map[i][j] = -1;
					break;
				case "S":
					start.x = i;
					start.y = j;
					break;
				case "E":
					end.x = i;
					end.y = j;
					break;
				case "X":
					map[i][j] = ++thingscnt;
					break;
				}
			}
		}
		
		Queue<Node> qu = new LinkedList<>();
		qu.add(start);
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		int ans = 0;
		while(!qu.isEmpty()) {
			Node no = qu.poll();

			int x = no.x;
			int y = no.y;
			int t = no.things;
			int c = no.cnt;
			
			if(x == end.x && y == end.y) {
				if(t == (1 << thingscnt+1) - 1) {
					ans = c;
					break;
				}
				continue;
			}
			
			for(int i = 0; i < 4; i++) {
				if(map[x+dx[i]][y+dy[i]] >= 0 
						&& !visited[x+dx[i]][y+dy[i]][t | (1 << map[x+dx[i]][y+dy[i]])]) {
					visited[x+dx[i]][y+dy[i]][t | (1 << map[x+dx[i]][y+dy[i]])] = true;
					qu.add(new Node(x+dx[i], y+dy[i], t | (1 << map[x+dx[i]][y+dy[i]])
							, c+1));
				}
			}
		}
		System.out.println(ans);
	}

}
