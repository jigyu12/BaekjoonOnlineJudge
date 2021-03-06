package LCA2_11438;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
	private static ArrayList<Integer>[] list;
	private static int[] depth;
	private static final int pk = 17;
	private static int[][] parent;
	
	private static void dep(int par, int num, int deep) {
		if(depth[num] != -1) {
			return ;
		}
		depth[num] = deep;
		parent[0][num] = par;
		for(int a : list[num]) {
			dep(num,a,deep+1);
		}
	}
	
	public static void main (String [] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		list = new ArrayList[num+1];
		depth = new int[num+1];
		parent = new int[pk+1][num+1];
 		for(int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Integer>();
			depth[i] = -1;
			parent[0][i] = -1;
		}
		for(int i = 0; i < num-1; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			list[a].add(b);
			list[b].add(a);
		}
		
		dep(0,1,0);
		parent[0][1] = 1;
		for(int i = 1; i <= pk; i++) {
			for(int j = 1; j <= num; j++) {
				parent[i][j] = parent[i-1][parent[i-1][j]];
			}
		}
		
		int test = Integer.parseInt(br.readLine());
		for(int i = 0; i < test; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			
			if(depth[a] > depth[b]) {
				for(int j = pk; j >= 0; j--) {
					if(a != b && depth[parent[j][a]] >= depth[b]) {
						a = parent[j][a];
					}
				}
			}
			else {
				for(int j = pk; j >= 0; j--) {
					if(a != b && depth[parent[j][b]] >= depth[a]) {
						b = parent[j][b];
					}
				}
			}
			
			for(int j = pk; j >= 0; j--) {
				if(a != b && parent[j][b] != parent[j][a]) {
					b = parent[j][b];
					a = parent[j][a];
				}
			}
			
			int ans = 0;
			if(a == b) {
				ans = a;
			}
			else {
				ans = parent[0][a];
			}
			bw.write(ans+"\n");
		}
		bw.flush();
	}
}