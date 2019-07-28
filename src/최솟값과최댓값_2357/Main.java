package 최솟값과최댓값_2357;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

	private static int[] ar;
	private static int[] tree;

	private static int initmin(int start, int end, int node) {

		if (start == end) {
			return tree[node] = ar[start];
		}

		int mid = (start + end) / 2;

		return tree[node] = Math.min(initmin(start, mid, 2 * node), initmin(mid + 1, end, 2 * node + 1));
	}

	private static int initmax(int start, int end, int node) {

		if (start == end) {
			return tree[node] = ar[start];
		}

		int mid = (start + end) / 2;

		return tree[node] = Math.max(initmax(start, mid, 2 * node), initmax(mid + 1, end, 2 * node + 1));
	}

	private static int min(int start, int end, int left, int right, int node) {
		if (end < left || right < start) {
			return 1000000001;
		}

		else if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;

		return Math.min(min(start, mid, left, right, 2 * node), min(mid + 1, end, left, right, 2 * node + 1));

	}

	private static int max(int start, int end, int left, int right, int node) {
		if (end < left || right < start) {
			return 0;
		}

		else if (left <= start && end <= right) {
			return tree[node];
		}

		int mid = (start + end) / 2;

		return Math.max(max(start, mid, left, right, 2 * node), max(mid + 1, end, left, right, 2 * node + 1));

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
			ArrayList<Integer> arA = new ArrayList<Integer>();
			ArrayList<Integer> arB = new ArrayList<Integer>();
			int[][] ans = new int[m][2];
			for (int i = 0; i < n; i++) {
				ar[i] = Integer.parseInt(br.readLine());
			}

			for (int i = 0; i < m; i++) {
				String[] s = br.readLine().split(" ");
				arA.add(Integer.parseInt(s[0]));
				arB.add(Integer.parseInt(s[1]));
			}
			initmin(0, n - 1, 1);
			for (int i = 0; i < m; i++) {
				ans[i][0] = min(0, n - 1, arA.get(i) - 1, arB.get(i) - 1, 1);
			}
			initmax(0, n - 1, 1);
			for (int i = 0; i < m; i++) {
				ans[i][1] = max(0, n - 1, arA.get(i) - 1, arB.get(i) - 1, 1);
			}
			for (int i = 0; i < m; i++) {
				bw.write(ans[i][0] + " " + ans[i][1] + "\n");
			}
			bw.flush();
			bw.close();
			br.close();
		} catch (IOException e) {
		}
	}
}
