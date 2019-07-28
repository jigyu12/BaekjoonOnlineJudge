package 가장긴증가하는부분수열_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	private static ArrayList<Integer> ans;
	
	private static int binary(int n) {
		
		int start = 0;
		int end = ans.size()-1;
		int mid = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			if(ans.get(mid) < n) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
		
		return start;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int num = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			ans = new ArrayList<Integer>();
			ans.add(Integer.parseInt(s[0]));
			for(int i = 1; i < num; i++) {
				int n = Integer.parseInt(s[i]);
				if(ans.get(ans.size()-1) < n) {
					ans.add(n);
				}
				else {
					int k = binary(n);
					ans.add(k, n);
					ans.remove(k+1);
				}
			}
			System.out.println(ans.size());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
