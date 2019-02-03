package LCA2_11438;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	 
	private static ArrayList<Integer>[] ar;
	private static int[] depth;
	private static int[][] parent;
	private static final int pk = 17;
	
	   public static void dfs(int node)
	    {
	        for(int nnode : ar[node])
	        {
	            if(depth[nnode]==-1)
	            {
	                parent[0][nnode] = node;
	                depth[nnode]=depth[node]+1;
	                dfs(nnode);
	            }
	        }
	    }

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int n = Integer.parseInt(br.readLine());
			ar = new ArrayList[n+1];
			depth = new int[n+1];
			parent = new int[pk+1][n+1];
			for(int i = 0; i < n+1; i++) {
				ar[i] = new ArrayList<Integer>();
				depth[i] = -1;
			}
			for(int i = 0; i < n-1; i++) {
				String[] s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				if(a < b) {
					ar[a].add(b);
				}
				else{
					ar[b].add(a);
				}
				
			}
			
			depth[1] = 0;
			parent[0][1] = 1;
			dfs(1);
				
			for(int k = 1; k <= pk; k++ ) {
				for(int i = 1; i < n+1; i++) {
					parent[k][i] = parent[k-1][parent[k-1][i]];
				}
			}

			int m = Integer.parseInt(br.readLine());
			for(int i = 0; i < m; i++) {
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
				
				else if(depth[a] < depth[b]) {
					for(int j = pk; j >= 0; j--) {
						if(a != b && depth[parent[j][b]] >= depth[a]) {
							b = parent[j][b];
						}
					}
				}
				
				int ans = 0;
				
				for(int j = pk; j >= 0; j--) {
					if(a != b && parent[j][a] != parent[j][b]) {
						a = parent[j][a];
						b = parent[j][b];
					}
				}
				
				if(a == b) {
					ans = a;
				}
				else {
					ans = parent[0][a];
				}
				bw.write(ans+"\n");
			}
			bw.flush();
		} catch (NumberFormatException | IOException e) {
		}	
	}
}
