package 다리만들기2_17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	static class Node implements Comparable<Node>{
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

		@Override
		public int compareTo(Node o) {
			return dist[this.x][this.y] - dist[o.x][o.y];
		}

	}
	
	static int n;
	static int m;
	static int map[][];
	static Queue<Node> qu;
	static int dist[][];
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int[] combi;
	static int vilNum;
	static int ans;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		map = new int[n+2][m+2];
		qu = new LinkedList<>();
		
		for(int i = 0; i < n+2; i++) {
			Arrays.fill(map[i], -1);
		}
		
		for(int i = 1; i <= n; i++) {
			String s[] = br.readLine().split(" ");
			for(int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		
		vilNum = 1;
		
		boolean[][] visited = new boolean[n+2][m+2];
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					qu.add(new Node(i,j));
					visited[i][j] = true;
					map[i][j] = vilNum;
					while(!qu.isEmpty()) {
						Node no = qu.poll();
						
						int x = no.x;
						int y = no.y;
						
						for(int k = 0; k < 4; k++) {
							if(!visited[x+dx[k]][y+dy[k]] && map[x+dx[k]][y+dy[k]] == 1) {
								visited[x+dx[k]][y+dy[k]] = true;
								map[x+dx[k]][y+dy[k]] = vilNum;
								qu.add(new Node(x+dx[k],y+dy[k]));
							}
						}
					}
					vilNum++;
				}
			}
		}
		
		dist = new int[vilNum][vilNum];
		combi = new int[vilNum-2];
		parent = new int[vilNum];
		
		ans = 0;
		
		for(int i = 0; i < vilNum; i++) {
			Arrays.fill(dist[i], 10000);
			parent[i] = i;
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j] > 0) {
					for(int k = 0; k < 4; k++) {
						makePath(i,j,map[i][j],k,0);
					}
				}
			}
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		for(int i = 1; i < vilNum; i++) {
			for(int j = i+1; j < vilNum; j++) {
				if(dist[i][j] > 1 && dist[i][j] < 9999) {
					pq.add(new Node(i,j));
				}
			}
		}
		
		int cnt = 0;
		
		while(!pq.isEmpty()) {
			
			if(cnt >= vilNum - 2) {
				break;
			}
			
			Node n = pq.poll();
			
			int x = n.x;
			int y = n.y;
				
			if(find(x) != find(y)) {
				ans += dist[x][y];
				if(x < y) {
					union(x,y);
				}
				else {
					union(y,x);
				}
				cnt++;
			}

		}
		
		if(cnt < vilNum - 2) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
		

	}
	
	static int find(int x) {
		if(x == parent[x]) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	static void union(int x, int y) {
		parent[find(y)] = find(parent[x]);
	}

	private static void makePath(int i, int j, int vn, int d, int cnt) {
		if(map[i+dx[d]][j+dy[d]] == -1) {
			return ;
		}
		else if(map[i+dx[d]][j+dy[d]] == 0) {
			makePath(i+dx[d], j+dy[d], vn, d,cnt+1);
		}
		else if(map[i+dx[d]][j+dy[d]] == vn) {
			return ;
		}
		else {
			if(cnt > 1) {
				if(dist[vn][map[i+dx[d]][j+dy[d]]] > cnt) {
					dist[vn][map[i+dx[d]][j+dy[d]]] = cnt;
					dist[map[i+dx[d]][j+dy[d]]][vn] = cnt;
				}
			}
		}
	}

}
