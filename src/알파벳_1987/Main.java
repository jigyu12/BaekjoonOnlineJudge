package 알파벳_1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int[][] map;
	private static int ans;
	
	public static void find(int xx, int yy,int v,boolean[] b) {
		int x = xx;
		int y = yy;
		int visit = v;
		int alpha = map[x][y];
		boolean[] check = new boolean[b.length];
		for(int i = 0; i < b.length; i++) {
			check[i] = b[i];
		}
		
		if(check[alpha]) {
			if(visit-1 > ans) {
				ans = visit-1;
			}
			return ;
		}
		check[alpha] = true;
		
		find(x-1,y,visit+1,check);
		find(x+1,y,visit+1,check);
		find(x,y-1,visit+1,check);
		find(x,y+1,visit+1,check);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] rc = br.readLine().split(" ");
			int r = Integer.parseInt(rc[0]);
			int c = Integer.parseInt(rc[1]);
			boolean[] check = new boolean[91];
			map = new int[r+2][c+2];
			ans = 1;
			for(int i = 1; i < r+1; i++) {
				String s = br.readLine();
				for(int j = 1; j < c+1; j++) {
					map[i][j] = s.charAt(j-1);
				}
			}
			check[0] = true;
			find(1,1,1,check);
			System.out.println(ans);
		} catch (IOException e) {}
	}
}