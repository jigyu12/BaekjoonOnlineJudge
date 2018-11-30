package ¾Ë°í½ºÆÌ_1261;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n][m];
		int[] dist = new int[m];
		boolean[] visited = new boolean[m];
		for(int i = 0; i < n; i++) {
			String[] s = sc.next().split("");
			for(int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		for(int i = 0; i < m; i++) {
			dist[i] = 987654321;
		}
		dist[0] = 0;
		
		for(int i = 0; i < n; i++) {
			int mincost = 987654321;
			int minvertex = -1;
			for(int j = 0; j < m; j++) {
				if(!visited[j] && mincost > dist[j]) {
					mincost = dist[j];
					minvertex = j;
				}
			}
			visited[minvertex] = true;
			for(int j = 0; j <m; j++) {
				if(dist[j] + 1 >= dist[minvertex] + map[minvertex][j]) {
					dist[j] = dist[minvertex] + map[minvertex][j];
				}
			}
			for(int j = 0; j <m; j++) {
				System.out.print(dist[j] + " ");
			}
			System.out.println();
		}
		System.out.println(dist[m-1]);
	}
}
