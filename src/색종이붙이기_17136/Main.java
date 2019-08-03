package 색종이붙이기_17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	private static int[][] map;
	private static int shape[];
	private static int ans;

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
		map = new int[16][16];
		ans = 101;
		shape = new int[5];
		Arrays.fill(shape, 5);
		for (int i = 1; i <= 10; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 1; j <= 10; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}

		draw(0);
		
		if (ans == 101) {
			System.out.println(-1);
		} else {
			System.out.println(ans);
		}

	}

	static void draw(int cnt) {
		
		if(cnt >= ans) {
			return;
		}
		
		boolean findone = false;
		
		for(int i = 1 ; i <= 10; i++) {
			for(int j = 1; j <= 10; j++) {
				if(map[i][j] == 1) {
					findone = true;
					for(int s = 4; s > 0; s--) {
						if(shape[s] > 0) {
							--shape[s];
							boolean nonzero = true;
							ArrayList<Node> ar = new ArrayList<>();
							for(int k = i; k <= i+s; k++ ) {
								for(int l = j; l <= j+s; l++) {
									if(map[k][l] == 1) {
										ar.add(new Node(k,l));
										map[k][l] = 0;
									}
									else {
										nonzero = false;
										int size = ar.size();
										for(int b = 0; b < size; b++) {
											Node n = ar.get(b);
											map[n.x][n.y] = 1;
										}
										++shape[s];
									}
								}
							}
							if(nonzero) {
								draw(cnt+1);
							}
							++shape[s];
							int size = ar.size();
							for(int k = 0; k < size; k++) {
								Node n = ar.get(k);
								map[n.x][n.y] = 1;
							}
						}
					}
				}
			}
		}
		
		
		if(!findone && ans > cnt) {
			ans = cnt;
		}
	}
}
