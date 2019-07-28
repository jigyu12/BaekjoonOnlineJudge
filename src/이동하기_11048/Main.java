package 이동하기_11048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int[][] map = new int[n+2][m+2];
		int[][] sum = new int[n+2][m+2];
		for(int i = 1 ; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		
		for(int i = 1 ; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				sum[i][j] += Math.max(sum[i-1][j-1], Math.max(sum[i-1][j], sum[i][j-1])) + map[i][j];
			}
		}
		System.out.println(sum[n][m]);
	}
}
