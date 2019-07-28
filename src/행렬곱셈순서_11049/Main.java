package 행렬곱셈순서_11049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			int[] dist = new int[n+1];
			for(int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				dist[i] = Integer.parseInt(s[0]);
				dist[i+1] = Integer.parseInt(s[1]);
			}
			int[][] map = new int[n+1][n+1];
			for(int d = 0; d < n+1; d++) {
				for(int i = 1; i < n+1 - d; i++) {
					int j = i + d;
					if(i == j) {
						continue;
					}
					map[i][j] = Integer.MAX_VALUE;
					for(int k = i; k < j; k++) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k+1][j]
								+(dist[i-1] * dist[k] * dist[j]));		
					}
				}
			}
			System.out.println(map[1][n]);
			
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
