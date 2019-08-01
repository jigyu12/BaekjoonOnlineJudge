package 줄세우기_2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node implements Comparable<Integer>{
		int start;
		int end;

		public Node(int start, int end) {
			this.start = start;
			this.end = end;
		}



		@Override
		public int compareTo(Integer arg0) {

			return 0;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		ArrayList<Integer>[] ar = new ArrayList[n];
		for(int i = 0; i < n; i++) {
			ar[i] = new ArrayList<>();
		}
		Queue<Integer> qu = new LinkedList<Integer>();
		int indegree[] = new int[n];
		for(int i = 0; i < m; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			indegree[b-1]++;
			ar[a-1].add(b-1);
		}
		int cnt = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(indegree[j] == 0) {
					qu.add(j);
				}
			}
			
			while(!qu.isEmpty()) {
				int a = qu.poll();
				for(int k = 0; k < ar[a].size(); k++) {
					indegree[ar[a].get(k)]--;
					
				}
				indegree[a] = -1;
				System.out.print((a+1) + " ");
			}
		}
		
	}
}
