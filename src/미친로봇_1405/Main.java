package 미친로봇_1405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Main {
	
	private static int num;
	private static double e;
	private static double w;
	private static double s;
	private static double n;
	private static boolean[][] visited;
	private static double ans;
	
	private static void find(int x, int y, int c, double p) {
		
		if(c == num) {
			ans += p;
			return ;
		}
		
		if(!visited[x-1][y]) {
			visited[x-1][y] = true;
			find(x-1,y,c+1, p * n);
			visited[x-1][y] = false;
		}
		
		if(!visited[x+1][y]) {
			visited[x+1][y] = true;
			find(x+1,y,c+1,  p * s);
			visited[x+1][y] = false;
		}
		
		if(!visited[x][y-1]) {
			visited[x][y-1] = true;
			find(x,y-1,c+1, p * w);
			visited[x][y-1] = false;
		}
		
		if(!visited[x][y+1]) {
			visited[x][y+1] = true;
			find(x,y+1,c+1,  p * e);
			visited[x][y+1] = false;
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] st = br.readLine().split(" ");
		num = Integer.parseInt(st[0]);
		e = Integer.parseInt(st[1]) / 100.0;
		w = Integer.parseInt(st[2]) / 100.0;
		s = Integer.parseInt(st[3]) / 100.0;
		n = Integer.parseInt(st[4]) / 100.0;
		
		visited = new boolean[50][50];
		ans = 0;
		visited[25][25] = true;
		find(25,25,0,1);
		BigDecimal b = new BigDecimal(ans).setScale(9, RoundingMode.HALF_UP);
		System.out.println(b.toString());
	}
}
