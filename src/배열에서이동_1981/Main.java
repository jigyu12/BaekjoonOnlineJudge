package 배열에서이동_1981;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int min;
		int max;
		
		public Node(int x, int y, int min, int max) {
			this.x = x;
			this.y = y;
			this.min = min;
			this.max = max;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", min=" + min + ", max=" + max + "]";
		}

		@Override
		public int compareTo(Node o) {
			return (this.max - this.min) - (o.max - o.min);
		}
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int[][] map = new int[num+2][num+2];
		
		for(int i = 0; i < num+2; i++) {
			Arrays.fill(map[i], -1);
		}
		
		for(int i = 1; i <= num; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 1; j <= num; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		
		Queue<Node> pq = new LinkedList<Node>();
		pq.add(new Node(1,1,201,0));
		int ans = 201;
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int x = n.x;
			int y = n.y;
			int min = n.min;
			int max = n.max;
			int d = max - min;

			if(d > ans) {
				continue;
			}
			
			if(x == num && y == num) {
				if(d < ans) {
					ans = d;
				}
				continue;
			}
			
			if(map[x-1][y] > -1) {
				int min1 = min < map[x-1][y] ? min : map[x-1][y];
				int max1 = max > map[x-1][y] ? max : map[x-1][y];
				pq.add(new Node(x-1,y,min1,max1));
			}
			if(map[x+1][y] > -1) {
				int min1 = min < map[x+1][y] ? min : map[x+1][y];
				int max1 = max > map[x+1][y] ? max : map[x-+1][y];
				pq.add(new Node(x+1,y,min1,max1));
			}
			if(map[x][y-1] > -1) {
				int min1 = min < map[x][y-1] ? min : map[x][y-1];
				int max1 = max > map[x][y-1] ? max : map[x][y-1];
				pq.add(new Node(x,y-1,min1,max1));
			}
			if(map[x][y+1] > -1) {
				int min1 = min < map[x][y+1] ? min : map[x][y+1];
				int max1 = max > map[x][y+1] ? max : map[x][y+1];
				pq.add(new Node(x,y+1,min1,max1));
			}
		}
		System.out.println(ans);
	}

}
