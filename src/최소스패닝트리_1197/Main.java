package 최소스패닝트리_1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	static class Node{
		int start;
		int end;
		int cost;
		
		public Node(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Node [start=" + start + ", end=" + end + ", cost=" + cost + "]";
		}
		
	}
	
	private static void init(int x) {
		parent[x] = x;
	}
	
	private static int find(int x) {
		if(parent[x] == x) {
			return x;
		}
		
		return parent[x] = find(parent[x]);
	}
	
	private static void union(int x, int y) {
		parent[find(y)] = find(x);
	}

	private static PriorityQueue<Node> pq;
	private static int parent[];
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] ve = br.readLine().split(" ");
			int v = Integer.parseInt(ve[0]);
			int e = Integer.parseInt(ve[1]);
			parent = new int[v+1];
			pq = new PriorityQueue<>(new Comparator<Node>() {
				@Override
				public int compare(Node o1, Node o2) {
					return o1.cost - o2.cost;
				}
			});
			for(int i = 0; i < v+1; i++) {
				init(i);
			}
			for(int i = 0; i < e; i++) {
				String[] s = br.readLine().split(" ");
				pq.add(new Node(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2])));
			}
			int ans = 0;

			while(!pq.isEmpty()) {
				if(v < 1) {
					break;
				}
				Node n = pq.poll();
				
				if(find(n.start) == find(n.end)) {
					continue;
				}
				
				if(n.start < n.end) {
					union(n.start,n.end);
				}
				else {
					union(n.end,n.start);
				}
				v--;
				ans += n.cost;
			}
			System.out.println(ans);
			
		} catch (IOException e) {
		}
	}
}
