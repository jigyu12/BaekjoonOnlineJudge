package 최단경로_1573;

import java.util.Scanner;

public class Main {
	
	private static int[] parent;
	
	public static void makeset(int a) {
		parent[a] = a;
	}
	
	public static int findset(int a) {
		if(parent[a] == a) {
			return a;
		}
		return findset(parent[a]);
	}
	
	public static void unionset(int p, int s) {
		parent[s] = parent[findset(p)];
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		parent = new int[v+1];
		for(int i = 0; i < v; i++) {
			makeset(i);
		}
		int[][] map = new int[v][v];
		for(int i = 0; i < v; i++) {
			for(int j = 0; j < v; j++) {
				map[i][j] = 987654321;
			}
		}
		int e = sc.nextInt();
		int start = sc.nextInt();
		for(int i = 0; i < e; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			unionset(b,a);
			map[a-1][b-1] = w;
		}
		for(int i = 0; i < v+1; i++) {
			System.out.println(parent[i]);
		}
	}

}
