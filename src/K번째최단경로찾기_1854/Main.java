package K번째최단경로찾기_1854;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	static class Node implements Comparable<Node>{
		int end;
		int cost;
		
		public Node(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int[] dist;
	static ArrayList<Node>[] ar;
	static PriorityQueue<Node> pq;
	static PriorityQueue<Integer>[] path;
	static int k;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		int v = Integer.parseInt(s[0]);
		int e = Integer.parseInt(s[1]);
		k = Integer.parseInt(s[2]);
		pq = new PriorityQueue<>();
		dist = new int[v+1];
		ar = new ArrayList[v+1];
		path = new PriorityQueue[v+1];
		
		Arrays.fill(dist, 987654321);
		
		for(int i = 0; i <= v; i++) {
			ar[i] = new ArrayList<>();
			path[i] = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
		}
		
		for(int i = 0; i < e; i++) {
			String[] ss = br.readLine().split(" ");
			int a = Integer.parseInt(ss[0]);
			int b = Integer.parseInt(ss[1]);
			int w = Integer.parseInt(ss[2]);
			ar[a].add(new Node(b,w));
		}
		path[1].add(0);
		
		dijkstra(1);

	
		
		for(int i = 1; i <= v; i++) {
			int size = path[i].size();
			if(size < k) {
				bw.write("-1\n");
			}
			else {
				bw.write(path[i].poll()+"\n");
			}
		}
		bw.flush();
	}
	
	private static void dijkstra(int start) {
		dist[start] = 0;
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			int nend = n.end;
			for(int i = 0; i < ar[nend].size(); i++) {
				Node nn = ar[nend].get(i);
				int end = nn.end;
				int nc = n.cost + nn.cost;

				if(path[end].size() < k) {
					path[end].add(nc);
					pq.add(new Node(end,nc));
				}
				
				else if(path[end].peek() > nc){
					path[end].poll();
					path[end].add(nc);
					pq.add(new Node(end,nc));
				}
			
			}
		}
	}
}