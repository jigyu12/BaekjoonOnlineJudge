package 가장큰정사각형_1915;

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
			int[][] map = new int[n+1][m+1];
			int[][] square = new int[n+1][m+1];
			for(int i = 1; i <= n; i++) {
				String[] s = br.readLine().split("");
				for(int j = 1; j <= m; j++) {
					map[i][j] = Integer.parseInt(s[j-1]);
				}
			}
			int max = 0;
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= m; j++) {
					if(map[i][j] == 1) {
						square[i][j] = Math.min(square[i-1][j], Math.min(square[i][j-1], square[i-1][j-1])) + 1;
						if(square[i][j] > max) {
							max = square[i][j];
						}
					}
					else {
						square[i][j] = 0;
					}
				}
			}
			System.out.println(max * max);

		} catch (IOException e) {
		}
	}
}
