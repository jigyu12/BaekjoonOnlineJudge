package 토마토_7576;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] mn = br.readLine().split(" ");
		int n = Integer.parseInt(mn[0]);
		int m = Integer.parseInt(mn[1]);

		int[][] map = new int[m + 2][n + 2];
		Queue<Node> qu = new LinkedList<>();

		for (int i = 1; i <= m; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				int t = Integer.parseInt(s[j - 1]);
				switch (t) {
				case 0:
					map[i][j] = 1;
					break;

				case 1:
					map[i][j] = 2;
					qu.add(new Node(i, j));
					break;
				}
			}
		}

		int ans = 0;
		while (!qu.isEmpty()) {
			int size = qu.size();
			boolean add = false;
			for (int i = 0; i < size; i++) {
				Node no = qu.poll();

				int x = no.x;
				int y = no.y;

				if (map[x + 1][y] == 1) {
					add = true;
					map[x + 1][y] = 2;
					qu.add(new Node(x+1,y));
				}
				if (map[x - 1][y] == 1) {
					add = true;
					map[x - 1][y] = 2;
					qu.add(new Node(x-1,y));
				}
				if (map[x][y - 1] == 1) {
					add = true;
					map[x][y-1] = 2;
					qu.add(new Node(x,y-1));
				}
				if (map[x][y + 1] == 1) {
					add = true;
					map[x][y+1] = 2;
					qu.add(new Node(x,y+1));
				}
			}
			if(add) {
				ans++;
			}
		}

		boolean noans = true;
		xx: for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (map[i][j] == 1) {
					noans = false;
					break xx;
				}
			}
		}

		if (noans) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}

	}

}
