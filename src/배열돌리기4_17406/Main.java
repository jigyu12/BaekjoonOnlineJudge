package 배열돌리기4_17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static int m;
	static int k;
	static int[][] map;
	static Rotate[] rot;
	static int[] permu;
	static int ans;
	
	static class Rotate{
		int x;
		int y;
		int r;
		
		public Rotate(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}

		@Override
		public String toString() {
			return "Rotate [x=" + x + ", y=" + y + ", r=" + r + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nmk = br.readLine().split(" ");
		n = Integer.parseInt(nmk[0]);
		m = Integer.parseInt(nmk[1]);
		k = Integer.parseInt(nmk[2]);
		
		map = new int[n][m];
		rot = new Rotate[k];
		permu = new int[k];
		ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		for(int i = 0; i < k; i++) {
			String[] rcs = br.readLine().split(" ");
			int r = Integer.parseInt(rcs[0]) - 1;
			int c = Integer.parseInt(rcs[1]) - 1;
			int s = Integer.parseInt(rcs[2]);
			rot[i] = new Rotate(r, c, s);
		}
		
		permutation(0,0);
		System.out.println(ans);
	}

	private static void permutation(int state, int count) {
		if(count == k) {
			rotate();
		}
		
		for(int i = 0; i < k; i++) {
			if((state & (1 << i)) == 0) {
				permu[count] = i;
				permutation(state | (1<<i), count + 1);
			}
		}
	}

	private static void rotate() {
		int[][] draw = new int[n][m];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				draw[i][j] = map[i][j];
			}
		}
		
		for(int i = 0; i < k; i++) {
			Rotate ro = rot[permu[i]];
			int x = ro.x;
			int y = ro.y;
			int r = ro.r;
			
			for(int j = 1; j <= r; j++) {
				int sx = x-j;
				int sy = y-j;
				int start = draw[sx][sy];
				for(int z = 0; z < j * 2; z++) {
					draw[sx][sy] = draw[sx+1][sy];
					sx++;
				}
				for(int z = 0; z < j * 2; z++) {
					draw[sx][sy] = draw[sx][sy+1];
					sy++;
				}
				for(int z = 0; z < j * 2; z++) {
					draw[sx][sy] = draw[sx-1][sy];
					sx--;
				}
				for(int z = 0; z < j * 2 - 1; z++) {
					draw[sx][sy] = draw[sx][sy-1];
					sy--;
				}
				draw[sx][sy] = start;
			}
		}
		
		
		for(int i = 0; i < n; i++) {
			int sum = 0;
			for(int j = 0; j < m; j++) {
				sum += draw[i][j];
			}
			if(ans > sum) {
				ans = sum;
			}
		}
	}

}
