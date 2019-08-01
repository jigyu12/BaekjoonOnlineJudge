package 정수삼각형_1932;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] map = new int[n][n+1];
		
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int len = s.length;
			for(int j = 1; j <= len; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		
		for(int i = 1; i < n; i++) {
			for(int j = 1; j <= i+1; j++) {
				map[i][j] = Math.max(map[i][j] + map[i-1][j-1], map[i-1][j] + map[i][j]);
			}
		}

		int ans = 0;
		for(int i = 1; i <= n; i++) {
			if(map[n-1][i] > ans) {
				ans = map[n-1][i];
			}
		}
		System.out.println(ans);
	}
}
