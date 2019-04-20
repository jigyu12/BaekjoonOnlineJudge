package Ä³½½µðÆæ½º_17135;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	static class Enemy implements Comparable<Enemy>{
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

		@Override
		public int compareTo(Enemy o) {
			if(this.dist == o.dist) {
				return this.y - o.y;
			}
			return this.dist - o.dist;
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
	
			ArrayList<Enemy> ar1 = new ArrayList<>();
			ArrayList<Enemy> ar2 = new ArrayList<>();
			ArrayList<Enemy> ar3 = new ArrayList<>();
			
			int min1 = d;
			int min2 = d;
			int min3 = d;
			for(int k = 0; k < m; k++) {
				for(int j = arrower - 1; j >= 0; j--) {
					int cal1 = (Math.abs(arrower - j) + Math.abs(one - k));
					if(map[j][k] && !attacked[j][k] && min1 >= cal1) {
						min1 = cal1;
						ar1.add(new Enemy(j,k,cal1));
					}
					int cal2 = (Math.abs(arrower - j) + Math.abs(two - k));
					if(map[j][k] && !attacked[j][k] && min2 >= cal2) {
						min2 = cal2;
						ar2.add(new Enemy(j,k,cal2));
					}
					int cal3 = (Math.abs(arrower - j) + Math.abs(three - k));
					if(map[j][k] && !attacked[j][k] && min3 >= cal3) {
						min3 = cal3;
						ar3.add(new Enemy(j,k,cal3));
					}
				}
			}
			
			Collections.sort(ar1);
			Collections.sort(ar2);
			Collections.sort(ar3);
			
			if(!ar1.isEmpty()) {
				Enemy e = ar1.get(0);
				if(!attacked[e.x][e.y]) {
					success++;
					attacked[e.x][e.y] = true;
				}
			}
			
			if(!ar2.isEmpty()) {
				Enemy e = ar2.get(0);
				if(!attacked[e.x][e.y]) {
					success++;
					attacked[e.x][e.y] = true;
				}
			}
			
			if(!ar3.isEmpty()) {
				Enemy e = ar3.get(0);
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
