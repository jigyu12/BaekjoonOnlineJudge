package 단절점_11266;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	private static void init(int x) {
		parent[x] = x;
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	private static void union(int x, int y) {
		parent[find(x)] = find(y);
	}

	private static int dfs(int par, boolean[] visited, int[] order) {
		int comp = 100001;
		int ret = 0;
		order[par] = or++;
		visited[par] = true;

		int k = order[par];
		for (int i = 0; i < ar[par].size(); i++) {
			if (!visited[ar[par].get(i)]) {
				if (order[par] == 1) {
					root++;
				}
				ret = dfs(ar[par].get(i), visited, order);
				if (ret >= order[par] && order[par] > 1) {
					ans.add(par);
				}
				if (k > ret) {
					k = ret;
				}
			}
		}

		for (int i = 0; i < ar[par].size(); i++) {
			if (comp > order[ar[par].get(i)] && order[ar[par].get(i)] != -1) {
				comp = order[ar[par].get(i)];
			}
		}
		
		k = k < comp ? k : comp;

		if (root > 1 && order[par] == 1) {
			ans.add(par);
		}
		return k;
	}

	private static ArrayList<Integer>[] ar;
	private static int[] parent;
	private static ArrayList<Integer> ans;
	private static int or;
	private static int root;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] ve = br.readLine().split(" ");
			int v = Integer.parseInt(ve[0]);
			int e = Integer.parseInt(ve[1]);
			ar = new ArrayList[v + 1];
			ans = new ArrayList<Integer>();
			parent = new int[v + 1];
			
			
			for (int i = 0; i < v + 1; i++) {
				ar[i] = new ArrayList<Integer>();
				init(i);
			}
			parent[0] = -1;
			for (int i = 0; i < e; i++) {
				String[] ab = br.readLine().split(" ");
				int a = Integer.parseInt(ab[0]);
				int b = Integer.parseInt(ab[1]);
				ar[a].add(b);
				ar[b].add(a);
				if (a < b) {
					union(b, a);
				} else if (a > b) {
					union(a, b);
				}
			}
			for (int i = 1; i < v + 1; i++) {
				find(i);
			}
			int[] count = new int[v + 1];
			for (int i = 1; i < v + 1; i++) {
				count[parent[i]]++;
			}

			for (int i = 1; i < v + 1; i++) {
				
				if (count[i] != 0) {
					root = 0;
					or = 1;
					int[] order = new int[v + 1];
					Arrays.fill(order, -1);
					dfs(i, new boolean[v + 1], order);
				}
			}
			int aa = 0;
			Collections.sort(ans);
			boolean[] ct = new boolean[v + 1];
			for (int i = 0; i < ans.size(); i++) {
				ct[ans.get(i)] = true;
			}
			for (int j = 0; j < ct.length; j++) {
				if (ct[j]) {
					aa++;
				}
			}
			System.out.println(aa);
			for (int j = 0; j < ct.length; j++) {
				if (ct[j]) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		} catch (IOException e) {
		}
	}
}
