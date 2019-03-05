package 계란으로계란치기_16987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int ans;
	
	private static void breakegg(int s, int[] durab, int[] weight, int count) {
		int start = s;
		int[] d = new int[durab.length];
		int[] w = new int[durab.length];
		
		for(int i = 0; i < d.length; i++) {
			d[i] = durab[i];
			w[i] = weight[i];
		}
		
		if( start >= d.length || count > d.length) {
			int cal = 0;
			for(int j = 0; j < d.length; j++) {
				if(d[j] <= 0) {
					cal++;
				}
			}
			if(cal > ans) {
				ans = cal;
			}
			return ; 
		}
		
		if(d[start] <= 0) {
			breakegg(start+1,d,w,count+1);
			return;
		}
		
		boolean find = false;
		for(int i = 0; i < d.length; i++) {
			if(i == start) {
				continue;
			}
			
			if(d[i] <= 0) {
				continue;
			}
			
			find = true;
			d[start] -= w[i];
			d[i] -= w[start];
			breakegg(start+1,d,w,count+1);
			d[start] += w[i];
			d[i] += w[start];
		}
		if(!find) {
			int cal = 0;
			for(int j = 0; j < d.length; j++) {
				if(d[j] <= 0) {
					cal++;
				}
			}
			if(cal > ans) {
				ans = cal;
			}
			return ; 
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int durab[] = new int[num];
		int weight[] = new int[num];
		
		for(int i = 0; i < num; i++) {
			String[] s = br.readLine().split(" ");
			durab[i] = Integer.parseInt(s[0]);
			weight[i] = Integer.parseInt(s[1]);
		}

		breakegg(0,durab,weight,0);
		
		System.out.println(ans);
	}
}