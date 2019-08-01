package 다리놓기_1010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		for(int t = 0 ; t < num; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			long[][] ar = new long[m+1][m+1];
			ar[0][0] = 1;
			ar[1][0] = 1;
			ar[1][1] = 1;
			for(int i = 2; i <= m; i++) {
				for(int j = 0; j <= i; j++) {
					if(j == 0 || j == i) {
						ar[i][j] = 1;
					}
					else {
						ar[i][j] = (ar[i-1][j-1] + ar[i-1][j]);
					}
				}
			}
			bw.write(ar[m][n]+"\n");
		}
		bw.flush();
	}
}
