package 최단경로_1573;

import java.util.Scanner;

public class Main {
	
	private static int[] dist;
	private static int[][] map;
	private static boolean[] visited;
	private static int v;
	
	public static void dijkstra(int start) {
		for(int i = 0; i < v; i++) {
			dist[i] = 9876541;
			visited[i] = false;
		}
		dist[start] = 0;
		for(int i = 0; i < v; i++) {
			int mincost = 987654;
			int minvertex = -1;
			for(int j = 0; j < v; j++) {
				if(!visited[j] && mincost > dist[j]) {
					mincost = dist[j];
					minvertex = j;
				}
			}
			if(minvertex == -1) {
				continue;
			}
			visited[minvertex] = true;
			for(int j = 0; j < v; j++) {
				if(dist[j] > dist[minvertex] + map[minvertex][j]) {
					dist[j] = dist[minvertex] + map[minvertex][j];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		int e = sc.nextInt();
		int start = sc.nextInt() - 1;
		dist = new int[v];
		visited = new boolean[v];
		map = new int[v][v];
		for(int i = 0; i < v; i++) {
			for(int j = 0; j < v; j++) {
				map[i][j] = 987654;
			}
		}
		for(int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			map[a-1][b-1] = w;
		}
		dijkstra(start);
		for(int i = 0; i < v; i++) {
			if(i == start) {
				System.out.println("0");
				continue;
			}
			if(dist[i] < 987654) {
				System.out.println(dist[i]);
			}
			else {
				System.out.println("INF");
			}
		}
	}
}
