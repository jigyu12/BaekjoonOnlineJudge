package 플로이드_11404;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] ar = new int[n+1][n+1];
		
		for(int i = 1 ; i <= n; i++) {
			Arrays.fill(ar[i], 987654321);
			ar[i][i] = 0;
		}

		for (int i = 0; i < m; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			
			if(ar[a][b] > c) {
				ar[a][b] = c;
			}
		}
		
		for(int k = 1; k <= n; k++) {
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					ar[i][j] = Math.min(ar[i][j], ar[i][k] + ar[k][j]);
				}
			}
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= n; j++) {
				if(ar[i][j] != 987654321) {
					bw.write(ar[i][j] + " ");
				}
				else {
					bw.write("0 ");
				}
			}
			bw.write("\n");
		}
		bw.write("\n");
		bw.flush();
	}
}
