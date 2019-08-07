package 미세먼지안녕_17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] rct = br.readLine().split(" ");
		int r = Integer.parseInt(rct[0]);
		int c = Integer.parseInt(rct[1]);
		int t = Integer.parseInt(rct[2]);
		
		int[][] cur = new int[r+2][c+2];
		
		Arrays.fill(cur[r+1], -1);
		Arrays.fill(cur[0], -1);
		
		int cleaner = 0;
		for(int i = 1; i <= r; i++) {
			String[] s = br.readLine().split(" ");
			Arrays.fill(cur[i], -1);
			for(int j = 1; j <= c; j++) {
				cur[i][j] = Integer.parseInt(s[j-1]);
				if(cur[i][j] == -1) {
					cleaner = i;
				}
			}
		}
		
		for(int sec = 0; sec < t; sec++) {
			int[][] plus = new int[r+2][c+2];
			
			for(int i = 1; i <= r; i++) {
				for(int j = 1; j <= c; j++) {
					if(cur[i][j] > 0) {
						int cnt = 0;
						int add = cur[i][j] / 5;
						
						if(cur[i-1][j] > -1) {
							plus[i-1][j] += add;
							cnt++;
						}
						if(cur[i+1][j] > -1) {
							plus[i+1][j] += add;
							cnt++;
						}
						if(cur[i][j-1] > -1) {
							plus[i][j-1] += add;
							cnt++;
						}
						if(cur[i][j+1] > -1) {
							plus[i][j+1] += add;
							cnt++;
						}
						
						cur[i][j] -= (cnt * add);
					}
				}
			}
			
			for(int i = 1; i <= r; i++) {
				for(int j = 1; j <= c; j++) {
					if(cur[i][j] > -1) {
						cur[i][j] += plus[i][j];
					}
				}
			}
            
			for(int i = cleaner+1; i <= r-1; i++) {
				cur[i][1] = cur[i+1][1];
			}
			
			for(int i = 1; i <= c-1; i++) {
				cur[r][i] = cur[r][i+1];
			}
			
			for(int i = r; i >= cleaner+1; i--) {
				cur[i][c] = cur[i-1][c];
			}
			
			for(int i = c; i >= 2; i--) {
				cur[cleaner][i] = cur[cleaner][i-1];
			}
			
			cur[cleaner][2] = 0;
			
			for(int i = cleaner -2; i >=2; i--) {
				cur[i][1] = cur[i-1][1];
			}
			
			for(int i = 1; i <= c-1; i++) {
				cur[1][i] = cur[1][i+1];
			}
			
			for(int i = 1; i < cleaner - 1; i++) {
				cur[i][c] = cur[i+1][c];
			}
			
			for(int i = c; i >= 2; i--) {
				cur[cleaner-1][i] = cur[cleaner-1][i-1];
			}
			
			cur[cleaner-1][2] = 0;
		}

		int ans = 0;
		for(int i = 1; i <= r; i++) {
			for(int j = 1; j <= c; j++) {
				if(cur[i][j] > -1) {
					ans += cur[i][j];
				}
			}
		}
		System.out.println(ans);
	}
}

