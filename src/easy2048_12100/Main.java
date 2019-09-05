package easy2048_12100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int n;
	static int[][] map;
	static int ans;
	static int[] order;
	
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

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());
		map = new int[n + 2][n + 2];
		ans = 0;
		order = new int[5];
		for (int i = 1; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				int num = Integer.parseInt(s[j - 1]);
				if (num == 0) {
					map[i][j] = 1;
				} else {
					map[i][j] = num;
				}
			}
		}
		makeOrder(0);
		
		System.out.println(ans);
	}
	
	static void makeOrder(int count) {
		if(count == 5) {

			playgame(0, map);
			return;
		}
		
		for(int i = 1; i <= 4; i++) {
			order[count] = i;
			makeOrder(count+1);
		}
	}

	private static void playgame(int count, int[][] cur) {

		if (count == 5) {
			int max = 0;
			
			for (int i = 1; i < n + 1; i++) {
				for (int j = 1; j < n + 1; j++) {
					if (max < cur[i][j]) {
						max = cur[i][j];
					}
				}
			}
			
			if (max > ans) {
				ans = max;
			}
			return;
		}
		int[][] next = new int[n+2][n+2];
		
		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < n + 2; j++) {
				next[i][j] = cur[i][j];
			}
		}
		
		switch(order[count]) {
		
		case 1:
			left(count, cur);
			break;
		case 2:
			right(count, cur);
			break;
		case 3:
			up(count, cur);
			break;
		case 4:
			down(count, cur);
			break;
		}

	}

	private static void down(int count, int[][] cur) {
		int[][] next = new int[n + 2][n + 2];

		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < n + 2; j++) {
				next[i][j] = cur[i][j];
			}
		}
		
		boolean[][] noadd = new boolean[n+2][n+2];
		
		for (int i = n-1; i >= 1; i--) {
			for (int j = 1; j < n + 1; j++) {
				Queue<Node> qu = new LinkedList<>();
				qu.add(new Node(i, j));
				while (!qu.isEmpty()) {
					Node n = qu.poll();

					int x = n.x;
					int y = n.y;

					if (next[x+1][y] == 1) {
						qu.add(new Node(x+1, y));
						next[x+1][y] = next[x][y];
						next[x][y] = 1;
					} else if (next[x+1][y] == next[x][y] && !noadd[x+1][y]) {
						next[x+1][y] += next[x][y];
						next[x][y] = 1;
						noadd[x+1][y] = true;
					}
				}
			}
		}

		playgame(count + 1, next);
	}

	private static void up(int count, int[][] cur) {
		int[][] next = new int[n + 2][n + 2];
		
		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < n + 2; j++) {
				next[i][j] = cur[i][j];
			}
		}
		boolean[][] noadd = new boolean[n+2][n+2];
		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				Queue<Node> qu = new LinkedList<>();
				qu.add(new Node(i, j));
				while (!qu.isEmpty()) {
					Node n = qu.poll();

					int x = n.x;
					int y = n.y;

					if (next[x-1][y] == 1) {
						qu.add(new Node(x-1, y));
						next[x-1][y] = next[x][y];
						next[x][y] = 1;
					} else if (next[x-1][y] == next[x][y] && !noadd[x-1][y]) {
						next[x-1][y] += next[x][y];
						next[x][y] = 1;
						noadd[x-1][y] = true;
					}
				}
			}
		}

		playgame(count + 1, next);
	}

	private static void right(int count, int[][] cur) {
		
		int[][] next = new int[n + 2][n + 2];
		
		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < n + 2; j++) {
				next[i][j] = cur[i][j];
			}
		}
		boolean[][] noadd = new boolean[n+2][n+2];
		for (int i = n-1; i >= 1; i--) {
			for (int j = 1; j < n + 1; j++) {
				Queue<Node> qu = new LinkedList<>();
				qu.add(new Node(j, i));
				while (!qu.isEmpty()) {
					Node n = qu.poll();

					int x = n.x;
					int y = n.y;

					if (next[x][y + 1] == 1) {
						qu.add(new Node(x, y + 1));
						next[x][y + 1] = next[x][y];
						next[x][y] = 1;
					} else if (next[x][y + 1] == next[x][y] && !noadd[x][y+1]) {
						next[x][y + 1] += next[x][y];
						next[x][y] = 1;
						noadd[x][y+1] = true;
					}
				}
			}
		}

		playgame(count + 1, next);

	}

	private static void left(int count, int[][] cur) {
		int[][] next = new int[n + 2][n + 2];

		for (int i = 0; i < n + 2; i++) {
			for (int j = 0; j < n + 2; j++) {
				next[i][j] = cur[i][j];
			}
		}
		boolean[][] noadd = new boolean[n+2][n+2];
		for (int i = 2; i < n + 1; i++) {
			for (int j = 1; j < n + 1; j++) {
				Queue<Node> qu = new LinkedList<>();
				qu.add(new Node(j, i));
				while (!qu.isEmpty()) {
					Node n = qu.poll();

					int x = n.x;
					int y = n.y;

					if (next[x][y - 1] == 1) {
						qu.add(new Node(x, y - 1));
						next[x][y - 1] = next[x][y];
						next[x][y] = 1;
					} else if (next[x][y - 1] == next[x][y] && !noadd[x][y-1]) {
						next[x][y - 1] += next[x][y];
						next[x][y] = 1;
						noadd[x][y - 1] = true;
					}
				}
			}
		}
		
		playgame(count + 1, next);
	}
}
