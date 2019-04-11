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
	
	private static void start(int count,int dir) {
		if(count > 10) {
			return ;
		}

		redarrive = false;
		bluearrive = false;
	
		int rx = red.x;
		int ry = red.y;
		int bx = blue.x;
		int by = blue.y;
		
		for(int i = 0; i < 4; i++) {
			
			if((dir+2) % 4 == i) {
				continue;
			}

			roll(i);

			if(redarrive && !bluearrive) {
				if(ans > count) {
					ans = count;
				}
				return;
			}
			if(bluearrive) {
				return;
			}
			if(ans < count) {
				return;
			}
			start(count+1,i);
			redarrive = false;
			bluearrive = false;
			red.x = rx;
			red.y = ry;
			blue.x = bx;
			blue.y = by;
		}
	}

	
	private static void roll(int dir) {
		
			int x = blue.x;
			int y = blue.y;
			
			if(x == holl.x && y == holl.y) {
				bluearrive = true;
				return;
			}
			
			switch(dir) {
			case 0:
				if(map[x-1][y] >= 3) {
					if((red.x != x-1 || red.y != y) ) {
						blue.x--;
						roll(dir);
					}
					else if((red.x == x-1 && red.y == y) ) {
						blue.x = x;
						blue.y = y;
					}
				}
				else {

						blue.x = x;
						blue.y = y;
				}
				break;
			case 1:
				if(map[x][y+1] >= 3) {
					if((red.x != x || red.y != y+1) ) {
						blue.y++;
						roll(dir);
					}
					else if((red.x == x && red.y == y+1) ) {
						blue.x = x;
						blue.y = y;
					}
				}
				else {
						blue.x = x;
						blue.y = y;
				}
				break;
			case 2:
				if(map[x+1][y] >= 3) {
					if((red.x != x+1 || red.y != y) ) {
						blue.x++;
						roll(dir);
					}
					else if((red.x == x+1 && red.y == y) ) {
						blue.x = x;
						blue.y = y;
					}
				}
				else {
						blue.x = x;
						blue.y = y;
				}
				break;
			case 3:
				if(map[x][y-1] >= 3) {
					if((red.x != x || red.y != y-1) ) {
						blue.y--;
						roll(dir);
					}
					else if((red.x == x && red.y == y-1) ) {
						blue.x = x;
						blue.y = y;
					}
				}
				else {
						blue.x = x;
						blue.y = y;
				}
				break;
			}
	
			x = red.x;
			y = red.y;
			if(x == holl.x && y == holl.y) {
				redarrive = true;
				return;
			}
			
			switch(dir) {
			case 0:
				if(map[x-1][y] >= 3) {
					if(blue.x != x-1 || blue.y != y) {
						red.x--;
						roll(dir);
					}
					else if ((blue.x == x-1 && blue.y == y)) {
						red.x = x;
						red.y = y;
					}
				}
				else {
					red.x = x;
					red.y = y;

				}
				break;
			case 1:
				if(map[x][y+1] >= 3) {
					if((blue.x != x || blue.y != y+1)) {
						red.y++;
						roll(dir);
					}
					else if((blue.x == x && blue.y == y+1)) {
						red.x = x;
						red.y = y;
					}
				}
				else {
						red.x = x;
						red.y = y;

				}
				break;
			case 2:
				if(map[x+1][y] >= 3) {
					if((blue.x != x+1 || blue.y != y)) {
						red.x++;
						roll(dir);
					}
					else if ((blue.x == x+1 && blue.y == y)) {
						red.x = x;
						red.y = y;
					}
				}
				else {

						red.x = x;
						red.y = y;

				}
				break;
			case 3:
				if(map[x][y-1] >= 3) {
					if((blue.x != x || blue.y != y-1)) {
						red.y--;
						roll(dir);
					}
					else if((blue.x == x && blue.y == y-1)) {
						red.x = x;
						red.y = y;
					}
				}
				else {
						red.x = x;
						red.y = y;

				}
				break;
			}

			
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		
		n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		ans = 11;
		map = new int[n][m];
		redarrive = false;
		bluearrive = false;
		
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
					map[i][j] = 4;
					red = new Marble(i,j);
					break;
					
				case "B":
					map[i][j] = 4;
					blue = new Marble(i,j);
					break;
				}
			}
		}

		for(int i = 0 ; i < 4; i++) {
			start(1,i);
		}
		
		if(ans == 11) {
			System.out.println("-1");
		}
		else {
			System.out.println(ans);
		}
	}
}
