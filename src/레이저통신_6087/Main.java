package 레이저통신_6087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static class Node {
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}


	}

	private static int w;
	private static int h;
	private static int[][] map;
	private static int[][] countmap;
	private static int startX;
	private static int startY;
	private static int endX;
	private static int endY;

	private static void bfs(int x, int y) {
		Queue<Node> qu = new LinkedList<>();
		qu.add(new Node(x, y));
		countmap[x][y] = 0;
		while (!qu.isEmpty()) {
			Node n = qu.poll();
			int noX = n.x;
			int noY = n.y;

			while(map[noX-1][noY] != 0) {
				if(countmap[noX-1][noY] == -1) {
					qu.add(new Node(noX - 1, noY));
					countmap[noX-1][noY] = countmap[n.x][n.y] + 1;
				}
				noX--;
			}

			noX = n.x;
			noY = n.y;
			while(map[noX+1][noY] != 0) {
				if(countmap[noX+1][noY] == -1) {
					qu.add(new Node(noX+1, noY));
					countmap[noX+1][noY] = countmap[n.x][n.y] + 1;
				}
				noX++;
			}
			
			noX = n.x;
			noY = n.y;
			while(map[noX][noY-1] != 0) {
				if(countmap[noX][noY-1] == -1) {
					qu.add(new Node(noX, noY-1));
					countmap[noX][noY-1] = countmap[n.x][n.y] + 1;
				}
				noY--;
			}
			
			noX = n.x;
			noY = n.y;
			while(map[noX][noY+1] != 0) {
				if(countmap[noX][noY+1] == -1) {
					qu.add(new Node(noX , noY+1));
					countmap[noX][noY+1] = countmap[n.x][n.y] + 1;
				}
				noY++;
			}
			

		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] wh = br.readLine().split(" ");
		w = Integer.parseInt(wh[1]);
		h = Integer.parseInt(wh[0]);
		map = new int[w + 2][h + 2];
		countmap = new int[w + 2][h + 2];
		
		for (int i = 0; i <= w+1; i++) {
			for (int j = 0; j <= h+1; j++) {
				for(int k = 0; k <= 4; k++) {
					countmap[i][j] = -1;
				}
			}
		}

		startX = 0;
		startY = 0;
		endX = 0;
		endY = 0;
		for (int i = 1; i <= w; i++) {
			String[] s = br.readLine().split("");
			for (int j = 1; j <= h; j++) {
				switch (s[j - 1]) {
				case "*":
					map[i][j] = 0;
					break;
				case ".":
					map[i][j] = 1;
					break;
				case "C":
					map[i][j] = 2;
					
					if(endX != 0 && endY != 0) {
						startX = i;
						startY = j;
						continue;
					}
					endX = i;
					endY = j;
					break;
				}
			}
		}
		bfs(startX, startY);
		System.out.println(countmap[endX][endY]-1);
	}
}
