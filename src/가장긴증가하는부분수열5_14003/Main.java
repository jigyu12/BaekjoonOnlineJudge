package 가장긴증가하는부분수열5_14003;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
	static int n;
	static int[] parent;
	static int[] ar;
	static ArrayList<Integer> lis;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {

		n = Integer.parseInt(br.readLine());
		parent = new int[n];
		ar = new int[n];
		lis = new ArrayList<>();
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(s[i]);
		}
		lis.add(ar[0]);
		parent[0] = 1;
		for(int i = 1; i < n; i++) {
			int size = lis.size() - 1;
			int top = lis.get(size);
			if(top < ar[i]) {
				lis.add(ar[i]);
				parent[i] = lis.size();
			}
			else {
				int idx = binarySearch(ar[i]);
				lis.add(idx,ar[i]);
				parent[i] = idx + 1;
				lis.remove(idx+1);
			}
		}
		
		int p = lis.size();
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = parent.length- 1 ; i >= 0 ; i--) {
			if(parent[i] == p && p > 0) {
				ans.add(ar[i]);
				p--;
			}
		}
		bw.write(ans.size()+"\n");
		for(int i = ans.size() - 1 ; i >= 0  ; i--) {
			bw.write(ans.get(i)+" ");
		}
		bw.flush();
	}
	
	static int binarySearch(int v) {
		int s = 0, e = lis.size()-1;
		int mid = 0;
		while(s <= e) {
			mid = (s+e) / 2;
			if(lis.get(mid) >= v) {
				e = mid - 1;
			}
			else {
				s = mid + 1;
			}
		}
		return s;
	}
}

