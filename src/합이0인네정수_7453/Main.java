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
			Arrays.sort(sum1);
			Arrays.sort(sum2);
			
			int k = sum2.length-1;
			long count = 0;
			long cal = 0;
			for(int i = 0; i < sum1.length; i++) {
				if(i > 0) {
					if(sum1[i] == sum1[i-1]) {
						count += cal;
						continue;
					}
					else {
						cal = 0;
					}
				}
				for(; k >= 0; k--) {
					if(sum1[i] + sum2[k] > 0) {
						continue;
					}
					else if(sum1[i] + sum2[k] < 0) {
						break;
					}
					else {
						cal++;
					}
					
				}
				count += cal;
				
			}
			System.out.println(count);
		} catch (NumberFormatException | IOException e) {}
	}
}
