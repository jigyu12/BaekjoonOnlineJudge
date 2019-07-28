package 삼각형만들기_1448;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	private static int[] ar;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		ar = new int[num];
		for(int i = 0; i < num; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(ar);

		int ans = -1;
		for(int i = ar.length -1; i >= 2; i--) {
			if(ar[i] < ar[i-1] + ar[i-2]) {
				ans = ar[i] + ar[i-1] + ar[i-2];
				break;
			}
		}
	
		System.out.println(ans);
	}
}
