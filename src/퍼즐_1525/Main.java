package 퍼즐_1525;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static int map[][];
	static int ans = Integer.MAX_VALUE;
	static int[][] puzzle = {{0,0,0,0,0},{0,2,3,4,0},{0,5,6,7,0},{0,8,9,1,0},{0,0,0,0,0}};
	static boolean[][][] dp = new boolean[5][5][10];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		map = new int[5][5];
		
		int x = 1, y = 1;
		for(int i = 1; i <= 3; i++) {
			String[] s = br.readLine().split(" " );
			for(int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(s[j-1]) + 1;
				dp[i][j][map[i][j]] = true;
				if(map[i][j] == 1) {
					x = i;
					y = j;
				}
			}
		}
		
		move(x,y,0);
		System.out.println(ans);
	}

	private static void move(int x, int y, int cnt) {
		if(isSame()) {
			if(ans > cnt) {
				ans = cnt;
			}
			return;
		}
		
		if(ans <= cnt) {
			return;
		}
		System.out.println(x + " " + y);
		dp[x][y][map[x][y]] = true;
		
		if(!dp[x-1][y][map[x][y]] && map[x-1][y] > 0) {
			swap(x,y,x-1,y);
			move(x-1,y,cnt+1);
			swap(x,y,x-1,y);
		}
		
		if(!dp[x+1][y][map[x][y]] && map[x+1][y] > 0) {
			swap(x,y,x+1,y);
			move(x+1,y,cnt+1);
			swap(x,y,x+1,y);
		}
		
		if(!dp[x][y-1][map[x][y]] && map[x][y-1] > 0) {
			swap(x,y,x,y-1);
			move(x,y-1,cnt+1);
			swap(x,y,x,y-1);
		}
		
		if(!dp[x][y+1][map[x][y]] && map[x][y+1] > 0) {
			swap(x,y,x,y+1);
			move(x,y-1,cnt+1);
			swap(x,y,x,y+1);
		}
	}

	private static void swap(int x, int y, int x2, int y2) {
		int temp = map[x][y];
		map[x][y] = map[x2][y2];
		map[x2][y2] = temp;
	}

	private static boolean isSame() {
		for(int i = 1; i <= 3; i++) {
			for(int j = 1; j <= 3; j++) {
				if(map[i][j] != puzzle[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

}
