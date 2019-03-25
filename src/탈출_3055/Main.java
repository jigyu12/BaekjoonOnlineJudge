package ≈ª√‚_3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Water{
		int x;
		int y;
		
		public Water(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Water [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	static class Hedgehog{
		int x;
		int y;
		int time;
		
		public Hedgehog(int x, int y, int time) {
			this.x = x;
			this.y = y;
			this.time = time;
		}

		@Override
		public String toString() {
			return "Hedgehog [x=" + x + ", y=" + y + ", time=" + time + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] rc = br.readLine().split(" ");
		int r = Integer.parseInt(rc[0]);
		int c = Integer.parseInt(rc[1]);
		
		int[][] map = new int[r+2][c+2];
		boolean[][] visited = new boolean[r+2][c+2];
		Queue<Hedgehog> he = new LinkedList<>();
		Queue<Water> wa = new LinkedList<>();
		int dx = 0;
		int dy = 0;
		int ans = 2500;
		
		for(int i = 1; i <= r; i++) {
			String[] s = br.readLine().split("");
			for(int j = 1; j <= c; j++) {
				switch(s[j-1]) {
				case "X":
					visited[i][j] = true;
					break;
					
				case "*":
					map[i][j] = 1;
					visited[i][j] = true;
					wa.add(new Water(i,j));
					break;
					
				case ".":
					map[i][j] = 2;
					break;
					
				case "S":
					he.add(new Hedgehog(i,j,0));
					visited[i][j] = true;
					map[i][j] = 3;
					break;
					
				case "D":
					dx = i;
					dy = j;
					map[i][j] = 4;
					break;
				}
			}
		}
		
		
		
		while(!he.isEmpty()) {
			int wsize = wa.size();
			for(int i = 0; i < wsize; i++) {
				Water w = wa.poll();
				int wx = w.x;
				int wy = w.y;
				
				
				if(!visited[wx-1][wy] && map[wx-1][wy] == 2) {
					visited[wx-1][wy] = true;
					map[wx-1][wy] = 1;
					wa.add(new Water(wx-1,wy));
				}
				if(!visited[wx+1][wy] && map[wx+1][wy] == 2) {
					visited[wx+1][wy] = true;
					map[wx+1][wy] = 1;
					wa.add(new Water(wx+1,wy));
				}
				if(!visited[wx][wy-1] && map[wx][wy-1] == 2) {
					visited[wx][wy-1] = true;
					map[wx][wy-1] = 1;
					wa.add(new Water(wx,wy-1));
				}
				if(!visited[wx][wy+1] && map[wx][wy+1] == 2) {
					visited[wx][wy+1] = true;
					map[wx][wy+1] = 1;
					wa.add(new Water(wx,wy+1));
				}
			}
			
			int hsize = he.size();
			for(int i = 0; i < hsize; i++) {
				Hedgehog h = he.poll();
				int hx = h.x;
				int hy = h.y;
				int ht = h.time;
				
				if(hx == dx && hy == dy) {
					if(ans > ht) {
						ans = ht;
					}
					continue;
				}
				
				if(ans <= ht) {
					continue;
				}
				
				if(!visited[hx-1][hy] && map[hx-1][hy] >= 2) {
					visited[hx-1][hy] = true;
					he.add(new Hedgehog(hx-1,hy,ht+1));
				}
				if(!visited[hx+1][hy] && map[hx+1][hy] >= 2) {
					visited[hx+1][hy] = true;
					he.add(new Hedgehog(hx+1,hy,ht+1));
				}
				if(!visited[hx][hy-1] && map[hx][hy-1] >= 2) {
					visited[hx][hy-1] = true;
					he.add(new Hedgehog(hx,hy-1,ht+1));
				}
				if(!visited[hx][hy+1] && map[hx][hy+1] >= 2) {
					visited[hx][hy+1] = true;
					he.add(new Hedgehog(hx,hy+1,ht+1));
				}
			}
		}
		if(ans == 2500) {
			System.out.println("KAKTUS");
		}
		else {
			System.out.println(ans);
		}
	}
}
