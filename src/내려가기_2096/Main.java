package 내려가기_2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int num = Integer.parseInt(br.readLine());
			int[][] map = new int[num][3];
			int[][] max = new int[num][3];
			int[][] min = new int[num][3];
			for(int i = 0; i < num; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < 3; j++) {
					map[i][j] = Integer.parseInt(s[j]);
					if(i == 0) {
						max[i][j] = map[i][j];
						min[i][j] = map[i][j];
					}
				}
				if(i > 0) {
					Arrays.fill(min[i], 200000000);
				}
			}
			//max 구하기
			for(int i = 0; i < num-1; i++) {
				for(int j = 0; j < 3; j++) {
					switch(j) {
					case 0:
						if(max[i+1][j] < max[i][j] + map[i+1][j]) {
							max[i+1][j] = max[i][j] + map[i+1][j];
						}
						if(max[i+1][j+1] < max[i][j] + map[i+1][j+1]) {
							max[i+1][j+1] = max[i][j] + map[i+1][j+1];
						}
						if(min[i+1][j] > min[i][j] + map[i+1][j]) {
							min[i+1][j] = min[i][j] + map[i+1][j];
						}
						if(min[i+1][j+1] > min[i][j] + map[i+1][j+1]) {
							min[i+1][j+1] = min[i][j] + map[i+1][j+1];
						}
						break;
					case 1:
						if(max[i+1][j-1] < max[i][j] + map[i+1][j-1]) {
							max[i+1][j-1] = max[i][j] + map[i+1][j-1];
						}
						if(max[i+1][j] < max[i][j] + map[i+1][j]) {
							max[i+1][j] = max[i][j] + map[i+1][j];
						}
						if(max[i+1][j+1] < max[i][j] + map[i+1][j+1]) {
							max[i+1][j+1] = max[i][j] + map[i+1][j+1];
						}
						if(min[i+1][j-1] > min[i][j] + map[i+1][j-1]) {
							min[i+1][j-1] = min[i][j] + map[i+1][j-1];
						}
						if(min[i+1][j] > min[i][j] + map[i+1][j]) {
							min[i+1][j] = min[i][j] + map[i+1][j];
						}
						if(min[i+1][j+1] > min[i][j] + map[i+1][j+1]) {
							min[i+1][j+1] = min[i][j] + map[i+1][j+1];
						}
						break;
					case 2:
						if(max[i+1][j-1] < max[i][j] + map[i+1][j-1]) {
							max[i+1][j-1] = max[i][j] + map[i+1][j-1];
						}
						if(max[i+1][j] < max[i][j] + map[i+1][j]) {
							max[i+1][j] = max[i][j] + map[i+1][j];
						}
						if(min[i+1][j-1] > min[i][j] + map[i+1][j-1]) {
							min[i+1][j-1] = min[i][j] + map[i+1][j-1];
						}
						if(min[i+1][j] > min[i][j] + map[i+1][j]) {
							min[i+1][j] = min[i][j] + map[i+1][j];
						}
						break;
					}
				}
			}
			
			int ansmax = Math.max(max[num-1][0], Math.max(max[num-1][1], max[num-1][2]));
			int ansmin = Math.min(min[num-1][0], Math.min(min[num-1][1], min[num-1][2]));
			System.out.println(ansmax + " " + ansmin);
		} 
		catch (NumberFormatException | IOException e) {
		}
	}
}
