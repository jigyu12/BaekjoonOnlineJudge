package 오민식의고민_1219;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static class Edge {
		int start;
		int end;
		int cost;
		
		public Edge(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Edge [start=" + start + ", end=" + end + ", cost=" + cost + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nsem = br.readLine().split(" ");
		
		int n = Integer.parseInt(nsem[0]);
		int start = Integer.parseInt(nsem[1]);
		int end = Integer.parseInt(nsem[2]);
		int m = Integer.parseInt(nsem[3]);
		
		int money[] = new int[n];
		long earnm[] = new long[n];
		Edge[] edge = new Edge[m];

		for(int i = 0; i < m; i++) {
			String[] ss = br.readLine().split(" ");
			int s = Integer.parseInt(ss[0]);
			int e = Integer.parseInt(ss[1]);
			int c = Integer.parseInt(ss[2]);
			edge[i] = new Edge(s,e,c);
		}
		
		String[] ss = br.readLine().split(" ");
		
		for(int i = 0; i < n; i++) {
			money[i] = Integer.parseInt(ss[i]);
			earnm[i] = Long.MIN_VALUE;
		}
		
		earnm[start] = money[start];
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(earnm[edge[j].start] != Long.MIN_VALUE &&
						earnm[edge[j].end] < earnm[edge[j].start] + (money[edge[j].end] - edge[j].cost)) {
					earnm[edge[j].end] = earnm[edge[j].start] + (money[edge[j].end] - edge[j].cost);
				}
			}
		}
		
		long prev = earnm[end];
		boolean isGee = false;
		for(int j = 0; j < m; j++) {
			if(earnm[edge[j].start] != Long.MIN_VALUE &&
					earnm[edge[j].end] < earnm[edge[j].start] + (money[edge[j].end] - edge[j].cost)) {
				earnm[edge[j].end] = earnm[edge[j].start] + (money[edge[j].end] - edge[j].cost);
				isGee = true;
			}
		}
		
		long cur = earnm[end];
		if(earnm[end] == Long.MIN_VALUE) {
			System.out.println("gg");
		}
		
		else {
			if(prev < cur && isGee) {
				System.out.println("Gee");
			}
			else {
				System.out.println(earnm[end]);
			}
		}
	}
}
