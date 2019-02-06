package 일이삼더하기_9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[][] map = new int[12][34];
		map[1][1] = 1;
		map[1][2] = 1;
		map[1][3] = 1;
		for(int i = 1; i < 11; i++) {
			for(int j = 1; j < 33; j++) {
				for(int k = 1; k <= 3; k++) {
					if(map[i][j] > 0) {
						map[i+1][j+k]++; 
					}
				}
			}
		}
		for(int i = 0; i < 12; i++) {
			for(int j = 0; j < 34; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 0; i < test; i++) {
				int num = Integer.parseInt(br.readLine());
				
				
			}
		} catch (NumberFormatException | IOException e) {
		}
		
	}

}
