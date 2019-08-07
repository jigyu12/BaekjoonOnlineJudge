package 연구소3_17142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int n;
	static int m;
	static int[][] map;
	static ArrayList<Node> virus = new ArrayList<>();
	static int combisize; 
	static Node[] combi;
	static int ans = 2051;
	
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		map = new int[n+2][n+2];
		combi = new Node[m];
		
		Arrays.fill(combi, new Node(0,0));
		
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 1; j <= n; j++) {
				int num = Integer.parseInt(s[j-1]);
				switch(num) {
				case 0:
					map[i][j] = 1;
					break;
					
				case 1:
					map[i][j] = 0;
					break;
					
				case 2:
					virus.add(new Node(i,j));
					map[i][j] = 2;
					break;
				}
			}
		}
		
		combisize = virus.size();
		
		for(int i = 0 ; i < combisize; i++) {
			combi[0].x = virus.get(i).x;
			combi[0].y = virus.get(i).y;
			combination(1,i,(1 << i));
		}
		if(ans == 2051) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
	}

	static void combination(int cnt, int start, int state) {
		if(cnt == m) {
			bfs();
			return ;
		}
		
		for(int i = start+1 ; i < combisize; i++) {
			if((state & (1 << i)) == 0) {
				combi[cnt] = new Node(virus.get(i).x,virus.get(i).y);
				combination(cnt+1, i, state | (1 << i));
			}
		}
	}

	static void bfs() {
		Queue<Node> qu = new LinkedList<>();
		boolean[][] visited = new boolean[n+2][n+2];
		for(int i = 0; i < m; i++) {

			qu.add(combi[i]);
			visited[combi[i].x][combi[i].y] = true;
		}

		int cnt = 0;
		while(!qu.isEmpty()) {
			
			int size = qu.size();
			boolean add = false;
			for(int i = 0; i < size; i++) {
				Node n = qu.poll();
				
				int x = n.x;
				int y = n.y;
				if(map[x-1][y] == 1  && !visited[x-1][y]) {
					visited[x-1][y] = true;
					add = true;
					qu.add(new Node(x-1,y));
				}
				if(map[x+1][y] == 1 && !visited[x+1][y]) {
					visited[x+1][y] = true;
					add = true;
					qu.add(new Node(x+1,y));
				}
				
				if(map[x][y-1] == 1 && !visited[x][y-1]) {
					visited[x][y-1] = true;
					add = true;
					qu.add(new Node(x,y-1));
				}
				
				if(map[x][y+1] == 1 && !visited[x][y+1]) {
					visited[x][y+1] = true;
					add = true;
					qu.add(new Node(x,y+1));
				}
				
				if(map[x-1][y] == 2 && !visited[x-1][y]) {
					visited[x-1][y] = true;
					qu.add(new Node(x-1,y));
				}
				if(map[x+1][y] == 2 && !visited[x+1][y]) {
					visited[x+1][y] = true;
					qu.add(new Node(x+1,y));
				}
				
				if(map[x][y-1] == 2 && !visited[x][y-1]) {
					visited[x][y-1] = true;
					qu.add(new Node(x,y-1));
				}
				
				if(map[x][y+1] == 2 && !visited[x][y+1]) {
					visited[x][y+1] = true;
					qu.add(new Node(x,y+1));
				}
			}
			if(add) {
				cnt++;
			}
		}


		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(map[i][j] != 0 && !visited[i][j]) {
					return ;
				}
			}
		}
		
		if(cnt < ans) {
			ans = cnt;
		}
		System.out.println(ans);
	}
}