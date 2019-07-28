package 주사위굴리기_14499;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nmxyk = br.readLine().split(" ");
		
		int n = Integer.parseInt(nmxyk[0]);
		int m = Integer.parseInt(nmxyk[1]);
		int x = Integer.parseInt(nmxyk[2]) + 1;
		int y = Integer.parseInt(nmxyk[3]) + 1;
		int k = Integer.parseInt(nmxyk[4]);
		
		int[][] map = new int[n+2][m+2];
		
		ArrayList<Integer> garo = new ArrayList<>();
		ArrayList<Integer> sero = new ArrayList<>();
		
		garo.add(0);
		garo.add(0);
		garo.add(0);
		garo.add(0);
		sero.add(0);
		sero.add(0);
		sero.add(0);
		sero.add(0);
		for(int i = 0; i < n+2; i++) {
			Arrays.fill(map[i], -1);
		}
		
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		String[] s = br.readLine().split(" ");
		
		for(int t = 0; t < k; t++) {
			int command = Integer.parseInt(s[t]);
			boolean out = false;
			switch(command) {
			case 1:
				if(map[x][y+1] == -1) {
					out = true;
					break;
				}
				int temp1 = garo.remove(0);
				y++;
				if(map[x][y] == 0) {
					map[x][y] = temp1;
					garo.add(temp1);
				}
				else {
					temp1 = map[x][y];
					garo.add(temp1);
					map[x][y] = 0;
				}

				sero.set(3,temp1);
				sero.set(1, garo.get(1));
				break;
				
			case 2:
				if(map[x][y-1] == -1) {
					out = true;
					break;
				}
				
				int temp2 = garo.remove(3);
				garo.add(0,temp2);
				y--;
				temp2 = garo.remove(3);
				if(map[x][y] == 0) {
					map[x][y] = temp2;
					garo.add(temp2);
				}
				else {
					temp2 = map[x][y];
					garo.add(temp2);
					map[x][y] = 0;
				}
				sero.set(3,temp2);
				sero.set(1, garo.get(1));
				break;
			case 3:
				if(map[x-1][y] == -1) {
					out = true;
					break;
				}
				
				int temp3 = sero.remove(0);
				x--;
				
				if(map[x][y] == 0) {
					map[x][y] = temp3;
					sero.add(temp3);
				}
				else {
					temp3 = map[x][y];
					sero.add(temp3);
					map[x][y] = 0;
				}
				garo.set(3,temp3);
				garo.set(1, sero.get(1));
				break;
			case 4:
				if(map[x+1][y] == -1) {
					out = true;
					break;
				}
				
				int temp4 = sero.remove(3);
				sero.add(0,temp4);
				x++;
				temp4 = sero.remove(3);
				if(map[x][y] == 0) {
					map[x][y] = temp4;
					sero.add(temp4);
				}
				else {
					temp4 = map[x][y];
					sero.add(temp4);
					map[x][y] = 0;
				}
				garo.set(3,temp4);
				garo.set(1, sero.get(1));
				break;
			}
			if(out) {
				continue;
			}

			bw.write(garo.get(1)+"\n");
		}
		bw.flush();
	}
}
