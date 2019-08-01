package 사전_1256;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int len = n+m;
		int[][] ar = new int[len+2][len+2];
		ar[0][0] = 1;
		ar[1][0] = 1;
		ar[1][1] = 1;
		for(int i = 2; i <= len; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					ar[i][j] = 1;
				}
				else {
					if(ar[i-1][j-1] + ar[i-1][j]  > 1000000000) {
						ar[i][j] = 1000000001;
					}
					else {
						ar[i][j] = (ar[i-1][j-1] + ar[i-1][j]);
					}
	
				}
			
			}
		}

		StringBuilder sb = new StringBuilder();
		if(ar[len][m] < k) {
			System.out.println("-1");
		}
		else {
			int count = 0;
			while(count < len) {
				count++;
				if(ar[n+m-1][m] >= k) {
					n--;
					sb.append("a");
				}
				else {
					
					sb.append("z");
					k -= ar[n+m-1][m];
					m--;
				}
			}
			System.out.println(sb.toString());
		}
	}
}

