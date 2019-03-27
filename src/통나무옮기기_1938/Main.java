package 통나무옮기기_1938;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Log {
		int x1;
		int y1;
		int x2;
		int y2;
		int x3;
		int y3;
		int dir;
		int count;
		
		public Log(int x1, int y1, int x2, int y2, int x3, int y3, int count, int dir) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.x3 = x3;
			this.y3 = y3;
			this.count = count;
			this.dir = dir;
			
		}

		@Override
		public String toString() {
			return "Log [x1=" + x1 + ", y1=" + y1 + ", x2=" + x2 + ", y2=" + y2 + ", x3=" + x3 + ", y3=" + y3 + ", dir="
					+ dir + ", count=" + count + "]";
		}

	
	}

	private static int[][] map;
	private static boolean[][][] visited;
	private static int[] endX;
	private static int[] endY;
	private static int ans;


	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int num = Integer.parseInt(br.readLine());

		map = new int[num + 2][num + 2];
		visited = new boolean[3][num + 2][num + 2];
		ans = 200000000;
		endX = new int[3];
		endY = new int[3];
		
		int[] xar = new int[3];
		int[] yar = new int[3];
		int idxS = 0;
		int idxE = 0;
		for (int i = 1; i <= num; i++) {
			String[] s = br.readLine().split("");
			for (int j = 1; j <= num; j++) {
				String ss = s[j - 1];
				switch (ss) {
				case "B":
					xar[idxS] = i;
					yar[idxS] = j;
					map[i][j] = 2;
					idxS++;
					break;
					
				case "0":
					map[i][j] = 2;
					break;
					
				case "1":
					map[i][j] = 0;
					break;
					
				case "E":
					endX[idxE] = i;
					endY[idxE] = j;
					map[i][j] = 3;
					idxE++;
					break;
				}
			
			}
		}
		
		int mode = 0;
		if(xar[0] == xar[1]) {
			mode = 1;
		}
		else {
			mode = 2;
		}
		for(int i = 0; i < 3; i++) {
			visited[mode][xar[i]][yar[i]] = true;
		}
		
		Queue<Log> qu = new LinkedList<>();
		qu.add(new Log(xar[0],yar[0],xar[1],yar[1],xar[2],yar[2],0,mode));
		
		while(!qu.isEmpty()) {
			Log l = qu.poll();
			int x1 = l.x1;
			int y1 = l.y1;
			int x2 = l.x2;
			int y2 = l.y2;
			int x3 = l.x3;
			int y3 = l.y3;
			int count = l.count;
			int ld = l.dir;
			
			if(x1 == endX[0] && x2 == endX[1] && x3 == endX[2] && 
					y1 == endY[0] && y2 == endY[1] && y3 == endY[2] ) {
				if(ans > count) {
					ans = count;
				}
				map[x1][y1] = 3;
				map[x2][y2] = 3;
				map[x3][y3] = 3;
				continue; 
			}
			
			if(count >= ans) {
				continue ;
			}
			
			if(ld == 1) {
				if(map[x1-1][y1] >= 2 && map[x2-1][y2] >= 2 && map[x3-1][y3] >= 2
						&& !visited[1][x1-1][y1] && !visited[1][x2-1][y2] && !visited[1][x3-1][y3]) {
					visited[1][x1-1][y1] = true;
					visited[1][x2-1][y2] = true;
					visited[1][x3-1][y3] = true;
					qu.add(new Log(x1-1,y1,x2-1,y2,x3-1,y3,count+1,1));

				}
				if(map[x1+1][y1] >= 2 && map[x2+1][y2] >= 2 && map[x3+1][y3] >= 2
						&& !visited[1][x1+1][y1] && !visited[1][x2+1][y2] && !visited[1][x3+1][y3]) {
					visited[1][x1+1][y1] = true;
					visited[1][x2+1][y2] = true;
					visited[1][x3+1][y3] = true;
					qu.add(new Log(x1+1,y1,x2+1,y2,x3+1,y3,count+1,1));

				}
				if(map[x1][y1-1] >= 2 && !visited[1][x1][y1-1]) {
					visited[1][x1][y1-1] = true;
					qu.add(new Log(x1,y1-1,x1,y1,x2,y2,count+1,1));
				}
				if(map[x3][y3+1] >= 2 && !visited[1][x3][y3+1]) {
					visited[1][x3][y3+1] = true;
					qu.add(new Log(x2,y2,x3,y3,x3,y3+1,count+1,1));
				}
				if(map[x2-1][y2] >= 2 && map[x2+1][y2] >= 2 && map[x1-1][y1] >= 2 && map[x1+1][y1] >= 2 
						&& map[x3-1][y3] >= 2 && map[x3+1][y3] >= 2 
						&& !visited[2][x2-1][y2] && !visited[2][x2][y2] && !visited[2][x2+1][y2]) {
					visited[2][x2-1][y2] = true;
					visited[2][x2][y2] = true;
					visited[2][x2+1][y2] = true;
					qu.add(new Log(x2-1,y2,x2,y2,x2+1,y2,count+1,2));
				}
			}
			else {
				if(map[x1-1][y1] >= 2 && !visited[2][x1-1][y1]) {
					visited[2][x1-1][y1] = true;
					qu.add(new Log(x1-1,y1,x1,y1,x2,y2,count+1,2));
				}
				if(map[x3+1][y3] >= 2 && !visited[2][x3+1][y3]) {
					visited[2][x3+1][y3] = true;
					qu.add(new Log(x2,y2,x3,y3,x3+1,y3,count+1,2));

				}
				if(map[x1][y1-1] >= 2 && map[x2][y2-1] >= 2 && map[x3][y3-1] >= 2
						&& !visited[2][x1][y1-1]&& !visited[2][x2][y2-1]&& !visited[2][x3][y3-1]) {
					visited[2][x1][y1-1] = true;
					visited[2][x2][y2-1] = true;
					visited[2][x3][y3-1] = true;
					qu.add(new Log(x1,y1-1,x2,y2-1,x3,y3-1,count+1,2));
				}
				if(map[x1][y1+1] >= 2 && map[x2][y2+1] >= 2 && map[x3][y3+1] >= 2
						&& !visited[2][x1][y1+1] && !visited[2][x2][y2+1] && !visited[2][x3][y3+1]) {
					visited[2][x1][y1+1] = true;
					visited[2][x2][y2+1] = true;
					visited[2][x3][y3+1] = true;
					qu.add(new Log(x1,y1+1,x2,y2+1,x3,y3+1,count+1,2));

				}
				if(map[x2][y2-1] >= 2 && map[x2][y2+1] >= 2 && map[x1][y1-1] >= 2 && map[x1][y1+1] >= 2
						&& map[x3][y3-1] >= 2 && map[x3][y3+1] >= 2
						&& !visited[1][x2][y2-1] && !visited[1][x2][y2] && !visited[1][x2][y2+1]) {
					visited[1][x2][y2-1]  = true;
					visited[1][x2][y2]  = true;
					visited[1][x2][y2+1] = true;
					qu.add(new Log(x2,y2-1,x2,y2,x2,y2+1,count+1,1));
				}
			}
			
		}
		
		if(ans == 200000000) {
			System.out.println("0");
		}
		else {
			System.out.println(ans);
		}
	}
}
