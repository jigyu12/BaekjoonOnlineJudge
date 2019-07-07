package 점프점프_11060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] map = new int[n];
		int[] count = new int[n];
		
		String[] s = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			map[i] = Integer.parseInt(s[i]);
			count[i] = Integer.MAX_VALUE;
		}
		
		count[0] = 0;
		
		for(int i = 0; i < n; i++) {
			if(count[i] < Integer.MAX_VALUE) {
				for(int j = 1; j <= map[i]; j++) {
					if(i+j < n && count[i+j] > count[i] + 1) {
						count[i+j] = count[i] + 1;
					}
				}
			}
		}
		
		if(count[n-1] == Integer.MAX_VALUE) {
			System.out.println("-1");
		}
		else {
			System.out.println(count[n-1]);
		}
	}
}
