package 나무자르기_2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	private static int ans;
	private static int n;
	private static int m;
	private static ArrayList<Integer> ar;
	
	private static void binary_search(int s, int e) {
		int start = s;
		int end = e;
		int mid = 0;
		
		while(start <= end) {
			boolean up = false;
			mid = (start + end) / 2;
			int sum = 0;
			
			for(int i = 0; i < n; i++) {
				int cur = ar.get(i);
				int sub = cur - mid;
				if(sub >= 0) {
					sum += (sub);
				}
				if(sum >= m) {
					up = true;
					if(ans < mid) {
						ans = mid;
					}
					break;
				}
			}
			if(up) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] nm = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			m = Integer.parseInt(nm[1]);
			ar = new ArrayList<Integer>();
			ans = 0;
			String[] s = br.readLine().split(" ");
			for(int i = 0; i < n; i++) {
				ar.add(Integer.parseInt(s[i]));
			}
			Collections.sort(ar, Collections.reverseOrder());
			binary_search(0,1000000000);
			System.out.println(ans);
		} catch (IOException e) {}
	}
}
