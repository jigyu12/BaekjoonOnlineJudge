package 인구이동_16234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node{
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
	
	private static int[][] map;
	private static boolean[][] visited;
	private static int l;
	private static int r;
	
	private static void union(int x, int y) {
		Queue<Node> uni = new LinkedList<>();
		Queue<Node> div = new LinkedList<>();
		
		uni.add(new Node(x,y));
		visited[x][y] = true;
		
		int sum = 0;
		while(!uni.isEmpty()) {
			
			Node n = uni.poll();
			div.add(n);
			
			int nx = n.x;
			int ny = n.y;
			sum += map[nx][ny];
			
			if(!visited[nx-1][ny] && l <= Math.abs(map[nx-1][ny] - map[nx][ny]) && Math.abs(map[nx-1][ny] - map[nx][ny]) <= r) {
				uni.add(new Node(nx-1,ny));
				visited[nx-1][ny] = true;
			}
			
			if(!visited[nx+1][ny] && l <= Math.abs(map[nx+1][ny] - map[nx][ny]) && Math.abs(map[nx+1][ny] - map[nx][ny]) <= r) {
				uni.add(new Node(nx+1,ny));
				visited[nx+1][ny] = true;
			}
			
			if(!visited[nx][ny-1] && l <= Math.abs(map[nx][ny-1] - map[nx][ny]) && Math.abs(map[nx][ny-1] - map[nx][ny]) <= r) {
				uni.add(new Node(nx,ny-1));
				visited[nx][ny-1] = true;
			}
			
			if(!visited[nx][ny+1] && l <= Math.abs(map[nx][ny+1] - map[nx][ny]) && Math.abs(map[nx][ny+1] - map[nx][ny]) <= r) {
				uni.add(new Node(nx,ny+1));
				visited[nx][ny+1] = true;
			}
		}
		
		sum /= div.size();
		
		while(!div.isEmpty()) {
			Node n = div.poll();
			
			int nx = n.x;
			int ny = n.y;
			
			map[nx][ny] = sum;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nlr = br.readLine().split(" ");
		int n = Integer.parseInt(nlr[0]);
		l = Integer.parseInt(nlr[1]);
		r = Integer.parseInt(nlr[2]);
		
		map = new int[n+2][n+2];
		Arrays.fill(map[0],10000);
		Arrays.fill(map[n+1],10000);
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split(" ");
			Arrays.fill(map[i], 10000);
			for(int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		
		int ans = 0;
		
		while(ans <= 2000) {
			visited = new boolean[n+2][n+2];
			int count = 0;
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					if(!visited[i][j]) {
						count++;
						union(i,j);
					}
				}
			}
			if(count == n * n) {
				break;
			}
			ans++;
		}
		System.out.println(ans);
	}
}
