package 이항계수2_11051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] ar = new int[n+1][n+1];
		ar[0][0] = 1;
		ar[1][0] = 1;
		ar[1][1] = 1;
		for(int i = 2; i <= n; i++) {
			for(int j = 0; j <= i; j++) {
				if(j == 0 || j == i) {
					ar[i][j] = 1;
				}
				else {
					ar[i][j] = (ar[i-1][j-1] + ar[i-1][j]) % 10007;
				}
			
			}
		}

		System.out.println(ar[n][k]);
	}
}
