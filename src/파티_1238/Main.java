package ÆÄÆ¼_1238;

import java.util.Scanner;

public class Main {
	
	private static int[][] map;
	private static int[] dist;
	private static boolean[] visited;
	private static int n;
	
	public static void dijkstra(int start) {
		for(int i = 0; i < n; i++) {
			dist[i] = 987654321;
			visited[i] = false;
		}
		dist[start] = 0;
		for(int i = 0; i < n; i++) {
			int mincost = 987654321;
			int minvertex = -1;
			for(int j = 0; j < n; j++) {
				if(!visited[j] && mincost > dist[j]) {
					mincost = dist[j];
					minvertex = j;
				}
			}
			visited[minvertex] = true;
			for(int j = 0; j < n; j++) {
				if(dist[j] > dist[minvertex] + map[minvertex][j]) {
					dist[j] = dist[minvertex] + map[minvertex][j];
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		int x = sc.nextInt() - 1;
		map = new int[n][n];
		dist = new int[n];
		visited = new boolean[n];
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				map[i][j] = 987654321;
			}
		}
		
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			map[a-1][b-1] = w;
		}
		dijkstra(x);
		int[] one = new int [n];
		for(int i = 0; i < n; i++) {
			one[i] = dist[i];
		}
		int[] two = new int[n];
		int k = 0;
		for(int i = 0; i < n; i++) {
			dijkstra(i);
			two[k++] = dist[x];
		}
		int ans = 0;
		for(int i = 0; i < n; i++) {
			if(ans < one[i]+two[i]) {
				ans = one[i]+two[i];
			}
		}
		System.out.println(ans);
	}
}
