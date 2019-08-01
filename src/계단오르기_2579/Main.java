package 계단오르기_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] stair = new int[n+2][3];
		
		for(int i = 2; i < n+2; i++) {
			stair[i][0] = Integer.parseInt(br.readLine()); 
		}
		
		for(int i = 2; i < n+2; i++) {
			stair[i][1] = Math.max(stair[i-2][1], stair[i-2][2]) + stair[i][0];
			stair[i][2] = stair[i-1][1] + stair[i][0];
		}
		
		int ans = stair[n+1][1] > stair[n+1][2] ? stair[n+1][1] : stair[n+1][2];
		System.out.println(ans);
	}
}
