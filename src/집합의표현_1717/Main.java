package 집합의표현_1717;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private static void union(int x, int y) {

		parent[find(x)] = find(y);
	}

	private static void init(int x) {
		parent[x] = x;
	}

	private static int find(int x) {
		if (parent[x] == x) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		parent = new int[n + 1];
		for (int i = 0; i < n + 1; i++) {
			init(i);
		}
		for (int i = 0; i < m; i++) {
			String[] qab = br.readLine().split(" ");
			int q = Integer.parseInt(qab[0]);
			int a = Integer.parseInt(qab[1]);
			int b = Integer.parseInt(qab[2]);
			if (q == 0) {
				union(a, b);

			} else if (q == 1) {
				if (find(a) == find(b)) {
					bw.write("YES\n");
				} else {
					bw.write("NO\n");
				}
			}
		}
		bw.flush();
	}
}