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
			for(int i = 0; i < n; i++) {
				coin[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(coin);
			int ans = 2000000000;
			for(int i = coin.length-1; i >= 0; i--) {
				if(k == 0) {
					break;
				}
				int cal = k;
				int count = 0;
				for(int j = i; j >= 0; j--) {
					if(cal >= coin[j]) {
						if(cal % coin[j] == 0) {
							count += (cal / coin[j]);
							if(ans > count) {
								ans = count;
							}
							break;
						}
						else {
							int add = cal / coin[j];
							cal -= (coin[j] * add);
							count += add;
						}
					}
				}
			}
			if(ans < 2000000000) {
				System.out.println(ans);
			}
			else {
				System.out.println("-1");
			}
			
		} catch (IOException e) {
		}
	}
}
