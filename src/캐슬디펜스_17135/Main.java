package Ä³½½µðÆæ½º_17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	static class Enemy{
		int x;
		int y;
		int dist;
		
		public Enemy(int x, int y, int dist) {
			this.x = x;
			this.y = y;
			this.dist = dist;
		}

		@Override
		public String toString() {
			return "Enemy [x=" + x + ", y=" + y + ", dist=" + dist + "]";
		}
		
	}
	
	private static int n;
	private static int m;
	private static int d;
	private static boolean[][] attacked;
	private static int enemycnt;
	private static boolean map[][];
	
	private static int playgame(int one, int two, int three) {
		
		int arrower = n;
		int count = 0;
		
		for(int i = 0; i < n; i++) {
			int success = 0;
	
			PriorityQueue<Enemy> pq1 = new PriorityQueue<>(new Comparator<Enemy>() {
				@Override
				public int compare(Enemy o1, Enemy o2) {
					if(o1.dist == o2.dist) {
						return o1.y - o2.y;
					}
					return o1.dist - o2.dist;
				}
			});
			
			PriorityQueue<Enemy> pq2 = new PriorityQueue<>(new Comparator<Enemy>() {
				@Override
				public int compare(Enemy o1, Enemy o2) {
					if(o1.dist == o2.dist) {
						return o1.y - o2.y;
					}
					return o1.dist - o2.dist;
				}
			});
			
			PriorityQueue<Enemy> pq3 = new PriorityQueue<>(new Comparator<Enemy>() {
				@Override
				public int compare(Enemy o1, Enemy o2) {
					if(o1.dist == o2.dist) {
						return o1.y - o2.y;
					}
					return o1.dist - o2.dist;
				}
			});
			
			int min1 = d;
			for(int k = 0; k < m; k++) {
				for(int j = arrower - 1; j >= 0; j--) {
					int cal = (Math.abs(arrower - j) + Math.abs(one - k));
					if(map[j][k] && !attacked[j][k] && min1 >= cal) {
						min1 = cal;
						pq1.add(new Enemy(j,k,cal));
					}
				}
			}
			
			int min2 = d;
			for(int k = 0; k < m; k++) {
				for(int j = arrower - 1; j >= 0; j--) {
					int cal = (Math.abs(arrower - j) + Math.abs(two - k));
					if(map[j][k] && !attacked[j][k] && min2 >= cal) {
						min2 = cal;
						pq2.add(new Enemy(j,k,cal));
					}
				}
			}

			int min3 = d;
			for(int k = 0; k < m; k++) {
				for(int j = arrower - 1; j >= 0; j--) {
					int cal = (Math.abs(arrower - j) + Math.abs(three - k));
					if(map[j][k] && !attacked[j][k] && min3 >= cal) {
						min3 = cal;
						pq3.add(new Enemy(j,k,cal));
					}
				}
			}
			
			if(!pq1.isEmpty()) {
				Enemy e = pq1.poll();
				if(!attacked[e.x][e.y]) {
					success++;
					attacked[e.x][e.y] = true;
				}
			}
			
			if(!pq2.isEmpty()) {
				Enemy e = pq2.poll();
				if(!attacked[e.x][e.y]) {
					success++;
					attacked[e.x][e.y] = true;
				}
			}
			
			if(!pq3.isEmpty()) {
				Enemy e = pq3.poll();
				if(!attacked[e.x][e.y]) {
					success++;
					attacked[e.x][e.y] = true;
				}
			}
			
			count += success;
			
			if(count == enemycnt) {
				break;
			}
			arrower--;
		}
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nmd = br.readLine().split(" ");
		n = Integer.parseInt(nmd[0]);
		m = Integer.parseInt(nmd[1]);
		d = Integer.parseInt(nmd[2]);
		
		map = new boolean[n][m];
		enemycnt = 0;
		
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0 ; j < m; j++) {
				int a = Integer.parseInt(s[j]);
				if(a == 1) {
					map[i][j] = true;
					enemycnt++;
				}
			}
		}

		
		int ans = 0;
		for(int i = 0; i < m; i++) {
			for(int j = i+1; j < m; j++) {
				for(int k = j+1; k < m; k++) {
					attacked = new boolean[n][m];
					ans = Math.max(ans, playgame(i,j,k));
				}
			}
		}
		
		System.out.println(ans);
	}
}
