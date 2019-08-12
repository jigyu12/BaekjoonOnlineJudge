package 컨닝_1014;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
	static int n;
	static int m;
	static int[][] map;
	static int[][] dp;
	static int ans;
	static ArrayList<Integer> ar[];
	static int line;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 0; t < test; t++) {
			String[] nm = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			
			map = new int[n][m];
			dp = new int[n][1 << m];
			ans = 0;
			ar = new ArrayList[n];
			
			for(int i = 0; i < n; i++) {
				String[] s = br.readLine().split("");
				ar[i] = new ArrayList<>();
				for(int j = 0; j < m; j++) {
					if(s[j].equals("x")) {
						map[i][m-j-1] = 1;
					}
				}
			}
			
			for(int i = 0; i < n; i++) {
				line= i;
				ar[i].add(0);
				for(int j = 0; j < m; j++) {
					if(map[i][j] == 0) {
						int num = (1 << j);
						dp[i][num] = 1;
						ar[line].add(num);
						find(j+1, num,1);
					}
				}
			}
			
			for(int i = 1; i < n; i++) {
				int fsize = ar[i-1].size();
				for(int j = 0; j < fsize; j++) {
					int up = ar[i-1].get(j);
					int bsize = ar[i].size();
					for(int k = 0 ; k < bsize; k++) {
						int down = ar[i].get(k);
						if(dp[i-1][up] > 0) {
							int mat = matching(up,down,i);
							if(dp[i-1][up] + mat > dp[i][down]) {
								 dp[i][down] = dp[i-1][up] + mat;
							}
						}
					}
				}
			}
//			for(int i = 0 ; i < n; i++) {
//				for(int j = 0; j < (1<<m); j++) {
//					System.out.print(dp[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			for(int i = 0 ; i < (1 << m); i++) {
				if(dp[n-1][i] > ans) {
					ans = dp[n-1][i];
				}
			}
//			Collections.sort(ar[0]);
//			for(int i = 0; i < ar[0].size(); i++) {
//				System.out.print(dp[0][ar[0].get(i)] + " ");
//			}
//			for(int i = 0; i < n; i++) {
//				Collections.sort(ar[i]);
//				for(int j = 0; j < ar[i].size(); j++) {
//					System.out.print(ar[i].get(j) + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			
			bw.write(ans+"\n");
		}
		bw.flush();
	}

	static int matching(int up, int down, int idx) {
		int cnt = 0;
		for(int i = 0; i < m; i++) {
			if((down & (1 << i)) != 0 && map[idx][i] == 0) {
				if(i == 0) {
					if((up & (1 << i+1)) == 0) {
						cnt++;
					}
				}
				else if(i == m-1) {
					if((up & (1 << i-1)) == 0) {
						cnt++;
					}
				}
				else {
					if((up & (1 << i+1)) == 0 && (up & (1 << i-1)) == 0) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	static void find(int start, int state, int cnt) {
		
		if(start > m) {
			return ;
		}
		
		for(int i = start; i < m; i++) {
			if(map[line][i] == 0) {
				if(((state & (1 << i)) == 0) && ((state & (1 << (i - 1))) == 0)) {
					int num = state | (1 << i);
					dp[line][num] = cnt+1;
					ar[line].add(num);
					find(i+1 , state | (1 << i), cnt + 1);
				}
			}
		}
	}
	
	
}
