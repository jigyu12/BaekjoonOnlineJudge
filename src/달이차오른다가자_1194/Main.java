package 달이차오른다가자_1194;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class People {
		int x;
		int y;
		int key;
		int count;

		public People(int x, int y, int key, int count) {
			this.x = x;
			this.y = y;
			this.key = key;
			this.count = count;
		}

		@Override
		public String toString() {
			return "People [x=" + x + ", y=" + y + ", key=" + key + ", count=" + count + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] nm = br.readLine().split(" ");

		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int[][] map = new int[n + 2][m + 2];
		boolean[][][] visited = new boolean[65][n + 2][m + 2];
		Queue<People> qu = new LinkedList<People>();
		for (int i = 1; i <= n; i++) {
			String[] s = br.readLine().split("");
			for (int j = 1; j <= m; j++) {
				if (s[j - 1].equals("0")) {
					map[i][j] = 1;
					qu.add(new People(i, j, 0, 0));
				} 
				else if (s[j - 1].equals("1")) {
					map[i][j] = 2;
				} 
				else if (s[j - 1].equals(".")) {
					map[i][j] = 3;
				} 
				else if (s[j - 1].equals("#")) {
					map[i][j] = 0;
				} 
				else {
					map[i][j] = s[j - 1].charAt(0);
				}
			}
		}
		
		int ans = 168501;
		while (!qu.isEmpty()) {
			People p = qu.poll();
			int px = p.x;
			int py = p.y;
			int pk = p.key;
			int pc = p.count;

			if (map[px][py] == 2) {
				if (ans > pc) {
					ans = pc;
				}
				continue;
			}

			if (ans <= pc) {
				continue;
			}

			if (!visited[pk][px - 1][py] && map[px - 1][py] != 0) {
				if (map[px - 1][py] <= 3) {
					qu.add(new People(px - 1, py, pk, pc + 1));
					visited[pk][px - 1][py] = true;
				} 
				else if (65 <= map[px - 1][py] && map[px - 1][py] <= 90) {
					int door = map[px - 1][py] - 65;
					if ((pk & (1 << door)) != 0) {
						qu.add(new People(px - 1, py, pk, pc + 1));
						visited[pk][px - 1][py] = true;
					}
				} 
				else {
					int pkey = pk | (1 << map[px - 1][py] - 97);
					qu.add(new People(px - 1, py, pkey, pc + 1));
					visited[pk][px - 1][py] = true;
				}
			}

			if (!visited[pk][px + 1][py] && map[px + 1][py] != 0) {
				if (map[px + 1][py] <= 3) {
					qu.add(new People(px + 1, py, pk, pc + 1));
					visited[pk][px + 1][py] = true;
				} 
				else if (65 <= map[px + 1][py] && map[px + 1][py] <= 90) {
					int door = map[px + 1][py] - 65;
					if ((pk & (1 << door)) != 0) {
						qu.add(new People(px + 1, py, pk, pc + 1));
						visited[pk][px + 1][py] = true;
					}
				} 
				else {
					int pkey = pk | (1 << map[px + 1][py] - 97);
					qu.add(new People(px + 1, py, pkey, pc + 1));
					visited[pk][px + 1][py] = true;
				}
			}

			if (!visited[pk][px][py - 1] && map[px][py - 1] != 0) {
				if (map[px][py - 1] <= 3) {
					qu.add(new People(px, py - 1, pk, pc + 1));
					visited[pk][px][py - 1] = true;
				} 
				else if (65 <= map[px][py - 1] && map[px][py - 1] <= 90) {
					int door = map[px][py - 1] - 65;
					if ((pk & (1 << door)) != 0) {
						qu.add(new People(px, py - 1, pk, pc + 1));
						visited[pk][px][py - 1] = true;
					}
				} 
				else {
					int pkey = pk | (1 << map[px][py - 1] - 97);
					qu.add(new People(px, py - 1, pkey, pc + 1));
					visited[pk][px][py - 1] = true;
				}
			}

			if (!visited[pk][px][py + 1] && map[px][py + 1] != 0) {
				if (map[px][py + 1] <= 3) {
					qu.add(new People(px, py + 1, pk, pc + 1));
					visited[pk][px][py + 1] = true;
				} 
				else if (65 <= map[px][py + 1] && map[px][py + 1] <= 90) {
					int door = map[px][py + 1] - 65;
					if ((pk & (1 << door)) != 0) {
						qu.add(new People(px, py + 1, pk, pc + 1));
						visited[pk][px][py + 1] = true;
					}
				} 
				else {
					int pkey = pk | (1 << map[px][py + 1] - 97);
					qu.add(new People(px, py + 1, pkey, pc + 1));
					visited[pk][px][py + 1] = true;
				}
			}
		}
		if (ans == 168501) {
			System.out.println("-1");
		} 
		else {
			System.out.println(ans);
		}
	}
}
