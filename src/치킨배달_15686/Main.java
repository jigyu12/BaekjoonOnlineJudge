package 치킨배달_15686;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	private static int n;
	private static int m;
	private static int cnt;
	private static int min;
	private static int[][] map;
	private static ArrayList<Node> ar;
	private static int or[];
	
	static class Node {
		int x;
		int y;

		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	public static int order(int a, int b, int sum) {
		if(sum == a) {
			distance(or);
			return 0;
		}
		for(int i = b; i < cnt; i++) {
			or[i] = 1;
			order(a,i+1,sum+1);
			or[i] = 0;

		}
		return 0;
	}

	public static int distance(int[] arr) {		
		
		int sum = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					int mind = n+n;
					for (int k = 0; k < arr.length; k++) {
						if(arr[k] == 1) {
							Node n = ar.get(k);
							int z = Math.abs(i - n.x) + Math.abs(j - n.y);
							
							if(mind > z) {
								mind = z;
							}
						}
					}
					sum += mind;
				}
			}
		}
		
		if (min > sum) {
			min = sum;
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][n];
		cnt = 0;
		min = 100000;
		ar = new ArrayList<Node>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				int as = sc.nextInt();
				if (as == 2) {
					cnt++;
					Node n = new Node(i, j);
					ar.add(n);
				}
				else {
					map[i][j] = as;
				}
			}
		}
		or = new int[cnt];
		for(int i = 1; i <= m; i++) {
			order(i,0,0);
		}
		
		System.out.println(min);
	}
}