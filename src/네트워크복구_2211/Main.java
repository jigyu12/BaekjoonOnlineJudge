package 네트워크복구_2211;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	static class Node implements Comparable<Node>{
		int p;
		int s;
		int w;
		
		public Node(int p, int s, int w) {
			this.p = p;
			this.s = s;
			this.w = w;
		}

		@Override
		public int compareTo(Node no) {
			if(this.w < no.w) {
				return -1;
			}
			else if(this.w > no.w) {
				return 1;
			}
			return 0;
		}
		
	}
	
	public static void makeset(int s) {
		parent[s] = s;
	}
	
	public static int findset(int s) {
		if(parent[s] == s) {
			return s;
		}
		return findset(parent[s]);
	}
	
	public static void unionset(int p, int s) {
		parent[findset(s)] = parent[p];
	}
	
	private static Node[] ar;
	private static int[] parent;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ar = new Node[m];
		parent = new int[n];
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			Node no = new Node(a,b,w);
			ar[i] = no;
		}
		
		Arrays.sort(ar);
		for(int i = 0; i < n; i++) {
			makeset(i);
		}
		int count = 0;
		System.out.println(n-1);
		for(int i = 0; i < m; i++) {
			int x = ar[i].p-1;
			int y = ar[i].s-1;
			if(count == n-1) {
				break;
			}
			if(findset(x) == findset(y)){
				continue;
			}
			unionset(x,y);
			System.out.println((x+1)+ " "+(y+1));
		}
	}
}
