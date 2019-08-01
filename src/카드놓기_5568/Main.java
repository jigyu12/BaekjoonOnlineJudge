package 카드놓기_5568;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	
	private static int[] floor;
	private static int n;
	private static int k;
	private static HashSet<Integer> hs;
	
	private static void permutation(int visit, int cnt, int[] ans) {
		if(cnt == k) {
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < k; i++) {
				sb.append(String.valueOf(ans[i]));
			}
			hs.add(Integer.parseInt(sb.toString()));
			return ;
		}
		
		for(int i = 0; i < n; i++) {
			if((visit & (1 << i)) == 0) {
				int vv = visit | (1 << i);
				ans[cnt] = floor[i];
				permutation(vv,cnt+1,ans);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		floor = new int[n];
			k = Integer.parseInt(br.readLine());
			hs = new HashSet<Integer>();
		for(int i = 0; i < n; i++) {
			floor[i] = Integer.parseInt(br.readLine());
		}
		int[] ans = new int[k];
		permutation(0,0,ans);
		System.out.println(hs.size());
	}
}
