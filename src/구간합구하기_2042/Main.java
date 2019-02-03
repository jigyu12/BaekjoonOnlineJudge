package 구간합구하기_2042;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private static long[] ar;
	private static long[] tree;
	
	private static long init(int start, int end, int node) {
		if(start == end) {
			return tree[node] = ar[start];
		}
		
		int mid = (start + end) / 2;
		
		return tree[node] = init(start,mid, 2 * node) + init(mid+1,end,2 * node + 1);
	}
	
	private static long sum(int start, int end, int left, int right, int node) {
		
		if(end < left || right < start) {
			return 0;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		
		return sum(start,mid,left,right,2 * node) + sum(mid+1,end,left,right,2 * node + 1);
	}
	
	private static void update(int start, int end, int index, int node, long diff) {
		if(index < start || end < index) {
			return ;
		}
		
		tree[node] += diff;
		
		if(start == end) {
			return ;
		}
		
		int mid = (start + end) / 2;
		
		update(start,mid,index,2 * node, diff);
		update(mid+1,end,index,2 * node + 1, diff);
	}
	

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			String[] nmk = br.readLine().split(" ");
			int n = Integer.parseInt(nmk[0]);
			int m = Integer.parseInt(nmk[1]); 
			int k = Integer.parseInt(nmk[2]);
			int f = m + k;
			ar = new long[n];
			tree = new long[4*n];
			for(int i = 0; i < n ; i++) {
				ar[i] = Long.parseLong(br.readLine());
			}
			
			init(0,n-1,1);
			
			for(int i = 0; i < f; i++) {
				String[] s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				if(a == 1) {
					long c = Long.parseLong(s[2]);
					long diff = c - ar[b-1];
					
					update(0,n-1,b-1,1,diff);
					ar[b-1] = c;
				}
				else if(a == 2) {
					int c = Integer.parseInt(s[2]);
					long ans = sum(0,n-1,b-1,c-1,1);
					bw.write(ans+"\n");
				}
			}
			bw.flush();
			bw.close();
			br.close();
			
		} catch (IOException e) { 
		}
	}
}
