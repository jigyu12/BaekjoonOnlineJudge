package 경찰차_2618;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
	
	static Node n1, n2;
	static int n,w;
	static int[][] par,dp;
	static Node[] list1, list2;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		n = Integer.parseInt(br.readLine());
		w = Integer.parseInt(br.readLine());
		
		list1 = new Node[w+1];
		list2 = new Node[w+1];
		par = new int[w+1][w+1];
		dp = new int[w+1][w+1];
		
		
		list1[0] = new Node(1,1);
		list2[0] = new Node(n,n);
		
		for(int i = 1 ; i <= w; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			list1[i] = new Node(a,b);
			list2[i] = new Node(a,b);
		}

		
		
		bw.write(solve(0,0)+"\n");
		
		int a = 0, b = 0;
		while (Math.max(a, b) < w) {
			bw.write(par[a][b]+"\n");
			if(par[a][b] == 2) {
				b = Math.max(a, b) + 1;
			}
			else {
				a = Math.max(a, b) + 1;
			}
		}
		
		bw.flush();
	}
	
	static int solve(int p1, int p2) {
		if(p1 == w || p2 == w) {
			return 0;
		}
		
		if(dp[p1][p2] != 0) {
			return dp[p1][p2];
		}
		
		int next = Math.max(p1, p2) + 1;

		int np1 = solve(next, p2) + Math.abs(list1[next].x-list1[p1].x) + Math.abs(list1[next].y-list1[p1].y);
		int np2 = solve(p1, next) + Math.abs(list2[next].x-list2[p2].x) + Math.abs(list2[next].y-list2[p2].y);
		
		if(np1 > np2) {
			par[p1][p2] = 2;
			dp[p1][p2] = np2;
		}
		else {
			par[p1][p2] = 1;
			dp[p1][p2] = np1;
		}
		
		return dp[p1][p2];
	}

}

