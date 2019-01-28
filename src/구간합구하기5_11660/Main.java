package 구간합구하기5_11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			
			int[][] map = new int[n+1][n+1];
			int[][] sum = new int[n+1][n+1];
			for(int i = 1; i <= n; i++ ) {
				String[] s = br.readLine().split(" ");
				for(int j = 1; j <= n; j++) {
					map[i][j] = Integer.parseInt(s[j-1]);
					sum[i][j] = sum[i-1][j] + sum[i][j-1] -sum[i-1][j-1] + map[i][j];
				}
			}
			
			for(int i = 0; i < m; i++ ) {
				String[] s = br.readLine().split(" ");
				int x1 = Integer.parseInt(s[0]);
				int y1 = Integer.parseInt(s[1]);
				int x2 = Integer.parseInt(s[2]);
				int y2 = Integer.parseInt(s[3]);

				int ans = sum[x2][y2] - sum[x1-1][y2] - sum[x2][y1-1] + sum[x1-1][y1-1];
				System.out.println(ans);
			}
			
		} catch (IOException e) {
		}
	}
}
