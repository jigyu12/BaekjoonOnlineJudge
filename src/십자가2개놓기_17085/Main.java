package 십자가2개놓기_17085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node{
		int x;
		int y;
		int dir;
		
		public Node(int x, int y, int dir) {
			this.x = x;
			this.y = y;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", dir=" + dir + "]";
		}
		
		
		
	}
	
	private static int n;
	private static int m;
	private static int[][] map;
	private static boolean[][] visited;
	private static Queue<Node> qu;
	
	private static int findcross(int x, int y) {
		
		qu.add(new Node(x,y,0));
		qu.add(new Node(x,y,1));
		qu.add(new Node(x,y,2));
		qu.add(new Node(x,y,3));
		visited[x][y] = true;
		
		int cal = 0;
		
		int exp = 1;
		while(!qu.isEmpty()) {
			int size = qu.size();
			int count = 0;
			for(int i = 0; i < size; i++) {
				Node n = qu.poll();
				
				int nx = n.x;
				int ny = n.y;
				int nd = n.dir;
				
			
				
				switch(nd) {
				case 0:
					if(!visited[x-exp][y] && map[x-exp][y] == 1) {
						count++;
					}
					break;
					
				case 1:
					if(!visited[x][y+exp] && map[x][y+exp] == 1) {
						count++;
					}
					break;
					
				case 2:
					if(!visited[x+exp][y] && map[x+exp][y] == 1) {
						count++;
					}
					break;
					
				case 3:
					if(!visited[x][y-exp] && map[x][y-exp] == 1) {
						count++;
					}
					break;
				}
				
				if(count == 4) {
					qu.add(new Node(x-exp,y,0));
					visited[x-exp][y] = true;
					qu.add(new Node(x+exp,y,2));
					visited[x+exp][y] = true;
					qu.add(new Node(x,y-exp,3));
					visited[x][y-exp] = true;
					qu.add(new Node(x,y+exp,1));
					visited[x][y+exp] = true;
					cal += 4;
				}
			}
			exp++;
		}
	
		return cal;
	}
	
	private static int findcross2(int x, int y) {
		
		qu.add(new Node(x,y,0));
		qu.add(new Node(x,y,1));
		qu.add(new Node(x,y,2));
		qu.add(new Node(x,y,3));
		visited[x][y] = true;
		
		int cal = 0;
		Queue<Node> garbage = new LinkedList<>();
		garbage.add(new Node(x,y,0));
		
		int exp = 1;
		while(!qu.isEmpty()) {
			int size = qu.size();
			int count = 0;
			for(int i = 0; i < size; i++) {
				Node n = qu.poll();
				
				int nx = n.x;
				int ny = n.y;
				int nd = n.dir;
				
				
				
				switch(nd) {
				case 0:
					if(!visited[x-exp][y] && map[x-exp][y] == 1) {
						count++;
					}
					break;
					
				case 1:
					if(!visited[x][y+exp] && map[x][y+exp] == 1) {
						count++;
					}
					break;
					
				case 2:
					if(!visited[x+exp][y] && map[x+exp][y] == 1) {
						count++;
					}
					break;
					
				case 3:
					if(!visited[x][y-exp] && map[x][y-exp] == 1) {
						count++;
					}
					break;
				}
				
				if(count == 4) {
					qu.add(new Node(x-exp,y,0));
					garbage.add(new Node(x-exp,y,0));
					visited[x-exp][y] = true;
					qu.add(new Node(x+exp,y,2));
					garbage.add(new Node(x+exp,y,2));
					visited[x+exp][y] = true;
					qu.add(new Node(x,y-exp,3));
					garbage.add(new Node(x,y-exp,3));
					visited[x][y-exp] = true;
					qu.add(new Node(x,y+exp,1));
					garbage.add(new Node(x,y+exp,1));
					visited[x][y+exp] = true;
					cal += 4;
				}
			}
			exp++;
		}
		
		while(!garbage.isEmpty()) {
			Node n = garbage.poll();
			visited[n.x][n.y] = false;
		}
	
		return cal;
	}
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		map = new int[n+2][m+2];
		qu = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split("");
			for(int j = 1; j <= m; j++) {
				switch(s[j-1]) {
				case "#":
					map[i][j] = 1;
					break;
				}
			}
		}
		
		int ans = 0;
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(map[i][j] == 1) {
					visited = new boolean[n+2][m+2];
					int cal1 = 1;
					int cal2 = 1;
					cal1 += findcross(i,j);
					for(int k = 1; k <= n; k++) {
						for(int p = 1; p <= m; p++) {
							if(!visited[k][p] && map[k][p] == 1) {
								cal2 = 1;
								cal2 += findcross2(k,p);
								int mul = cal1 * cal2;
								if(ans < mul) {
									ans = mul;
								}
							}
						}
					}
					
				}
			}
		}
		System.out.println(ans);
	}
}
