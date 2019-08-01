package 산책_5573;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int h = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken()) - 1;
		int[][] map = new int[h+2][w+2];
		int[][] move = new int[h+2][w+2];
		for(int i = 1; i <= h; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 1; j <= w; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		move[1][1] = n;
		
		for(int i = 1; i <= h; i++) {
			for(int j = 1; j <= w; j++) {
				if(move[i][j] % 2 == 0) {
					move[i][j+1] += move[i][j] / 2;
					move[i+1][j] += move[i][j] / 2;
				}
				else {
					if(map[i][j] == 1) {
						move[i][j+1] += (move[i][j] / 2) + 1;
						move[i+1][j] += move[i][j] / 2;
					}
					else {
						move[i][j+1] += move[i][j] / 2;
						move[i+1][j] += (move[i][j] / 2 )+ 1;
					}
				}
			}
		}
		
		for(int i = 1; i <= h; i++) {
			for(int j = 1; j <= w; j++) {
				map[i][j] = (map[i][j] + move[i][j]) % 2;
			}
		}

		int i = 1, j = 1;
		
		while(i <= h && j <= w) {
			if(map[i][j] == 1) {
				j++;
			}
			else {
				i++;
			}
		}
		System.out.println(i + " " + j);
	}
}
