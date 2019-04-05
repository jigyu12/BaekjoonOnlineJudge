package µå·¡°ïÄ¿ºê_15685;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[][] map = new boolean[101][101];
		
		int n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			int x = Integer.parseInt(s[0]);
			int y = Integer.parseInt(s[1]);
			int d = Integer.parseInt(s[2]);
			int g = Integer.parseInt(s[3]);
			
			map[y][x] = true;
			
			int startX = y;
			int startY = x;
			Queue<Integer> qu = new LinkedList<>();
			ArrayList<Integer> draw = new ArrayList<>();
			draw.add(d);
			
			for (int j = 1; j <= g; j++) {
				for (int k = draw.size() - 1; k >= 0; k--) {
					qu.add(draw.get(k));
				}
				int size = qu.size();
				for (int k = 0; k < size; k++) {
					int dd = qu.poll();
					draw.add((dd + 1) % 4);
				}
			}
			
			for (int j = 0; j < draw.size() ; j++) {
				switch(draw.get(j)) {
				case 0:
					map[startX][++startY] = true;
					break;
				case 1:
					map[--startX][startY] = true;
					break;
				case 2:
					map[startX][--startY] = true;
					break;
				case 3:
					map[++startX][startY] = true;
					break;
				}
			}
		}

		int ans = 0;
		for (int j = 0; j < 100; j++) {
			for (int k = 0; k < 100; k++) {
				if(map[j][k] && map[j+1][k] && map[j][k+1] && map[j+1][k+1]) {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}
