package 합이0인네정수_7453;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int num = Integer.parseInt(br.readLine());
			int[][] map = new int[4][num];
			for(int i = 0; i < num; i++) {
				String[] s = br.readLine().split(" ");
				for(int j = 0; j < 4; j++) {
					map[j][i] = Integer.parseInt(s[j]);
				}
			}
			for(int j = 0; j < 4; j++) {
				Arrays.sort(map[j]);
			}
			int[] sum1 = new int[num * num];
			int[] sum2 = new int[num * num];
			int index = 0;
			for(int i = 0; i < num; i++) {
				for(int j = 0; j < num; j++) {
					sum1[index] = map[0][i] + map[1][j];
					sum2[index++] = map[2][i] + map[3][j];
				}
			}
			for(int j = 0; j < sum1.length; j++) {
				System.out.print(sum1[j] + " ");
			}
			System.out.println();
			
			for(int j = 0; j < sum2.length; j++) {
				System.out.print(sum2[j] + " ");
			}
			System.out.println();
			
//			for(int i = 0; i < 4; i++) {
//				for(int j = 0; j < num; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		} catch (NumberFormatException | IOException e) {}
	}
}
