package บา_4179;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Jihoon {
		int x;
		int y;
		int count;

		public Jihoon(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Jihoon [x=" + x + ", y=" + y + ", count=" + count + "]";
		}

	}

	static class Fire {
		int x;
		int y;

		public Fire(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Fire [x=" + x + ", y=" + y + "]";
		}

	}

	private static int r;
	private static int c;
	private static int[][] map;
	private static boolean[][] visited;
	private static int ans;
	private static Queue<Jihoon> jihoon;
	private static Queue<Fire> fire;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] rc = br.readLine().split(" ");
		r = Integer.parseInt(rc[0]);
		c = Integer.parseInt(rc[1]);

		map = new int[r + 2][c + 2];
		visited = new boolean[r + 2][c + 2];
		ans = 1000000;
		jihoon = new LinkedList<>();
		fire = new LinkedList<>();
		for (int i = 1; i <= r; i++) {
			String[] s = br.readLine().split("");
			for (int j = 1; j <= c; j++) {
				switch (s[j - 1]) {
				case "#":
					visited[i][j] = true;
					break;

				case ".":
					map[i][j] = 1;
					break;

				case "J":
					jihoon.add(new Jihoon(i, j, 0));
					visited[i][j] = true;
					break;

				case "F":
					map[i][j] = 2;
					visited[i][j] = true;
					fire.add(new Fire(i, j));
				}
			}
		}

		while (!jihoon.isEmpty()) {
			int fsize = fire.size();

			for (int i = 0; i < fsize; i++) {
				Fire f = fire.poll();

				int x = f.x;
				int y = f.y;
				

				if (!visited[x - 1][y] && map[x - 1][y] == 1) {
					fire.add(new Fire(x - 1, y));
					map[x - 1][y] = 2;
					visited[x - 1][y] = true;
				}
				if (!visited[x + 1][y] && map[x + 1][y] == 1) {
					fire.add(new Fire(x + 1, y));
					map[x + 1][y] = 2;
					visited[x + 1][y] = true;
				}
				if (!visited[x][y - 1] && map[x][y - 1] == 1) {
					fire.add(new Fire(x, y - 1));
					map[x][y - 1] = 2;
					visited[x][y - 1] = true;
				}
				if (!visited[x][y + 1] && map[x][y + 1] == 1) {
					fire.add(new Fire(x, y + 1));
					map[x][y + 1] = 2;
					visited[x][y + 1] = true;
				}
			}

			int size = jihoon.size();
			for (int i = 0; i < size; i++) {
				Jihoon ji = jihoon.poll();
				int x = ji.x;
				int y = ji.y;
				int co = ji.count;

				if (map[x][y] == 0) {
					if (x == 0 || x == r + 1 || y == 0 || y == c + 1) {
						if (ans > co) {
							ans = co;
						}
						continue;
					}

				}

				if (ans <= c) {
					continue;
				}

				if (!visited[x - 1][y] && map[x - 1][y] != 2) {
					jihoon.add(new Jihoon(x - 1, y, co + 1));
					visited[x - 1][y] = true;
				}
				if (!visited[x + 1][y] && map[x + 1][y] != 2) {
					jihoon.add(new Jihoon(x + 1, y, co + 1));
					visited[x + 1][y] = true;
				}
				if (!visited[x][y - 1] && map[x][y - 1] != 2) {
					jihoon.add(new Jihoon(x, y - 1, co + 1));
					visited[x][y - 1] = true;
				}
				if (!visited[x][y + 1] && map[x][y + 1] != 2) {
					jihoon.add(new Jihoon(x, y + 1, co + 1));
					visited[x][y + 1] = true;
				}
			}

		}
		if (ans == 1000000) {
			System.out.println("IMPOSSIBLE");
		} else {
			System.out.println(ans);
		}
	}
}
