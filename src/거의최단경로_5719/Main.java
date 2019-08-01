package 거의최단경로_5719;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	
	static ArrayList<Integer>[] arD = new ArrayList[501];
	static ArrayList<Integer>[] arR = new ArrayList[501];
	static int[][] map = new int[501][501];
	static int end;
	static int[] dist = new int[501];
	static int[] parent = new int[501];
	static PriorityQueue<Node> pq = new PriorityQueue<>();

	static class Node implements Comparable<Node> {
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
		public int compareTo(Node arg0) {
			return this.cost - arg0.cost;
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i = 0; i < 501; i++) {
			arD[i] = new ArrayList<>();
			arR[i] = new ArrayList<>();
		}
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			if(n == 0 && m == 0) {
				break;
			}
			
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				arD[a].add(b);
				arR[b].add(a);
				map[a][b] = c;
			}
			
			Arrays.fill(dist, 987654321);

			int first = Dijkstra(s);
			pq.clear();
			
			Queue<Node> qu = new LinkedList<>();
			qu.add(new Node(end,0));
			while(!qu.isEmpty()) {
				Node no = qu.poll();
				
				int e = no.end;
				int c = no.cost;
				int size = arR[e].size();
				
				for(int i = 0; i < size; i++) {
					int son = arR[e].get(i);
					if(dist[son] + map[son][e] + c == first) {
						qu.add(new Node(son , map[son][e] + c));
						map[son][e] = 987654321;
					}
				}
			}
			
			Arrays.fill(dist, 987654321);
			int second = Dijkstra(s);
			
			bw.write(second+"\n");
			
			for(int i = 0; i <= n; i++) {
				arD[i].clear();
				arR[i].clear();
			}
			pq.clear();
		}
		bw.flush();
	}
	
	private static int Dijkstra(int start) {
		dist[start] = 0;	
		pq.add(new Node(start,0));
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(n.cost > dist[n.end]) {
				continue;
			}
			
			if(n.end == end) {
				return n.cost;
			}
			
			for(int i = 0; i < arD[n.end].size(); i++) {
				int nn = arD[n.end].get(i);
				if(dist[nn] > n.cost + map[n.end][nn]) {
					dist[nn] = n.cost + map[n.end][nn];
					parent[nn] = n.end;
					pq.add(new Node(nn,dist[nn]));
				}
			}
		}
		
		return -1;
	}
}
