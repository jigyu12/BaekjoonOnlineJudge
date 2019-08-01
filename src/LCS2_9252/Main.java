package LCS2_9252;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String sa = br.readLine();
		String sb = br.readLine();
		
		int[] a = new int[sa.length()+1];
		int[] b = new int[sb.length()+1];
		int la = a.length -1;
		int lb = b.length -1;
		
		int[][] dp = new int[la+1][lb+1];
		
		for(int i = 0; i < la; i++) {
			a[i+1] = sa.charAt(i);
		}
		for(int i = 0; i < lb; i++) {
			b[i+1] = sb.charAt(i);
		}
		for(int i = 1; i <= la; i++) {
			for(int j = 1; j <= lb; j++) {
				if(a[i] == b[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				}
				else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		bw.write(dp[la][lb]+"\n");
		StringBuilder sbb = new StringBuilder();
		int x = la, y = lb;
		while(dp[x][y] > 0) {
			if(dp[x-1][y] == dp[x][y]) {
				x--;
			}
			else if(dp[x][y-1] == dp[x][y]) {
				y--;
			}
			else {
				sbb.append((char)(b[y]));
				x--;
				y--;
			}
		}
		sbb = sbb.reverse();
		bw.write(sbb.toString()+"\n");
		bw.flush();
	}
}
