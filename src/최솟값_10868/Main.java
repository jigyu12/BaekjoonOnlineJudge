package ÃÖ¼Ú°ª_10868;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private static int[] ar;
	private static int[] tree;
	
	private static int init(int start, int end, int node) {
		
		if(start == end) {
			return tree[node] = ar[start];
		}
		
		int mid = (start + end) / 2;
		
		return tree[node] = Math.min(init(start,mid,2 *node), init(mid+1,end,2 * node + 1));
	}
	
	private static int min(int start, int end, int left, int right, int node) {
		if(end < left || right < start) {
			return 1000000001;
		}
		
		else if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start + end) / 2;
		
		return Math.min(min(start,mid,left,right,2 * node), min(mid+1,end,left,right,2 * node + 1));
		
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			String[] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			
			ar = new int[n];
			tree = new int[4 * n];
			
			for(int i = 0; i < n; i++) {
				ar[i] = Integer.parseInt(br.readLine());
			}
			
			init(0,n-1,1);
			
			for(int i = 0; i < m; i++) {
				String[] s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				bw.write(min(0,n-1,a-1,b-1,1)+"\n");
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (IOException e) {
		}
	}

}
