package µ¿Àü2_2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int k = Integer.parseInt(s[1]);
			int[] coin = new int[n];
			int[] cnt = new int[k+1];
			for(int i = 1; i < k+1; i++) {
				cnt[i] = 2000000000;
			}
			for(int i = 0; i < n; i++) {
				coin[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(coin);
			for(int i = 0; i < n; i++) {
				for(int j = coin[i]; j < k+1; j++) {
					if(cnt[j] > cnt[j-coin[i]] + 1) {
						cnt[j] = cnt[j-coin[i]] + 1;
					}
				}
				
			}
			if(cnt[k] == 2000000000) {
				System.out.println("-1");
			}
			else {
				System.out.println(cnt[k]);
			}
		} catch (IOException e) {
		}
	}
}
