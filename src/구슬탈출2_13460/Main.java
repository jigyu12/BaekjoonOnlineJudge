package ±¸½½Å»Ãâ2_13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static class Marble{
		int x;
		int y;
		
		public Marble(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Marble [x=" + x + ", y=" + y + "]";
		}
		
	}
	
	private static int n;
	private static int m;
	private static int[][] map;
	private static Marble red;
	private static Marble blue;
	private static Marble holl;
	private static int ans;
	private static boolean redarrive;
	private static boolean bluearrive;
	private static boolean[][][] visited;
	
	private static void roll(int x, int y, int count,int dir, int color) {
		
		if(x == holl.x && y == holl.y) {
			if(color == 0) {
				if(ans > count) {
					ans = count;
				}
				redarrive = true;
			}
			else {
				bluearrive = true;
			}
			return ;
		}
		
		if(count > 10) {
			return ;
		}
		
		visited[color][x][y] = true;
		
		if(!visited[color][x-1][y] && map[x-1][y] >= 3) {
			int temp = map[x-1][y];
			map[x-1][y] = color;
			
			map[x][y] = 4;
			if(dir == 1) {
				roll(x-1,y,count,1,color);
			}
			else {
				roll(x-1,y,count+1,1,color);
			}
			map[x-1][y] = temp;
			map[x][y] = color;
		}
		
		if(!visited[color][x+1][y] && map[x+1][y] >= 3) {
			int temp = map[x+1][y];
			map[x+1][y] = color;
			map[x][y] = 4;
			if(dir == 2) {
				roll(x+1,y,count,2,color);
			}
			else {
				roll(x+1,y,count+1,2,color);
			}
			map[x+1][y] = temp;
			map[x][y] = color;
		}
		
		if(!visited[color][x][y-1] && map[x][y-1] >= 3) {
			int temp = map[x][y-1];
			map[x][y-1] = color;
			map[x][y] = 4;
			if(dir == 3) {
				roll(x,y-1,count,3,color);
			}
			else {
				roll(x,y-1,count+1,3,color);
			}
			map[x][y-1] = temp;
			map[x][y] = color;
		}
		
		if(!visited[color][x][y+1] && map[x][y+1] >= 3) {
			int temp = map[x][y+1];
			map[x][y+1] = color;
			map[x][y] = 4;
			if(dir == 3) {
				roll(x,y+1,count,4,color);
			}
			else {
				roll(x,y+1,count+1,4,color);
			}
			map[x][y+1] = temp;
			map[x][y] = color;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		ans = 11;
		map = new int[n][m];
		visited = new boolean[3][n][m];
		
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split("");
			for(int j = 0; j < m; j++) {
				switch(s[j]) {
				case ".":
					map[i][j] = 4;
					break;
					
				case "O":
					map[i][j] = 3;
					holl = new Marble(i,j);
					break;
					
				case "R":
					map[i][j] = 1;
					red = new Marble(i,j);
					break;
					
				case "B":
					map[i][j] = 2;
					blue = new Marble(i,j);
					break;
				}
			}
		}
		for(int k = 0; k < 10; k++) {
			for(int i = 1; i <= 4; i++) {
				roll(red.x,red.y,0,i,1);
				roll(blue.x,blue.y,0,i,2);
				if(redarrive) {
					if(bluearrive) {
						ans = 11;
					}
					break;
				}
				if(bluearrive) {
					ans = 11;
					break;
				}
			}
		}
		
		
		if(ans == 11) {
			System.out.println("-1");
		}
		else {
			System.out.println(ans);
		}
		
	}
}
