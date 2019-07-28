package 구간합구하기4_11659;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int[] ar;
	private static int[] tree;
	
	public static int init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = ar[start];
		}
		
		int mid = (start + end) / 2;
		
		return tree[node] = init(start, mid,node * 2) + init(mid + 1, end,node * 2 + 1);
	}
	
	public static int sum(int start, int end, int node, int left, int right) {
		if(left > end || right < start ) {
			return 0;
		}
		
		if(left <= start && right >= end) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		
		return sum(start,mid,node * 2 ,left,right) + sum(mid+1,end,node * 2 + 1,left,right);
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]); 
			ar = new int[n];
			tree = new int[4 * n];
			String[] s = br.readLine().split(" ");
			for(int i = 0; i < n; i++) {
				ar[i] = Integer.parseInt(s[i]);
			}
			init(0,ar.length - 1, 1);
			for(int i = 0; i < m; i++) {
				String[] t = br.readLine().split(" ");
				int a = Integer.parseInt(t[0]) - 1;
				int b = Integer.parseInt(t[1]) - 1;
				System.out.println(sum(0,ar.length-1,1,a,b));
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
