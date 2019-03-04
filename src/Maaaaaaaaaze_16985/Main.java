package Maaaaaaaaaze_16985;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	private static int[][][] map;
	private static int ans;
	private static int[][][] go;

	
	//4. 미로 찾는 과정
	private static void find(int floor, int x, int y, int count, boolean[][][] check) {

		if (check[floor][x][y]) {
			return;
		}
		
		if (floor == 5 && x == 5 && y == 5) {
			if (count < ans) {
				ans = count;
			}
			return;
		}

		if(count > ans || ans == 12) {
			return;
		}

		check[floor][x][y] = true;

		if (go[floor - 1][x][y] == 1 && !check[floor - 1][x][y]) {
			find(floor - 1, x, y, count + 1, check);
			check[floor - 1][x][y] = false;
		}

		if (go[floor + 1][x][y] == 1 && !check[floor + 1][x][y]) {
			find(floor + 1, x, y, count + 1, check);
			check[floor + 1][x][y] = false;
		}

		if (go[floor][x - 1][y] == 1 && !check[floor][x-1][y]) {
			find(floor, x - 1, y, count + 1, check);
			check[floor][x - 1][y] = false;
		}

		if (go[floor][x + 1][y] == 1 && !check[floor][x+1][y]) {
			find(floor, x + 1, y, count + 1, check);
			check[floor][x + 1][y] = false;
		}

		if (go[floor][x][y - 1] == 1 && !check[floor][x][y-1]) {
			find(floor, x, y - 1, count + 1, check);
			check[floor][x][y - 1] = false;
		}

		if (go[floor][x][y + 1] == 1 && !check[floor][x][y+1]) {
			find(floor, x, y + 1, count + 1, check);
			check[floor][x][y + 1] = false;
		}
		
		check[floor][x][y] = false;
		return ;

	}

	//3. 미로 길을 찾기 전의 전처리 과정
	private static void findpath(int[][][] maze) {
		boolean[][][] checked = new boolean[7][7][7];
		go = maze;
		
		if(go[1][1][1] == 0 || go[5][5][5] == 0) {
			return ;
		}

		find(1, 1, 1, 0, checked);
	}

	//2. 모든 미로를 돌리는 경우의 수
	private static void rotate(int[] order) {
		int[][][] copy = new int[7][7][7];
		
		for (int i = 1; i < 6; i++) {
			copy[i] = map[order[i - 1]];
		}

		for (int i = 0; i < 4; i++) {
			int[][] maze = new int[7][7];

			for (int x = 1; x < 6; x++) {
				for (int y = 1; y < 6; y++) {
					maze[x][y] = copy[1][y][5 - x + 1];
				}
			}

			for (int x = 1; x < 6; x++) {
				for (int y = 1; y < 6; y++) {
					copy[1][x][y] = maze[x][y];
				}
			}

			for (int j = 0; j < 4; j++) {

				int[][] maze1 = new int[7][7];

				for (int x = 1; x < 6; x++) {
					for (int y = 1; y < 6; y++) {
						maze1[x][y] = copy[2][y][5 - x + 1];
					}
				}

				for (int x = 1; x < 6; x++) {
					for (int y = 1; y < 6; y++) {
						copy[2][x][y] = maze1[x][y];
					}
				}

				for (int k = 0; k < 4; k++) {

					int[][] maze2 = new int[7][7];

					for (int x = 1; x < 6; x++) {
						for (int y = 1; y < 6; y++) {
							maze2[x][y] = copy[3][y][5 - x + 1];
						}
					}

					for (int x = 1; x < 6; x++) {
						for (int y = 1; y < 6; y++) {
							copy[3][x][y] = maze2[x][y];
						}
					}
					for (int l = 0; l < 4; l++) {

						int[][] maze3 = new int[7][7];

						for (int x = 1; x < 6; x++) {
							for (int y = 1; y < 6; y++) {
								maze3[x][y] = copy[4][y][5 - x + 1];
							}
						}

						for (int x = 1; x < 6; x++) {
							for (int y = 1; y < 6; y++) {
								copy[4][x][y] = maze3[x][y];
							}
						}

						for (int m = 0; m < 4; m++) {
							int[][] maze4 = new int[7][7];

							for (int x = 1; x < 6; x++) {
								for (int y = 1; y < 6; y++) {
									maze4[x][y] = copy[5][y][5 - x + 1];
								}
							}

							for (int x = 1; x < 6; x++) {
								for (int y = 1; y < 6; y++) {
									copy[5][x][y] = maze4[x][y];
								}
							}

							findpath(copy);
						}
					}
				}
			}
		}
	}

	//1번. 각 미로를 쌓는 과정(순열)
	private static void permutation(int[] order, int count, int cal) {

		if (count == 5) {
			rotate(order);
			return;
		}

		for (int i = 0; i < 5; i++) {
			if ((cal & (2 << i)) == 0) {
				order[count] = i+1;
				permutation(order, count + 1, cal | (2 << i));
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[7][7][7];
		go = new int[7][7][7];
		ans = 2000000000;
		for (int i = 1; i < 6; i++) {
			for (int j = 1; j < 6; j++) {
				String[] s = br.readLine().split(" ");
				for (int k = 1; k < 6; k++) {
					map[i][j][k] = Integer.parseInt(s[k - 1]);
				}
			}
		}

		int[] ar = new int[5];
		permutation(ar, 0, 0);
		if(ans == 2000000000) {
			System.out.println("-1");
		}
		else {
			System.out.println(ans);
		}
	}

}
