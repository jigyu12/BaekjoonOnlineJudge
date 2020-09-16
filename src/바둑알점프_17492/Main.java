package 바둑알점프_17492;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	
	static int N;
	static int[][] map;
	static int[] dx = {-1,0,1,0,-1,-1,1,1};
	static int[] dy = {0,-1,0,1,1,-1,-1,1};
	static boolean isPossibleWin = false;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+4][N+4];
		
		mapInit();

		for(int i = 2; i <= N+1; i++) {
			String[] input = br.readLine().split(" ");
			for(int j = 2; j <= N+1; j++) {
				map[i][j] = Integer.parseInt(input[j-2]);
			}
		}

		for(int i = 2; i <= N+1; i++) {
			for(int j = 2; j <= N+1; j++) {
				if(map[i][j] == 2) {
					moveToBlank();
				}
			}
		}

		if(isPossibleWin) {
			System.out.println("Possible");
		}
		else {
			System.out.println("Impossible");
		}
		
	}


	private static void moveToBlank() {
		
		if(isPossibleWin) {
			return ;
		}
		
		int nodeCount = 0;
		
		for(int x = 2; x <= N+1; x++) {
			for(int y = 2; y <= N+1; y++) {
				if(map[x][y] == 2) {
					nodeCount++;
					for(int k = 0; k < 8; k++) {
						if(map[x+dx[k]][y+dy[k]] == 2 
								&& map[x+ (dx[k]*2)][y+ (dy[k]*2)] == 0){
									map[x][y] = map[x+dx[k]][y+dy[k]] = 0;
									map[x+ (dx[k]*2)][y+ (dy[k]*2)] = 2;
									moveToBlank();
									map[x][y] = map[x+dx[k]][y+dy[k]] = 2;
									map[x+ (dx[k]*2)][y+ (dy[k]*2)] = 0;
								}
					}
				}
			}
		}
		
		if(nodeCount == 1) {
			isPossibleWin = true;
		}
	
	}

	private static void mapInit() {
		for(int i = 0; i <= N+3; i++) {
			for(int j = 0; j <= N+3; j++) {
				map[i][j] = 1;
			}
		}
	}
}
