package RGB°Å¸®_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int[][] d = new int[num][3];
		int[][] sum = new int[num][3];
		int ans = 2000000000;
		for(int i = 0; i < num; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < 3; j++) {
				d[i][j] = Integer.parseInt(s[j]);
			}
			if(i > 0) {
				sum[i][0] = Math.min(d[i][0]+ sum[i-1][1], d[i][0]+ sum[i-1][2]);
				sum[i][1] = Math.min(d[i][1]+ sum[i-1][0], d[i][1]+ sum[i-1][2]);
				sum[i][2] = Math.min(d[i][2]+ sum[i-1][0], d[i][2]+ sum[i-1][1]);
			}
			else {
				for(int j = 0; j < 3; j++) {
					sum[i][j] = d[i][j];
				}
			}
		}
		for(int j = 0; j < 3; j++) {
			if(ans > sum[num-1][j]) {
				ans = sum[num-1][j];
			}
		}
		System.out.println(ans);
		

	}

}
