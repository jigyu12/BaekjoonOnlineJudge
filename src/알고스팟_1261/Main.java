package 알고스팟_1261;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

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

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] map = new int[n][m];
		int[][] dist = new int[n][m];
		boolean[][] visited = new boolean[n][m];
		for(int i = 0; i < n; i++) {
			String[] s = sc.next().split("");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				dist[i][j] = 987654321;
			}
		}
		
		Queue<Node> qu = new LinkedList<Node>();
		dist[0][0] = 0;
		Node no = new Node(0,0);
		qu.add(no);
		while(!qu.isEmpty()) {
			Node nx = qu.poll();
			visited[nx.x][nx.y] = true;
			if(nx.x >= 1 && dist[nx.x - 1][nx.y] > dist[nx.x][nx.y] + map[nx.x-1][nx.y]) {
				Node nn = new Node(nx.x - 1,nx.y);
				qu.add(nn);
				visited[nx.x-1][nx.y] = true;
				dist[nx.x - 1][nx.y] = dist[nx.x][nx.y] + map[nx.x-1][nx.y];
			}
			if(nx.x <= n-2 && dist[nx.x+1][nx.y] > dist[nx.x][nx.y] + map[nx.x+1][nx.y]) {
				Node nn = new Node(nx.x+1,nx.y);
				qu.add(nn);
				visited[nx.x+1][nx.y] = true;
				dist[nx.x+1][nx.y] = dist[nx.x][nx.y] + map[nx.x+1][nx.y];
			}
			if(nx.y >= 1 && dist[nx.x][nx.y-1] > dist[nx.x][nx.y] + map[nx.x][nx.y-1]) {
				Node nn = new Node(nx.x,nx.y-1);
				qu.add(nn);
				visited[nx.x][nx.y-1] = true;
				dist[nx.x][nx.y-1] = dist[nx.x][nx.y] + map[nx.x][nx.y-1];
			}
			if(nx.y <= m-2 && dist[nx.x][nx.y+1] > dist[nx.x][nx.y] + map[nx.x][nx.y+1]) {
				Node nn = new Node(nx.x,nx.y+1);
				qu.add(nn);
				visited[nx.x][nx.y+1] = true;
				dist[nx.x][nx.y+1] = dist[nx.x][nx.y] + map[nx.x][nx.y+1];
			}
		}
		System.out.println(dist[n-1][m-1]);
	}
}
