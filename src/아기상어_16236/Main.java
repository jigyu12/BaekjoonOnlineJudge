package 아기상어_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	static class Shark {
		int x;
		int y;
		int height;
		int eat;
		int move;
		
		public Shark(int x, int y, int height, int eat, int move) {
			this.x = x;
			this.y = y;
			this.height = height;
			this.eat = eat;
			this.move = move;
		}
		
	}
	
	static class Fish implements Comparable<Fish>{
		int x;
		int y;
		int cnt;
		
		public Fish(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public int compareTo(Fish o) {
			if(this.x == o.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}
	}
	
	static Shark sh;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] map = new int[n+2][n+2];
		for(int i = 0; i < n+2; i++) {
			Arrays.fill(map[i], -1);
		}
		
		sh = new Shark(0,0,2,0,0);
		
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
				if(map[i][j] == 9) {
					sh.x = i;
					sh.y = j;
					map[i][j] = 0;
				}
			}
		}
		
		Queue<Shark> qu = new LinkedList<>();
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		int ans = 0;
		
		boolean noFish = false;
		while(!noFish) {
			boolean[][] visited = new boolean[n+2][n+2];
			PriorityQueue<Fish> pq = new PriorityQueue<>();
			qu.add(sh);
			visited[sh.x][sh.y] = true;
			boolean eatFish = false;
			while(!eatFish && !qu.isEmpty()) {
				int size = qu.size();
				for(int k = 0; k < size; k++) {
					Shark s = qu.poll();

					int x = s.x;
					int y = s.y;
					int h = s.height;
					int e = s.eat;
					int m = s.move;
					
					for(int i = 0; i < 4; i++) {
						if(map[x+dx[i]][y+dy[i]] >= 0 && !visited[x+dx[i]][y+dy[i]]) {
							if(map[x+dx[i]][y+dy[i]] > h) {
								continue;
							}
							else if(map[x+dx[i]][y+dy[i]] == h || map[x+dx[i]][y+dy[i]] == 0) {
								qu.add(new Shark(x+dx[i],y+dy[i],h,e,m+1));
								
							}
							else {
								eatFish = true;
								pq.add(new Fish(x+dx[i],y+dy[i],m+1));
							}
							visited[x+dx[i]][y+dy[i]] = true;
						}
					}
				}
			}
			
			if(!eatFish) {
				noFish = true;
				break;
			}
			
			if(!qu.isEmpty()) {
				qu.clear();
			}

			Fish f = pq.poll();

			pq.clear();
			sh.x = f.x;
			sh.y = f.y;
			map[f.x][f.y] = 0;
			
			sh.eat++;
			if(sh.height == sh.eat) {
				++sh.height;
				sh.eat = 0;
			}
			ans += f.cnt;

		}
		
		System.out.println(ans);
	}
}
