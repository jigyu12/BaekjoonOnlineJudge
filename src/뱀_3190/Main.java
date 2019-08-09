package 뱀_3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Change{
		int t;
		int d;
		
		public Change(int t, int d) {
			this.t = t;
			this.d = d;
		}

		@Override
		public String toString() {
			return "Change [t=" + t + ", d=" + d + "]";
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n+2][n+2];
		int[][] dirmap = new int[n+2][n+2];
		for(int i = 0; i < n+2; i++) {
			for(int j = 0; j < n+2; j++) {
				if(i == 0 || i == n+1 || j == 0 || j == n+1) {
					map[i][j] = -1;
				}
			}
		}
		dirmap[1][1] = 1;
		map[1][1] = -1;
		int k = Integer.parseInt(br.readLine());
		for(int i = 0; i < k; i++) {
			String[] s = br.readLine().split(" ");
			map[Integer.parseInt(s[0])][Integer.parseInt(s[1])] = 1;
		}
		
	
		
		int l = Integer.parseInt(br.readLine());
		Queue<Change> qu = new LinkedList<>();
		
		for(int i = 0 ; i < l; i++) {
			String[] s = br.readLine().split(" ");
			int t = Integer.parseInt(s[0]) - 1;

			switch(s[1]) {
			case "D":
				qu.add(new Change(t,+1));
				break;
				
			case "L":
				qu.add(new Change(t,-1));
				break;
			}
		}

		
		int dir = 1, hx = 1, hy = 1, tx = 1, ty = 1;

		int time = 0;
		int tdir = 1;
		
		while(true) {
//			
//			for(int i = 0; i < n+2; i++) {
//				for(int j = 0; j < n+2; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
//			
//
//			
			boolean tailmove = true;
			switch(dir) {
			case 0:
				if(map[hx-1][hy] == 1) {
					tailmove = false;
				}
				if(!qu.isEmpty() && qu.peek().t ==  time) {
					Change c = qu.poll();
					dir += c.d;
					if(dir < 0) {
						dir += 4;
					}
					dir %= 4;
				}
		
				dirmap[hx-1][hy] = dir;		
				hx--;
				break;
				
			case 1:
				if(map[hx][hy+1] == 1) {
					tailmove = false;
				}
				if(!qu.isEmpty() && qu.peek().t ==  time) {
					Change c = qu.poll();
					dir += c.d;
					if(dir < 0) {
						dir += 4;
					}
					dir %= 4;
				}
			
				dirmap[hx][hy+1] = dir;
				hy++;
				break;
				
			case 2:
				if(map[hx+1][hy] == 1) {
					tailmove = false;
				}
				if(!qu.isEmpty() && qu.peek().t ==  time) {
					Change c = qu.poll();
					dir += c.d;
					if(dir < 0) {
						dir += 4;
					}
					dir %= 4;
				}
				
				dirmap[hx+1][hy] = dir;
				hx++;
				break;
				
			case 3:
				if(map[hx][hy-1] == 1) {
					tailmove = false;
				}
				if(!qu.isEmpty() && qu.peek().t ==  time) {
					Change c = qu.poll();
					dir += c.d;
					if(dir < 0) {
						dir += 4;
					}
					dir %= 4;
				}
				dirmap[hx][hy-1] = dir;
				hy--;
				break;
			}
			if(map[hx][hy] == -1) {
				break;
			}
			
			map[hx][hy] = -1;
			
			if(tailmove) {
				map[tx][ty] = 0;
				switch(tdir) {
				case 0:
					tx--;
					tdir = dirmap[tx][ty];
					break;
				case 1:
					ty++;
					tdir = dirmap[tx][ty];
					break;
				case 2:
					tx++;
					tdir = dirmap[tx][ty];
					break;
				case 3:
					ty--;
					tdir = dirmap[tx][ty];
					break;
				}
			}

			time++;
		}
		System.out.println(time+1);
	}

}
