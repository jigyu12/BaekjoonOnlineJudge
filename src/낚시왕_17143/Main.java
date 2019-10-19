package 낚시왕_17143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Fish{
		int x;
		int y;
		int speed;
		int dir;
		int huge;
		
		public Fish(int x, int y, int speed, int dir, int huge) {
			this.x = x;
			this.y = y;
			this.speed = speed;
			this.dir = dir;
			this.huge = huge;
		}

		@Override
		public String toString() {
			return "Fish [x=" + x + ", y=" + y + ", speed=" + speed + ", dir=" + dir + ", huge=" + huge + "]";
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] rcm = br.readLine().split(" ");
		
		int r = Integer.parseInt(rcm[0]);
		int c = Integer.parseInt(rcm[1]);
		int m = Integer.parseInt(rcm[2]);
		
		int[][] prevmap = new int[r+2][c+2];
		
		for(int i = 0; i < r+2; i++) {
			Arrays.fill(prevmap[i], -1);
			if(i > 0 && i < r+1) {
				for(int j = 1; j <= c; j++) {
					prevmap[i][j] = 0;
				}
			}
		}
		
		Queue<Fish> qu = new LinkedList<>();
		
		for(int i = 0; i < m; i++) {
			String[] rcsdh = br.readLine().split(" ");
			int rr = Integer.parseInt(rcsdh[0]);
			int cc = Integer.parseInt(rcsdh[1]);
			int s = Integer.parseInt(rcsdh[2]);
			int d = Integer.parseInt(rcsdh[3])-1;
			if(d == 1) {
				d = 2;
			}
			else if(d == 2) {
				d = 1;
			}
			int h = Integer.parseInt(rcsdh[4]);
			qu.add(new Fish(rr,cc,s,d,h));
			prevmap[rr][cc] = h;
		}
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		int ans = 0;
		// stage 1
		for(int i = 1; i <= c; i++) {
			// stage 2
			int[][] newmap = new int[r+2][c+2];
			for(int k = 0; k < r+2; k++) {
				Arrays.fill(newmap[k], -1);
				if(k > 0 && k < r+1) {
					for(int j = 1; j <= c; j++) {
						newmap[k][j] = 0;
					}
				}
			}
			for(int j = 1; j <= r; j++) {
				if(prevmap[j][i] > 0) {
					ans += prevmap[j][i];
					prevmap[j][i] = 0;
					break;
				}
			}

			int size = qu.size();
			for(int j = 0; j < size; j++) {
				Fish f = qu.poll();

				int x = f.x;
				int y = f.y;
				int s = f.speed;
				int d = f.dir;
				int h = f.huge;
				
				if(prevmap[x][y] != h) {
					continue;
				}

				int mod = 0;
				
				if((d % 2) == 0) {
					mod = 2*(r-1);
				}
				else {
					mod = 2*(c-1);
				}
				
				s %= mod;
				
				if(s == 0) {
					if(newmap[x][y] < h) {
						newmap[x][y] = h;
						qu.add(new Fish(x,y,s,d,h));
					}
					continue;
				}
				
				for(int k = 0; k < s; k++) {
					if(newmap[x+dx[d]][y+dy[d]] >= 0) {
						if(k == s-1) {
							if(newmap[x+dx[d]][y+dy[d]] < h) {
								newmap[x+dx[d]][y+dy[d]] = h;
							}
						}
						x+=dx[d];
						y+=dy[d];
					}
					else {
						d = (d + 2) % 4;
						if(k == s-1) {
							if(newmap[x+dx[d]][y+dy[d]] < h) {
								newmap[x+dx[d]][y+dy[d]] = h;
							}
						}
						x+=dx[d];
						y+=dy[d];
					}
				}
				if(newmap[x][y] == h) {
					qu.add(new Fish(x,y,s,d,h));
				}
			}
			
			prevmap = newmap;

		}
		System.out.println(ans);
	}
}
