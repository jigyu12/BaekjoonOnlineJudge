package ·Îº¿Ã»¼Ò±â_4991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node{
		int x;
		int y;
		int count;
		int visit;
		
		public Node(int x, int y, int count, int visit) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.visit = visit;
		}
		
		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", count=" + count + ", visit=" + visit + "]";
		}
		
		
	}
	
	private static int w;
	private static int h;
	private static int[][] map;
	private static int[][] order;
	private static int[][] countmap;
	private static int[] comp;
	private static int shift;
	private static int ans;
	
	private static void find(int x, int y) {
		Queue<Node> qu = new LinkedList<>();
		qu.add(new Node(x,y,0,0));
		countmap[x][y] = 0;
		while(!qu.isEmpty()) {
			Node n = qu.poll();
			System.out.println(n);
			if(n.count > ans) {
				continue;
			}
			
			if(comp[n.x] == n.y) {
				countmap[n.x][n.y] = 0;
				if((n.visit & (1 << order[n.x][n.y])) != 0) {
					continue;
				}
				n.visit |= (1 << order[n.x][n.y]);
				n.count--;
				if(n.visit == (1 << shift) - 1) {
					if(n.count < ans) {
						ans = n.count;
					}
				}
			}
			
			int nx = n.x;
			int ny = n.y;
			int nc = n.count;
			while(1 <= map[nx-1][ny] && map[nx-1][ny] <= 2) {
				nc++;
				if(countmap[nx-1][ny] == -1) {
					qu.add(new Node(nx-1,ny,nc,n.visit));
					countmap[nx-1][ny] = countmap[nx][y] + 1;
				}
				nx--;

			}
			
			nx = n.x;
			ny = n.y;
			nc = n.count;
			while(1 <= map[nx+1][ny] && map[nx+1][ny] <= 2) {
				nc++;
				if(countmap[nx+1][ny] == -1) {
					qu.add(new Node(nx+1,ny,nc,n.visit));
					countmap[nx+1][ny] = countmap[nx][y] + 1;
				}
				nx++;
				
			}
			
			nx = n.x;
			ny = n.y;
			nc = n.count;
			while(1 <= map[nx][ny-1] && map[nx][ny-1] <= 2) {
				nc++;
				if(countmap[nx][ny-1] == -1) {
					qu.add(new Node(nx,ny-1,nc,n.visit));
					countmap[nx][ny-1] = countmap[nx][y] + 1;
				}
				ny--;
			}
			
			nx = n.x;
			ny = n.y;
			nc = n.count;
			while(1 <= map[nx][ny+1] && map[nx][ny+1] <= 2) {
				nc++;
				if(countmap[nx][ny+1] == -1) {
					qu.add(new Node(nx,ny+1,nc,n.visit));
					countmap[nx][ny+1] = countmap[nx][y] + 1;
				}
				ny++;

			}
			
		}
	}
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
			order = new int[w+2][h+2];
			countmap = new int[w+2][h+2];
			comp = new int[21];
			ans = 2000000000;
			Arrays.fill(comp,-1);
			int startX = 0;
			int startY = 0;
			int idx = 0;
			for(int i = 1; i <= w; i++) {
				String[] s = br.readLine().split("");
				Arrays.fill(countmap[i],-1);
				for(int j = 1; j <= h; j++) {
					switch(s[j-1]) {
					case "x":
						map[i][j] = 0;
						break;
						
					case ".":
						map[i][j] = 1;
						break;
						
					case "o":
						map[i][j] = 3;
						startX = i;
						startY = j;
						break;
						
					case "*":
						map[i][j] = 2;
						order[i][j] = idx;
						idx++;
						shift++;
						comp[i] = j;
						break;
					}
				}
			}
			find(startX,startY);
//			for(int i = 0; i <= w+1; i++) {
//				for(int j = 0; j <= h+1; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			System.out.println(ans);
		}
	}

}
