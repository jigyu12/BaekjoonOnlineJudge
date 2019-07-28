package 로봇청소기_4991;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node{
		int x;
		int y;
		int count;
		
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
		
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", count=" + count + "]";
		}
	}
	
	private static int w;
	private static int h;
	private static int[][] map;
	private static Node[] order;
	private static int[][] comp;
	private static int shift;
	private static int ans;
	private static int finalans;
	private static int permu[];
	
	private static void find(int s, int o, int[][] countmap) {
		Queue<Node> qu = new LinkedList<>();
		qu.add(new Node(order[s].x,order[s].y,0));
		Node dest = order[o];
		for(int i = 0; i <= w+1; i++) {
			Arrays.fill(countmap[i],500);
		}
		while(!qu.isEmpty()) {
			Node n = qu.poll();

			if(n.count > ans) {
				continue;
			}
			
			if(dest.x == n.x && dest.y == n.y) {
				if(ans > n.count) {
					ans = n.count;
				}
				continue;
			}
			
			int nx = n.x;
			int ny = n.y;
			int nc = n.count;
			
			while(1 <= map[nx-1][ny] && map[nx-1][ny] <= 3) {
				nc++;
				if(countmap[nx-1][ny] > nc) {
					qu.add(new Node(nx-1,ny,nc));
					countmap[nx-1][ny] = nc;
				}
				nx--;

			}
			
			nx = n.x;
			ny = n.y;
			nc = n.count;
			while(1 <= map[nx+1][ny] && map[nx+1][ny] <= 3) {
				nc++;
				if(countmap[nx+1][ny] > nc) {
					qu.add(new Node(nx+1,ny,nc));
					countmap[nx+1][ny] = nc;
				}
				nx++;
			}
			
			nx = n.x;
			ny = n.y;
			nc = n.count;
			
			while(1 <= map[nx][ny-1] && map[nx][ny-1] <= 3) {
				nc++;
				if(countmap[nx][ny-1] > nc) {
					qu.add(new Node(nx,ny-1,nc));
					countmap[nx][ny-1] = nc;
				}
				ny--;
			}
			
			nx = n.x;
			ny = n.y;
			nc = n.count;
			
			while(1 <= map[nx][ny+1] && map[nx][ny+1] <= 3) {
				nc++;
				if(countmap[nx][ny+1] > nc) {
					qu.add(new Node(nx,ny+1,nc));
					countmap[nx][ny+1] = nc;
				}
				ny++;
			}
		}
	}
	
	private static void permutation(int n, long visit) {
		if(n == shift+1) {
			int add = 0;
			for(int i = 0; i < shift; i++) {
				add += comp[permu[i]][permu[i+1]];
			}
			if(finalans > add) {
				finalans = add;
			}
			return ;
		}
		
		for(int i = 1; i <= shift; i++) {
			if((visit & (1 << i)) == 0) {
				permu[n] = i;
				permutation(n+1,visit | (1 << i));
			}
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		w = 0;
		h = 0;
		
		while(true) {
			String[] wh = br.readLine().split(" ");
			w = Integer.parseInt(wh[1]);
			h = Integer.parseInt(wh[0]);
			if(w == 0 && h == 0) {
				break;
			}
			shift = 0;
			map = new int[w+2][h+2];
			order = new Node[11];
			comp = new int[11][11];
			permu = new int[11];
			permu[0] = 0;
			finalans = 400;
			for(int i = 1; i <= w; i++) {
				String[] s = br.readLine().split("");
				for(int j = 1; j <= h; j++) {
					switch(s[j-1]) {
					case "x":
						map[i][j] = 0;
						break;
						
					case ".":
						map[i][j] = 1;
						break;
					case "*":
						shift++;
						map[i][j] = 2;
						order[shift] = new Node(i,j,0); 
						break;
					case "o":
						map[i][j] = 3;
						order[0] = new Node(i,j,0);
						break;
					}
				}
			}
			boolean find = false;
			for(int i = 0; i <= shift; i++) {
				for(int j = i+1; j <= shift; j++) {
					ans = 400;
					find(i,j,new int[w+2][h+2]);
					comp[i][j] = ans;
					comp[j][i] = ans;
					
					if(ans == 400) {
						find = true;
					}
				}
			}
			if(find) {
				bw.write("-1\n");
				continue;
			}
			permutation(1,1);
			bw.write(finalans+"\n");

		}
		bw.flush();
	}
}
