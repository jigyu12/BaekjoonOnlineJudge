package ¼º°û_2234;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	private static int[][] map;
	private static boolean[][] visited;
	private static int n;
	private static int m;
	private static int count;
	private static int wallcount;
	private static int wallmax;
	private static boolean[][] breakwall;

	private static void find(int x, int y) {

		count++;
		visited[x][y] = true;

		if (!visited[x][y - 1] && (map[x][y] & (1 << 0)) == 0) {
			find(x, y - 1);
		}
		if (!visited[x - 1][y] && (map[x][y] & (1 << 1)) == 0) {
			find(x - 1, y);
		}
		if (!visited[x][y + 1] && (map[x][y] & (1 << 2)) == 0) {
			find(x, y + 1);
		}
		if (!visited[x + 1][y] && (map[x][y] & (1 << 3)) == 0) {
			find(x + 1, y);
		}

	}
	
	private static void startbroke(int x, int y) {
		
		breakwall[x][y] = true;
		
		if (map[x][y-1] != 20 && !breakwall[x][y - 1] && (map[x][y] & (1 << 0)) == 0) {
			startbroke(x, y - 1);
		}
		if (map[x-1][y] != 20 && !breakwall[x - 1][y] && (map[x][y] & (1 << 1)) == 0) {
			startbroke(x - 1, y);
		}
		if (map[x][y+1] != 20 && !breakwall[x][y + 1] && (map[x][y] & (1 << 2)) == 0) {
			startbroke(x, y + 1);
		}
		if (map[x+1][y] != 20 && !breakwall[x + 1][y] && (map[x][y] & (1 << 3)) == 0) {
			startbroke(x + 1, y);
		}
		
		
		if (!visited[x][y - 1] && !breakwall[x][y - 1] && (map[x][y] & (1 << 0)) != 0) {
			wallcount = 0;
			broke(x, y - 1);
			if (wallmax < wallcount) {
				wallmax = wallcount;
			}
		}
		if (!visited[x - 1][y] && !breakwall[x - 1][y] && (map[x][y] & (1 << 1)) != 0) {
			wallcount = 0;
			broke(x - 1, y);
			if (wallmax < wallcount) {
				wallmax = wallcount;
			}
		}
		if (!visited[x][y + 1] && !breakwall[x][y + 1] && (map[x][y] & (1 << 2)) != 0) {
			wallcount = 0;
			broke(x, y + 1);
			if (wallmax < wallcount) {
				wallmax = wallcount;
			}
		}
		if (!visited[x + 1][y] && !breakwall[x + 1][y] && (map[x][y] & (1 << 3)) != 0) {
			wallcount = 0;
			broke(x + 1, y);
			if (wallmax < wallcount) {
				wallmax = wallcount;
			}
		}
	}

	private static void broke(int x, int y) {

		wallcount++;
		breakwall[x][y] = true;

		if (!visited[x][y - 1] && !breakwall[x][y - 1] && (map[x][y] & (1 << 0)) == 0) {
			broke(x, y - 1);
		}
		if (!visited[x - 1][y] && !breakwall[x - 1][y] && (map[x][y] & (1 << 1)) == 0) {
			broke(x - 1, y);
		} 
		if (!visited[x][y + 1] && !breakwall[x][y + 1] && (map[x][y] & (1 << 2)) == 0) {
			broke(x, y + 1);
		} 
		if (!visited[x + 1][y] && !breakwall[x + 1][y] && (map[x][y] & (1 << 3)) == 0) {
			broke(x + 1, y);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] nm = br.readLine().split(" ");
		n = Integer.parseInt(nm[1]);
		m = Integer.parseInt(nm[0]);

		map = new int[n + 2][m + 2];
		visited = new boolean[n + 2][m + 2];

		for (int i = 0; i < n + 2; i++) {
			Arrays.fill(visited[i], true);
			Arrays.fill(map[i], 20);
		}

		for (int i = 1; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 1; j <= m; j++) {
				visited[i][j] = false;
				map[i][j] = Integer.parseInt(s[j - 1]);
			}
		}

		int room = 0;
		int roommax = 0;
		int max = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				if (!visited[i][j]) {
					room++;
					count = 0;
					breakwall = new boolean[n + 2][m + 2];
					wallmax = 0;
					find(i, j);
					startbroke(i,j);
					if (roommax < count) {
						roommax = count;
					}
					if (max < count + wallmax) {
						max = count + wallmax;
					}
				}
			}
		}

		bw.write(room + "\n");
		bw.write(roommax + "\n");
		bw.write(max + "\n");
		bw.flush();
	}
}
