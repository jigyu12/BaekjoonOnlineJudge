package Å°¼ø¼­_2458;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	private static ArrayList<Integer>[] ar;
	private static ArrayList<Integer>[] comp;
	private static int[] upstart;
	private static int[] downstart;
	private static int[] sibling;
	private static int[] parent;
	
	private static void dfsup(int a,int start) {
		
		upstart[a] = start;
		for(int i = 0; i < ar[a].size(); i++) {
			if(upstart[ar[a].get(i)] != start) {
				sibling[ar[a].get(i)]++;
				dfsup(ar[a].get(i),start);
			}
		}
	}
	
	private static void dfsdown(int a,int start) {
		
		downstart[a] = start;
		for(int i = 0; i < comp[a].size(); i++) {
			if(downstart[comp[a].get(i)] != start) {
				parent[comp[a].get(i)]++;
				dfsdown(comp[a].get(i),start);
			}
		}
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		try {
			String[] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);

			ar = new ArrayList[n + 1];
			comp = new ArrayList[n + 1];
			sibling = new int[n + 1];
			parent = new int[n + 1];
			upstart = new int[n+1];
			downstart = new int[n+1];
			for (int i = 0; i < n + 1; i++) {
				ar[i] = new ArrayList<Integer>();
				comp[i] = new ArrayList<Integer>();

			}

			for (int i = 0; i < m; i++) {
				String[] s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);

				ar[a].add(b);
				comp[b].add(a);
			}
			
			for (int i = 1; i < n + 1; i++) {
				dfsup(i,i);
				dfsdown(i,i);
			}
			int ans = 0;
			for (int i = 1; i < n + 1; i++) {
				if(parent[i] + sibling[i] == n -1) {
					ans++;
				}
			}
			bw.write(ans+"\n");
			bw.flush();
			for (int i = 1; i < n + 1; i++) {
				System.out.print(sibling[i] + " ");
			}
			System.out.println();
			for (int i = 1; i < n + 1; i++) {
				System.out.print(parent[i] + " ");
			}
			System.out.println();

		} catch (IOException e) {
		}
	}
}