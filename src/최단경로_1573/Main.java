package 최단경로_1573;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
		public String toString() {
			return "Node [end=" + end + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}

	}
	
	private static int[] dist;
	private static ArrayList<Node>[] ar;
	private static PriorityQueue<Node> pq;
	
	public static void dijkstra(int start) {
		dist[start] = 0;
		Node no = new Node(start, dist[start]);
		pq.add(no);
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			for (int i = 0; i < ar[n.end].size(); i++) {
				Node nn = ar[n.end].get(i);
				if (dist[nn.end] > n.cost + nn.cost) {
					dist[nn.end] = n.cost + nn.cost;
					pq.add(new Node(nn.end, dist[nn.end]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		int v = Integer.parseInt(s[0]);
		int e = Integer.parseInt(s[1]);
		int start = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>();
		dist = new int[v+1];
		ar = new ArrayList[v+1];
		Arrays.fill(dist, 987654321);
		for(int i = 0; i <= v; i++) {
			ar[i] = new ArrayList<>();
		}
		for(int i = 0; i < e; i++) {
			String[] ss = br.readLine().split(" ");
			int a = Integer.parseInt(ss[0]);
			int b = Integer.parseInt(ss[1]);
			int w = Integer.parseInt(ss[2]);
			ar[a].add(new Node(b,w));
		}
		dijkstra(start);
		for(int i = 1; i <= v; i++) {
			if(dist[i] < 987654321) {
				bw.write(dist[i]+"\n");
			}
			else {
				bw.write("INF\n");
			}
		}
		bw.flush();
	}
}
