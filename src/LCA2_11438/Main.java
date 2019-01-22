package LCA2_11438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	 
	private static ArrayList<Integer>[] ar;
	private static int[] depth;
	private static int[][] parent;
	private static final int pk = 17;
	
	private static void dfs(int a, int dep) {
		
		depth[a] = dep;
		
		for(int i = 0; i < ar[a].size(); i++) {
			parent[0][ar[a].get(i)] = a;
			dfs(ar[a].get(i),dep + 1);
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			ar = new ArrayList[n+1];
			depth = new int[n+1];
			parent = new int[pk][n+1];
			for(int i = 0; i < n+1; i++) {
				ar[i] = new ArrayList<Integer>();
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
			
			dfs(1,0);
			parent[0][1] = 1;
			
			for(int k =1; k < pk; k++ ) {
				for(int i = 1; i < n+1; i++) {
					parent[k][i] = parent[k-1][parent[k-1][i]];
				}
			}
			
			for(int k = 0; k < pk; k++ ) {
				for(int i = 0; i < n+1; i++) {
					System.out.print(parent[k][i] + " ");
				}
				System.out.println();
			}
			System.out.println();
			
			for(int i = 0; i < n+1; i++) {
				System.out.print(depth[i] + " ");
			}
			System.out.println();
			
			int m = Integer.parseInt(br.readLine());
			for(int i = 0; i < m; i++) {
				String[] ab = br.readLine().split(" ");
				int a = Integer.parseInt(ab[0]);
				int b = Integer.parseInt(ab[1]);
				
				if(depth[a] > depth[b]) {
					int k = depth[a]-depth[b];
					int paa = depth[a];
					while(k > 0) {
						paa = parent[paa-1][parent[paa-1][a]];
						k--;
					}
					int parA = paa;
					int parB = parent[depth[b]-1][parent[depth[b]-1][b]];
					if(parA == parB) {
						System.out.println(parB);
						continue;
					}
					else {
						while(parA != parB) {
							parA = parent[parA-1][parent[parA-1][a]];
							parB = parent[parB-1][parent[parB-1][b]];
						}
						System.out.println(parB);
					}
				}
				
				else if(depth[a] < depth[b]) {
					int k = depth[b]-depth[a];
					int pab = depth[b];
					
					pab = parent[k-1][b];

					int parA = parent[depth[a]-1][parent[depth[a]-1][a]];
					int parB = pab;
					if(parA == parB) {
						System.out.println(parB);
						continue;
					}
					else {
						while(parA != parB) {
							parA = parent[parA-1][parent[parA-1][a]];
							parB = parent[parB-1][parent[parB-1][a]];
						}
						System.out.println(parB);
					}
				}
			}
			
		
			
		} catch (NumberFormatException | IOException e) {
		}
		
	}

}
