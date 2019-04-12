package 아기상어_16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Shark implements Comparable<Shark>{
		int x;
		int y;
		int size;
		int eat;
		
		public Shark(int x, int y, int size, int eat) {
			this.x = x;
			this.y = y;
			this.size = size;
			this.eat = eat;
		}

		@Override
		public String toString() {
			return "Shark [x=" + x + ", y=" + y + ", size=" + size + ", eat=" + eat + "]";
		}
		
		@Override
		public int compareTo(Shark o) {
			if(o.x == this.x) {
				return this.y - o.y;
			}
			return this.x - o.x;
		}

	}
	
	private static Shark sh;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int map[][] = new int[num+2][num+2];
		sh = null;
		Queue<Shark> qu = new LinkedList<>();
		int cntfish = 0;
		for(int i = 0; i < num+2; i++) {
			Arrays.fill(map[i], 50);
		}
 		for(int i = 1 ; i <= num; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 1 ; j <= num; j++) {
				int a = Integer.parseInt(s[j-1]);
				if(a < 9) {
					map[i][j] = a;
					cntfish++;
				}
				else if(a == 9) {
					sh = new Shark(i,j,2,0);
					qu.add(sh);
					map[i][j] = 0;
				}
			}
		}
		
		int ans = 0;
		
		for(int i = 0; i < cntfish; i++) {
			int count = 0;

			ArrayList<Shark> ar = new ArrayList<>();
			boolean[][] visited = new boolean[num+2][num+2];
			visited[sh.x][sh.y] = true;
			boolean eatfish = false;
			while(!qu.isEmpty()) {

				int size = qu.size();
				for(int j = 0 ; j < size; j++) {
					Shark s = qu.poll();
					int sx = s.x;
					int sy = s.y;
					int ss = s.size;
					int se = s.eat;
					
					if(!visited[sx-1][sy] && map[sx-1][sy] <= ss) {
						if(map[sx-1][sy] > 0 && map[sx-1][sy] < ss) {
							eatfish = true;
							if(se + 1 == ss) {
								ar.add(new Shark(sx-1,sy,ss+1,0));
							}
							else {
								ar.add(new Shark(sx-1,sy,ss,se+1));
							}
						}
						else {
							qu.add(new Shark(sx-1,sy,ss,se));
						}
						visited[sx-1][sy] = true;
					}
					
					if(!visited[sx+1][sy] && map[sx+1][sy] <= ss) {
						if(map[sx+1][sy] > 0 && map[sx+1][sy] < ss) {
							eatfish = true;
							if(se + 1 == ss) {
								ar.add(new Shark(sx+1,sy,ss+1,0));
							}
							else {
								ar.add(new Shark(sx+1,sy,ss,se+1));
							}
						}
						else {
							qu.add(new Shark(sx+1,sy,ss,se));
						}
						visited[sx+1][sy] = true;
					}
					
					if(!visited[sx][sy-1] && map[sx][sy-1] <= ss) {
						if(map[sx][sy-1] > 0 && map[sx][sy-1] < ss) {
							eatfish = true;
							if(se + 1 == ss) {
								ar.add(new Shark(sx,sy-1,ss+1,0));
							}
							else {
								ar.add(new Shark(sx,sy-1,ss,se+1));
							}
						}
						else {
							qu.add(new Shark(sx,sy-1,ss,se));
						}
						visited[sx][sy-1] = true;
					}
					
					if(!visited[sx][sy+1] && map[sx][sy+1] <= ss) {
						if(map[sx][sy+1] > 0 && map[sx][sy+1] < ss) {
							eatfish = true;
							if(se + 1 == ss) {
								ar.add(new Shark(sx,sy+1,ss+1,0));
							}
							else {
								ar.add(new Shark(sx,sy+1,ss,se+1));
							}
						}
						else {
							qu.add(new Shark(sx,sy+1,ss,se));
						}
						visited[sx][sy+1] = true;
					}
				}
				count++;
				if(eatfish) {
					qu.clear();
				}
			}
			if(ar.size() == 0) {
				break;
			}
			Collections.sort(ar);
			sh = ar.get(0);
			
			map[sh.x][sh.y] = 0;
			qu.add(sh);
			ans += count;
		}
		System.out.println(ans);
	}
}
