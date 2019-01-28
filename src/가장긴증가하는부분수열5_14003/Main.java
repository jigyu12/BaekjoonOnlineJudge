package 가장긴증가하는부분수열5_14003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	private static int[] ar;
	private static ArrayList<Integer> ans;
	
	private static int binary(int n) {
		int start = 0;
		int end = ans.size()-1;
		int mid = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
//			System.out.println(mid);
			if(ans.get(mid) > n) {
				end = mid - 1;
			}
			else {
				start = mid + 1;
			}
		}
		
		return start;
		
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int num = Integer.parseInt(br.readLine());
			ar = new int[num];
			ans = new ArrayList<Integer>();
			String[] s = br.readLine().split(" ");
			ans.add(Integer.parseInt(s[0]));
			for(int i = 1; i < num; i++) {
				int n = Integer.parseInt(s[i]);
				
				if(n > ans.get(ans.size()-1)) {
					ans.add(n);
				}
				else {
					int a = binary(n);
					ans.add(a,n);
					ans.remove(a+1);
				}
//				for(int k = 0; k < ans.size(); k++) {
//					System.out.print(ans.get(k) + " ");
//				}
//				System.out.println();
			}
			System.out.println(ans.size());
			for(int i = 0; i < ans.size(); i++) {
				System.out.print(ans.get(i) + " ");
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
