package 발전소_1102;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static ArrayList<Integer> on = new ArrayList<>();
	static int p;
	static int[] cost;
	static int onsize;
	static int n;
	static int[][] map;
	static final int INF = (int) (1e9 + 1);

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine().trim());

		map = new int[n][n];
		cost = new int[1 << n];
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

		for (int j = 0; j < (1 << n); j++) {
			cost[j] = INF;
		}

		int state = 0;
		// ���� ������ ����
		String onoff = br.readLine().trim();
		p = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < onoff.length(); i++) {
			int ch = onoff.charAt(i);
			if (ch == 'Y') {
				on.add(i);
				state |= (1 << i);
			}
		}

		onsize = on.size();
		int size = onsize;
		if (size == 0) {
			if (p == 0) {
				System.out.println(0);
			} else {
				System.out.println(-1);
			}
		} else if (size >= p) {
			System.out.println(0);
		} else {
			System.out.println(permutation(state, size));
		}

	}

	static int permutation(int state, int oncnt) {

		if (oncnt == p) {
			return 0;
		}

		if (cost[state] != 1000000001) {
			return cost[state];
		}
		for (int i = 0; i < n; i++) {
			if ((state & (1 << i)) > 0) {
				for (int j = 0; j < n; j++) {
					if (i == j) {
						continue;
					}
					if ((state & (1 << j)) == 0) {
						cost[state] = Math.min(cost[state], 
								permutation(state | (1 << j), oncnt + 1) + map[i][j]);
					}
				}
			}
			
		}
		return cost[state];
	}
}
