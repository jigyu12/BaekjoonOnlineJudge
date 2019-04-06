package 백조의호수_3197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
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

	static class Swan {
		int x;
		int y;
		int num;

		public Swan(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Swan [x=" + x + ", y=" + y + ", num=" + num + "]";
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] rc = br.readLine().split(" ");
		int r = Integer.parseInt(rc[0]);
		int c = Integer.parseInt(rc[1]);
		
		int[][] map = new int[r + 2][c + 2];
		Queue<Node> water = new LinkedList<>();
		Deque<Swan> swan = new ArrayDeque<>();
		Deque<Swan> swan2 = new ArrayDeque<>();
		
		int swannum = 5;
		for (int i = 0; i < r + 2; i++) {
			Arrays.fill(map[i], -1);
		}
		
		for (int i = 1; i <= r; i++) {
			String[] s = br.readLine().split("");
			for (int j = 1; j <= c; j++) {
				switch (s[j - 1]) {
				case "X":
					map[i][j] = 0;
					break;
				case ".":
					map[i][j] = 1;
					water.add(new Node(i, j));
					break;
				case "L":
					swan.add(new Swan(i, j, swannum));
					map[i][j] = swannum;
					swannum++;
					water.add(new Node(i, j));
					break;
				}
			}
		}
		
		int ans = 0;
		exit: while (true) {
			
			int size = swan.size();
			for(int i = 0; i < size; i++) {
				swan2.add(swan.poll());
			}
			
			while (!swan2.isEmpty()) {
				Swan sw = swan2.poll();
				int sx = sw.x;
				int sy = sw.y;
				int sn = sw.num;
				
				if (map[sx - 1][sy] == 1) {
					swan2.add(new Swan(sx - 1, sy, sn));
					map[sx - 1][sy] = sn;
				}
				
				if (map[sx + 1][sy] == 1) {
					swan2.add(new Swan(sx + 1, sy, sn));
					map[sx + 1][sy] = sn;
				}
				
				if (map[sx][sy - 1] == 1) {
					swan2.add(new Swan(sx, sy - 1, sn));
					map[sx][sy - 1] = sn;
				}
				
				if (map[sx][sy + 1] == 1) {
					swan2.add(new Swan(sx, sy + 1, sn));
					map[sx][sy + 1] = sn;
				}
				
				if (map[sx - 1][sy] >= 5) {
					if (sn != map[sx - 1][sy]) {
						break exit;
					}
				}
				
				if (map[sx + 1][sy] >= 5) {
					if (sn != map[sx + 1][sy]) {
						break exit;
					}
				}
				
				if (map[sx][sy - 1] >= 5) {
					if (sn != map[sx][sy - 1]) {
						break exit;
					}
				}
				
				if (map[sx][sy + 1] >= 5) {
					if (sn != map[sx][sy + 1]) {
						break exit;
					}
				}
				
				if (map[sx - 1][sy] == 0 || map[sx + 1][sy] == 0 || map[sx][sy - 1] == 0
						|| map[sx][sy + 1] == 0) {
					swan.add(sw);
				}
			}
			
			int wsize = water.size();
			for (int i = 0; i < wsize; i++) {
				Node w = water.poll();
				int wx = w.x;
				int wy = w.y;
				if (map[wx - 1][wy] == 0) {
					map[wx - 1][wy] = 1;
					water.add(new Node(wx - 1, wy));
				}
				if (map[wx + 1][wy] == 0) {
					map[wx + 1][wy] = 1;
					water.add(new Node(wx + 1, wy));
				}
				if (map[wx][wy - 1] == 0) {
					map[wx][wy - 1] = 1;
					water.add(new Node(wx, wy - 1));
				}
				if (map[wx][wy + 1] == 0) {
					map[wx][wy + 1] = 1;
					water.add(new Node(wx, wy + 1));
				}
			}
			ans++;
		}
		System.out.println(ans);
	}
}
