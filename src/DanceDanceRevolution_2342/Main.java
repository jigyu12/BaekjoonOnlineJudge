package DanceDanceRevolution_2342;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] s = br.readLine().split(" ");
			int[] note = new int[s.length];
			for(int i = 0; i < note.length -1; i++) {
				note[i+1] = Integer.parseInt(s[i]);
			}
			int[][] cost = {{0,2,2,2,2},{2,1,3,4,3},{2,3,1,3,4},{2,4,3,1,3},{2,3,4,3,1}};
			int[][][] d = new int[100001][5][5];
			for(int k = 0; k < 100001; k++) {
				for(int i = 0; i < 5; i++) {
					for(int j = 0; j < 5; j++) {
						d[k][i][j] = 1000000000;
					}
				}
			}
			
			d[0][0][0] = 0;
			for(int i = 1; i < note.length; i++) {
				for(int j = 0; j < 5; j++) {
					for(int k = 0; k < 5; k++) {
						if(d[i][note[i]][k] > d[i-1][j][k] + cost[j][note[i]]) {
							d[i][note[i]][k] = d[i-1][j][k] + cost[j][note[i]];
						}
					}
				}
				
				for(int j = 0; j < 5; j++) {
					for(int k = 0; k < 5; k++) {
						if(d[i][k][note[i]] > d[i-1][k][j] + cost[j][note[i]]) {
							d[i][k][note[i]] = d[i-1][k][j] + cost[j][note[i]];
						}
					}
				}	
			}
			int ans = 1000000000;
			for(int j = 0; j < 5; j++) {
				for(int k = 0; k < 5; k++) {
					if(d[s.length-1][j][k] < ans) {
						ans = d[s.length-1][j][k];
					}
				}
			}
			System.out.println(ans);
		} catch (IOException e) {
		}
	}
}
