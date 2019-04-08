package 거울설치_2151;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Light{
		int x;
		int y;
		int count;
		int dir;
		
		public Light(int x, int y, int count, int dir) {
			this.x = x;
			this.y = y;
			this.count = count;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Light [x=" + x + ", y=" + y + ", count=" + count + ", dir=" + dir + "]";
		}
		
	}
	
	private static int[][] map;
	private static int[][][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		map = new int[num+2][num+2];
		visited = new int[4][num+2][num+2];
		int mirror = -1;
		Queue<Light> qu = new LinkedList<>();
		for(int i = 1; i <= num ; i++) {
			String[] s = br.readLine().split("");
			for(int j = 0; j < 4; j++) {
				Arrays.fill(visited[j][i], 2500);
			}
			for(int j = 1; j <= num ; j++) {
				switch(s[j-1]) {
				case ".":
					map[i][j] = 1;
					break;
					
				case "!":
					map[i][j] = 2;
					break;
					
				case "#":
					if(mirror == -1) {
						qu.add(new Light(i,j,0,0));
						qu.add(new Light(i,j,0,1));
						qu.add(new Light(i,j,0,2));
						qu.add(new Light(i,j,0,3));
					}
					map[i][j] = mirror;
					mirror = 3;
					break;
				}
			}
		}
		
		int ans = 2500;
		
		while(!qu.isEmpty()) {
			Light l = qu.poll();
			int lx = l.x;
			int ly = l.y;
			int ld = l.dir;
			int lc = l.count;
			
			if(map[lx][ly] == 3) {
				if(ans > lc) {
					ans = lc;
				}
				continue;
			}
			
			if(ans <= lc) {
				continue;
			}
			
			if(map[lx][ly] == 2) {
				if(ld % 2 == 0) {
					if(visited[1][lx][ly+1] > lc+1 && map[lx][ly+1] > 0) {
						visited[1][lx][ly+1] = lc+1;
						qu.add(new Light(lx,ly+1,lc+1,1));
					}
					if(visited[3][lx][ly-1] > lc+1 && map[lx][ly-1] > 0) {
						visited[3][lx][ly-1] = lc+1;
						qu.add(new Light(lx,ly-1,lc+1,3));
					}
				}
				else {
					if(visited[0][lx-1][ly] > lc+1 && map[lx-1][ly] > 0) {
						visited[0][lx-1][ly] = lc+1;
						qu.add(new Light(lx-1,ly,lc+1,0));
					}
					if(visited[2][lx+1][ly] > lc+1 && map[lx+1][ly] > 0) {
						visited[2][lx+1][ly] = lc+1;
						qu.add(new Light(lx+1,ly,lc+1,2));
					}
				}
			}
			
			switch(ld) {
			case 0:
				if(visited[0][lx-1][ly] > lc && map[lx-1][ly] > 0) {
					visited[0][lx-1][ly] = lc;
					qu.add(new Light(lx-1,ly,lc,0));
				}
				break;
				
			case 1:
				if(visited[1][lx][ly+1] > lc && map[lx][ly+1] > 0) {
					visited[1][lx][ly+1] = lc;
					qu.add(new Light(lx,ly+1,lc,1));
				}
				break;
				
			case 2:
				if(visited[2][lx+1][ly] > lc && map[lx+1][ly] > 0) {
					visited[2][lx+1][ly] = lc;
					qu.add(new Light(lx+1,ly,lc,2));
				}
				break;
				
			case 3:
				if(visited[3][lx][ly-1] > lc && map[lx][ly-1] > 0) {
					visited[3][lx][ly-1] = lc;
					qu.add(new Light(lx,ly-1,lc,3));
				}
				break;
			}
			
		}
		
		System.out.println(ans);
//		for(int i = 1; i <= num ; i++) {
//			for(int j = 1; j <= num ; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		
		
	}
}
