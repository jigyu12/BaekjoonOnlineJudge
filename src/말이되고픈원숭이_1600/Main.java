package 말이되고픈원숭이_1600;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Monkey{
		int x;
		int y;
		int horsejump;
		int count;
		
		public Monkey(int x, int y, int horsejump, int count) {
			this.x = x;
			this.y = y;
			this.horsejump = horsejump;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Monkey [x=" + x + ", y=" + y + ", horsejump=" + horsejump + ", count=" + count + "]";
		}
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int k = Integer.parseInt(br.readLine());
		String[] wh = br.readLine().split(" ");
		int w = Integer.parseInt(wh[1]);
		int h = Integer.parseInt(wh[0]);
		
		int[][] map = new int[w+4][h+4];
		boolean[][][] visited = new boolean[31][w+4][h+4];
		
		for(int i = 2; i <= w+1; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 2; j <= h+1; j++) {
				int a = Integer.parseInt(s[j-2]);
				if(a == 0) {
					map[i][j] = 1;
				}
				else {
					map[i][j] = 0;
				}
			}
		}
		
		int ans = 40000;
		Queue<Monkey> qu = new LinkedList<>();
		qu.add(new Monkey(2,2,k,0));
		visited[k][2][2] = true;
		while(!qu.isEmpty()) {
			Monkey m = qu.poll();
			
			int mx = m.x;
			int my = m.y;
			int mh = m.horsejump;
			int mc = m.count;
			
			
			if(mx == w+1 && my == h+1) {
				if(ans > mc) {
					ans = mc;
				}
				continue;
			}
			
			if(ans <= mc) {
				continue;
			}
			
			if(mh > 0 && !visited[mh-1][mx-1][my-2] && map[mx-1][my-2] == 1) {
				visited[mh-1][mx-1][my-2] = true;
				qu.add(new Monkey(mx-1,my-2,mh-1,mc+1));
			}
			
			if(mh > 0 && !visited[mh-1][mx-2][my-1] && map[mx-2][my-1] == 1) {
				visited[mh-1][mx-2][my-1] = true;
				qu.add(new Monkey(mx-2,my-1,mh-1,mc+1));
			}
			
			if(mh > 0 && !visited[mh-1][mx-1][my+2] && map[mx-1][my+2] == 1) {
				visited[mh-1][mx-1][my+2] = true;
				qu.add(new Monkey(mx-1,my+2,mh-1,mc+1));
			}
			
			if(mh > 0 && !visited[mh-1][mx-2][my+1] && map[mx-2][my+1] == 1) {
				visited[mh-1][mx-2][my+1] = true;
				qu.add(new Monkey(mx-2,my+1,mh-1,mc+1));
			}
			
			if(mh > 0 && !visited[mh-1][mx+1][my+2] && map[mx+1][my+2] == 1) {
				visited[mh-1][mx+1][my+2] = true;
				qu.add(new Monkey(mx+1,my+2,mh-1,mc+1));
			}
			
			if(mh > 0 && !visited[mh-1][mx+2][my+1] && map[mx+2][my+1] == 1) {
				visited[mh-1][mx+2][my+1] = true;
				qu.add(new Monkey(mx+2,my+1,mh-1,mc+1));
			}
			
			if(mh > 0 && !visited[mh-1][mx+1][my-2] && map[mx+1][my-2] == 1) {
				visited[mh-1][mx+1][my-2] = true;
				qu.add(new Monkey(mx+1,my-2,mh-1,mc+1));
			}
			
			if(mh > 0 && !visited[mh-1][mx+2][my-1] && map[mx+2][my-1] == 1) {
				visited[mh-1][mx+2][my-1] = true;
				qu.add(new Monkey(mx+2,my-1,mh-1,mc+1));
			}
			
			if(!visited[mh][mx-1][my] && map[mx-1][my] == 1) {
				visited[mh][mx-1][my] = true;
				qu.add(new Monkey(mx-1,my,mh,mc+1));
			}
			if(!visited[mh][mx+1][my] && map[mx+1][my] == 1) {
				visited[mh][mx+1][my] = true;
				qu.add(new Monkey(mx+1,my,mh,mc+1));
			}
			
			if(!visited[mh][mx][my-1] && map[mx][my-1] == 1) {
				visited[mh][mx][my-1] = true;
				qu.add(new Monkey(mx,my-1,mh,mc+1));
			}
			
			if(!visited[mh][mx][my+1] && map[mx][my+1] == 1) {
				visited[mh][mx][my+1] = true;
				qu.add(new Monkey(mx,my+1,mh,mc+1));
			}
			
		}
		if(ans == 40000) {
			System.out.println("-1");
		}
		else {
			System.out.println(ans);
		}
	}
}
