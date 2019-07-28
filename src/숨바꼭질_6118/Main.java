package 숨바꼭질_6118;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	
	private static int[] dist;
	private static boolean[] visited;
	private static int n;
	private static ArrayList<LinkedList<Integer>> ar;
	
	public static void dijkstra(int start) {
		dist[start] = 0;
		for(int i = 0; i < n; i++) {
			int minvertex = 0;
			int mincost = 987654321;
			for(int j = 0; j < n; j++) {
				if(!visited[j] && dist[j] < mincost) {
					mincost = dist[j];
					minvertex = j;
				}
			}
			visited[minvertex] = true;
			int[] map = new int[n];
			
			for(int j = 0; j < n; j++) {
				map[j] = 987654321;
			}
			
			for(int j = 0; j < ar.get(minvertex).size(); j++) {
				map[ar.get(minvertex).get(j)] = 1;
			}
			map[minvertex] = 0;
			for(int j = 0; j < n; j++) {
				if(dist[j] > dist[minvertex] + map[j]) {
					dist[j] = dist[minvertex] + map[j];
				}
			}
			for(int j = 0; j < n; j++) {
				System.out.print(dist[j] + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int m = sc.nextInt();
		dist = new int[n];
		visited = new boolean[n];
		ar = new ArrayList<LinkedList<Integer>>();
		for(int i = 0; i < n; i++) {
			ar.add(new LinkedList<Integer>());
		}
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			ar.get(a-1).add(b-1);
			ar.get(b-1).add(a-1);
		}
		
		for(int i = 0; i < n; i++) {
			dist[i] = 987654321;
		}
		dijkstra(0);
		int max = -1;
		int vertex = -1;
		for(int i = n-1; i >= 0; i--) {
			if(dist[i] >= max) {
				max = dist[i];
				vertex = i;
			}
		}
		int count = 0;
		for(int i = 0; i < n; i++) {
			if(dist[i] == max) {
				count++;
			}
		}

		System.out.println(vertex+1 + " " + max + " " + count);
	}
}
