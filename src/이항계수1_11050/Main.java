package 이항계수1_11050;

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
		int up = 1;
		int down = 1;
		for(int i = 2; i <= n; i++) {
			if(k >= i) {
				down *= i;
			}
			if(n-k >= i) {
				down *= i;
			}
			up *= i;
		}
		System.out.println(up/down);
	}
}
