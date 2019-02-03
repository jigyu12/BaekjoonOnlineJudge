package 정점들의거리_1761;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
	static class Node{
		int end;
		int dist;
		
		public Node(int end, int dist) {
			this.end = end;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Node [end=" + end + ", dist=" + dist + "]";
		}
		
	}

	private static int[][] parent;
	private static int[] depth;
	private static int[] dist;
	private static ArrayList<Node>[] ar;
	private static final int pk = 16;

	private static void dfs(int a) {
		for (Node node : ar[a]) {
			if (depth[node.end] == -1) {
				depth[node.end] = depth[a] + 1;
				parent[0][node.end] = a;
				dist[node.end] = dist[a] + node.dist;
				dfs(node.end);
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int n = Integer.parseInt(br.readLine());

			parent = new int[pk + 1][n + 1];
			depth = new int[n + 1];
			ar = new ArrayList[n + 1];
			dist = new int[n+1];
			for (int i = 0; i < n + 1; i++) {
				ar[i] = new ArrayList<Node>();
				depth[i] = -1;
			}

			for (int i = 0; i < n - 1; i++) {
				String[] s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				int c = Integer.parseInt(s[2]);
				
				ar[a].add(new Node(b,c));
				ar[b].add(new Node(a,c));
			}

			depth[1] = 0;
			parent[0][1] = 1;
			dfs(1);
			
			for(int k = 1; k <= pk; k++) {
				for(int j = 1; j <= n; j++) {
					parent[k][j] = parent[k-1][parent[k-1][j]];
				}
			}

			int m = Integer.parseInt(br.readLine());
			for (int i = 0; i < m; i++) {
				String[] s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int a1 = a;
				int b = Integer.parseInt(s[1]);
				int b1 = b;
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
				
				int par = 0;
				
				for(int j = pk; j >= 0; j--) {
					if(a != b && parent[j][a] != parent[j][b]) {
						a = parent[j][a];
						b = parent[j][b];
					}
				}
				
				if(a == b) {
					par = a;
				}
				else {
					par = parent[0][a];
				}
				int dis = 0;
				dis += dist[a1] - dist[par];
				dis += dist[b1] - dist[par];
				bw.write(dis+"\n");
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (NumberFormatException | IOException e) {
		}
	}
}
