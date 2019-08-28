package 도로포장_1162;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	
	static int n;
	static int m;
	static int k;
	
	static class Edge implements Comparable<Edge>{
		int n;
		long c;
		int pave;

		public Edge(int n, long c, int pave) {
			this.n = n;
			this.c = c;
			this.pave = pave;
		}

		@Override
		public int compareTo(Edge o) {
			if(this.c < o.c) {
				return -1;
			}
			else if(this.c > o.c) {
				return 1;
			}
			return 0;
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nmk = br.readLine().split(" ");
		n = Integer.parseInt(nmk[0]);
		m = Integer.parseInt(nmk[1]);
		k = Integer.parseInt(nmk[2]);
	
		ArrayList<Edge>[] ar = new ArrayList[n+1];
		
		for(int i = 0 ; i <= n; i++) {
			ar[i] = new ArrayList<>();
		}
	
		
		for(int i = 0 ; i < m; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			
			ar[a].add(new Edge(b,c,0));
			ar[b].add(new Edge(a,c,0));
		}
		
		long [][] dist = new long[n+1][k+1];

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		for(int i = 0; i < n+1;i++) {
			Arrays.fill(dist[i], Long.MAX_VALUE);
		}
		
		
		dist[1][0] = 0;
		pq.add(new Edge(1,0,0));

		while(!pq.isEmpty()) {
			Edge p = pq.poll();
			int pn = p.n;
			long pc = p.c;
			int pp = p.pave;
			
			if(dist[pn][pp] != pc) {
				continue;
			}

			for(int i = 0; i < ar[pn].size(); i++) {
				Edge s = ar[pn].get(i);
				int sn = s.n;
				long sc = s.c;
				
				if(pp + 1 <= k && dist[sn][pp+1] > pc) {
					dist[sn][pp+1] = pc;
					pq.add(new Edge(sn,dist[sn][pp+1],pp+1));
				}
				
				if(dist[sn][pp] > pc + sc) {
					dist[sn][pp] = pc + sc;
					pq.add(new Edge(sn,pc+sc,pp));
				}				

			}
//			for(int i = 0; i <= n; i++) {
//				System.out.print(dist[i] + " ");
//			}
//			System.out.println();

		}
		
		long ans = Long.MAX_VALUE;
		for(int i = 0; i <= k; i++) {
			ans = ans < dist[n][i] ? ans : dist[n][i]; 
		}
		
		System.out.println(ans);
	}

}
