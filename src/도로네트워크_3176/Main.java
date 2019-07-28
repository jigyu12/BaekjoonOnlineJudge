package 도로네트워크_3176;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

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
	
	private static ArrayList<Node>[] list;
	private static final int pk = 17;
	private static int[] depth;
	private static int[][] parent;
	private static int[][] max;
	private static int[][] min;
	
	private static void dfs(int par, Node sib, int deep) {
		if(depth[sib.end] != -1) {
			return ;
		}
		depth[sib.end] = deep;
		parent[0][sib.end] = par;
		max[0][sib.end] = sib.dist;
		min[0][sib.end] = sib.dist;
		for(Node n : list[sib.end]) {
			dfs(sib.end,n,deep+1);
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int num = Integer.parseInt(br.readLine());
		list = new ArrayList[num+1];
		parent = new int[pk+1][num+1];
		max = new int[pk+1][num+1];
		min = new int[pk+1][num+1];
		depth = new int[num+1];
		for(int i = 0; i < num+1; i++) {
			list[i] = new ArrayList<Node>();
			parent[0][i] = -1;
			depth[i] = -1;
		}
		for(int i = 0; i <= pk; i++) {
			Arrays.fill(min[i], 10000001);
			Arrays.fill(max[i], -1);
		}
		for(int i = 0; i < num-1; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			list[a].add(new Node(b,c));
			list[b].add(new Node(a,c));
		}
		Node n = new Node(1,-1);
		dfs(0,n,0);
		parent[0][1] = 1;
		max[0][1] = 0;
		min[0][1] = 0;
		
		for(int i = 1; i <= pk; i++) {
			for(int j = 1; j <= num; j++) {
				parent[i][j] = parent[i-1][parent[i-1][j]];
				min[i][j] = Math.min(min[i-1][j], min[i-1][parent[i-1][j]]);
				max[i][j] = Math.max(max[i-1][j], max[i-1][parent[i-1][j]]);
			}
		}
		
		for(int i = 0; i <= pk; i++) {
			for(int j = 1; j <= num; j++) {
				System.out.print(min[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		for(int i = 0; i <= pk; i++) {
			for(int j = 1; j <= num; j++) {
				System.out.print(max[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		int test = Integer.parseInt(br.readLine());
		for(int i = 0; i < test; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			int left = a;
			int right = b;
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
				if(a != b && parent[j][a] != parent[j][b]) {
					b = parent[j][b];
					a = parent[j][a];
				}
			}
			
			int lca = 1;
			
			if(a == b) {
				lca = a;
			}
			else {
				lca = parent[0][a];
			}

			
			int min = 10000001;
			int max = 0;

			
			
			
			bw.write(min + " " + max+"\n");
		}
		bw.flush();
	}
}
