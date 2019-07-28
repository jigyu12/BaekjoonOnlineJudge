package 스티커_9465;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int y = 0; y < test; y++) {
				int num = Integer.parseInt(br.readLine());
				int[][] map = new int[2][num+1];
				int[][] sum = new int[2][num+1];
				
				for(int j = 0; j < 2; j++) {
					String[] s = br.readLine().split(" ");
					for(int i = 1; i < num+1; i++) {
						map[j][i] = Integer.parseInt(s[i-1]);
					}
				}
				
				for(int i = 1; i < num+1; i++) {
					if(i > 1) {
						sum[0][i] = Math.max(sum[1][i-1]+map[0][i], Math.max(sum[0][i-2], sum[1][i-2]) + map[0][i]);
						sum[1][i] = Math.max(sum[0][i-1]+map[1][i], Math.max(sum[0][i-2], sum[1][i-2]) + map[1][i]);
					}
					else {
						sum[0][i] = map[0][i];
						sum[1][i] = map[1][i];
					}
				}
				bw.write(Math.max(sum[0][num], sum[1][num])+"\n");
			}
			bw.flush();
		} catch (NumberFormatException | IOException e) {
		}
	}
}
