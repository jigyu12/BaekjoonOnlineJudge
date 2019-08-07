package 낚시왕_17143;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;
		int num;

		public Shark(int r, int c, int s, int d, int z, int num) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d;
			this.z = z;
			this.num = num;
		}

		@Override
		public String toString() {
			return "Shark [r=" + r + ", c=" + c + ", s=" + s + ", d=" + d + ", z=" + z + ", num=" + num + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] RCM = br.readLine().split(" ");
		int R = Integer.parseInt(RCM[0]);
		int C = Integer.parseInt(RCM[1]);
		int M = Integer.parseInt(RCM[2]);

		Shark[][] map = new Shark[R][C];
		boolean[] deadshark = new boolean[M];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = new Shark(i, j, -1, -1, -1, -1);
			}
		}

		Shark[] ar = new Shark[M];

		for (int i = 0; i < M; i++) {
			String[] ss = br.readLine().split(" ");
			int r = Integer.parseInt(ss[0]) - 1;
			int c = Integer.parseInt(ss[1]) - 1;
			int s = Integer.parseInt(ss[2]);
			int d = Integer.parseInt(ss[3]) - 1;
			int z = Integer.parseInt(ss[4]);

			if (d == 1) {
				d = 2;
			} else if (d == 2) {
				d = 1;
			}

			map[r][c].s = s;
			map[r][c].d = d;
			map[r][c].z = z;
			map[r][c].num = i;
			ar[i] = new Shark(r, c, s, d, z, i);
		}
		int ans = 0;
		for (int i = 0; i < C; i++) {
			for (int j = 0; j < R; j++) {
				if (map[j][i].num > -1) {
					ans += map[j][i].z;
					map[j][i].s = -1;
					map[j][i].d = -1;
					deadshark[map[j][i].num] = true;
					map[j][i].z = -1;
					map[j][i].num = -1;
					break;
				}
			}
			Shark[][] movemap = new Shark[R][C];
			for (int b = 0; b < R; b++) {
				for (int j = 0; j < C; j++) {
					movemap[b][j] = new Shark(b, j, -1, -1, -1, -1);
				}
			}

			for (int j = 0; j < M; j++) {
				if (!deadshark[j]) {
					if(ar[j].d == 0) {
						int move = ar[j].s % ((R - 1) * 2);

						int x = ar[j].r;
						int y = ar[j].c;
						map[x][y].s = -1;
						map[x][y].d = -1;
						map[x][y].z = -1;
						map[x][y].num = -1;

						boolean goup = true;
						while (move > 0) {
							if (x == 0) {
								goup = false;
							} else if (x == R - 1) {
								goup = true;
							}
							if (goup) {
								x--;
							} else {
								x++;
							}
						
							move--;
						}
						ar[j].r = x;
						ar[j].c = y;
						if(movemap[x][y].z < ar[j].z) {
							if(movemap[x][y].num >= 0) {
								deadshark[movemap[x][y].num] = true;
							}
							movemap[x][y].s = ar[j].s;
							if (!goup) {
								movemap[x][y].d = (ar[j].d + 2) % 4;
							} else {
								movemap[x][y].d = ar[j].d;
							}
							movemap[x][y].z = ar[j].z;
							movemap[x][y].num = ar[j].num;
						}
						else {
							deadshark[j] = true;
						}
					}
					else if(ar[j].d == 1) {
						int move = ar[j].s % ((C - 1) * 2);

						int x = ar[j].r;
						int y = ar[j].c;
						map[x][y].s = -1;
						map[x][y].d = -1;
						map[x][y].z = -1;
						map[x][y].num = -1;

						boolean goright = true;
						while (move > 0) {
							if (y == C - 1) {
								goright = false;
							} else if (y == 0) {
								goright = true;
							}
							if (goright) {
								y++;
							} else {
								y--;
							}
							
							move--;
						}
						ar[j].r = x;
						ar[j].c = y;
						if(movemap[x][y].z < ar[j].z) {
							if(movemap[x][y].num >= 0) {
								deadshark[movemap[x][y].num] = true;
							}
							movemap[x][y].s = ar[j].s;
							if (!goright) {
								movemap[x][y].d = (ar[j].d + 2) % 4;
							} else {
								movemap[x][y].d = ar[j].d;
							}
							movemap[x][y].z = ar[j].z;
							movemap[x][y].num = ar[j].num;
						}
						else {
							deadshark[j] = true;
						}
					}
					
					else if(ar[j].d == 2) {
						int move = ar[j].s % ((R - 1) * 2);

						int x = ar[j].r;
						int y = ar[j].c;
						map[x][y].s = -1;
						map[x][y].d = -1;
						map[x][y].z = -1;
						map[x][y].num = -1;

						boolean godown = true;
						while (move > 0) {
							if (x == R - 1) {
								godown = false;
							} else if (x == 0) {
								godown = true;
							}
							if (godown) {
								x++;
							} else {
								x--;
							}
							
							move--;
						}
						ar[j].r = x;
						ar[j].c = y;
						if(movemap[x][y].z < ar[j].z) {
							if(movemap[x][y].num >= 0) {
								deadshark[movemap[x][y].num] = true;
							}
							movemap[x][y].s = ar[j].s;
							if (!godown) {
								movemap[x][y].d = (ar[j].d + 2) % 4;
							} else {
								movemap[x][y].d = ar[j].d;
							}
							movemap[x][y].z = ar[j].z;
							movemap[x][y].num = ar[j].num;
						}
						else {
							deadshark[j] = true;
						}
						
					}
					else if(ar[j].d == 3) {
						int move = ar[j].s % ((C - 1) * 2);

						int x = ar[j].r;
						int y = ar[j].c;
						map[x][y].s = -1;
						map[x][y].d = -1;
						map[x][y].z = -1;
						map[x][y].num = -1;

						boolean goleft = true;
						while (move > 0) {
							if (y == 0) {
								goleft = false;
							} else if (y == C-1) {
								goleft = true;
							}
							if (goleft) {
								y--;
							} else {
								y++;
							}
							
							move--;
						}
						ar[j].r = x;
						ar[j].c = y;
						
						if(movemap[x][y].z < ar[j].z) {
							if(movemap[x][y].num >= 0) {
								deadshark[movemap[x][y].num] = true;
							}
							movemap[x][y].s = ar[j].s;
							if (!goleft) {
								movemap[x][y].d = (ar[j].d + 2) % 4;
							} else {
								movemap[x][y].d = ar[j].d;
							}
							movemap[x][y].z = ar[j].z;
							movemap[x][y].num = ar[j].num;
						}
						else {
							deadshark[j] = true;
						}
					}
				}
			}
			for (int o = 0; o < R; o++) {
				for (int j = 0; j < C; j++) {
					if(movemap[o][j].num > -1) {
						map[o][j].s = movemap[o][j].s;
						map[o][j].d = movemap[o][j].d;
						map[o][j].z = movemap[o][j].z;
						map[o][j].num = movemap[o][j].num;
						ar[movemap[o][j].num].s = movemap[o][j].s;
						ar[movemap[o][j].num].d = movemap[o][j].d;
						ar[movemap[o][j].num].z = movemap[o][j].z;
					}
				}

			}
		}
		System.out.println(ans);
	}
}
