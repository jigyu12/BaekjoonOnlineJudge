package 벽부수고이동하기2;

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
		int brick;
		int count;
		
		public Node(int x, int y, int brick, int count) {
			this.x = x;
			this.y = y;
			this.brick = brick;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", brick=" + brick + ", count=" + count + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nmk = br.readLine().split(" ");
		int n = Integer.parseInt(nmk[0]);
		int m = Integer.parseInt(nmk[1]);
		int k = Integer.parseInt(nmk[2]);
		
		int[][] map = new int[n+2][m+2];
		boolean[][][] visited = new boolean[k+1][n+2][m+2];
		Queue<Node> qu = new LinkedList<>();
		int ans = 1000000;
		
		Arrays.fill(map[0], 2);
		Arrays.fill(map[n+1], 2);
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split("");
			Arrays.fill(map[i], 2);
			for(int j = 1; j <= m; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
			}
		}
		
		qu.add(new Node(1,1,0,1));
		visited[0][1][1] = true;
		
		while(!qu.isEmpty()) {
			Node no = qu.poll();
			int nx = no.x;
			int ny = no.y;
			int nb = no.brick;
			int nc = no.count;
			
			if(nx == n && ny == m) {
				if(ans > nc) {
					ans = nc;
				}
				continue;
			}
			
			if(ans <= nc) {
				continue;
			}
			
			if(!visited[nb][nx-1][ny] && map[nx-1][ny] == 0) {
				visited[nb][nx-1][ny] = true;
				qu.add(new Node(nx-1,ny,nb,nc+1));
			}
			if(!visited[nb][nx+1][ny] && map[nx+1][ny] == 0) {
				visited[nb][nx+1][ny] = true;
				qu.add(new Node(nx+1,ny,nb,nc+1));
			}
			if(!visited[nb][nx][ny-1] && map[nx][ny-1] == 0) {
				visited[nb][nx][ny-1] = true;
				qu.add(new Node(nx,ny-1,nb,nc+1));
			}
			if(!visited[nb][nx][ny+1] && map[nx][ny+1] == 0) {
				visited[nb][nx][ny+1] = true;
				qu.add(new Node(nx,ny+1,nb,nc+1));
			}
			
			if(nb < k && !visited[nb+1][nx-1][ny] && map[nx-1][ny] == 1) {
				visited[nb+1][nx-1][ny] = true;
				qu.add(new Node(nx-1,ny,nb+1,nc+1));
			}
			if(nb < k && !visited[nb+1][nx+1][ny] && map[nx+1][ny] == 1) {
				visited[nb+1][nx+1][ny] = true;
				qu.add(new Node(nx+1,ny,nb+1,nc+1));
			}
			if(nb < k && !visited[nb+1][nx][ny-1] && map[nx][ny-1] == 1) {
				visited[nb+1][nx][ny-1] = true;
				qu.add(new Node(nx,ny-1,nb+1,nc+1));
			}
			if(nb < k && !visited[nb+1][nx][ny+1] && map[nx][ny+1] == 1) {
				visited[nb+1][nx][ny+1] = true;
				qu.add(new Node(nx,ny+1,nb+1,nc+1));
			}
		}
		if(ans == 1000000) {
			System.out.println("-1");
		}
		else {
			System.out.println(ans);
		}
	}
}
