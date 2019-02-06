package 거의최단경로_5719;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
	
	static class Node{
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

	}
	

	private static int[][] map;
	private static int[] dist;
	private static int n;
	private static int start;
	private static int end;
	private static ArrayList<Node>[] ar;
	private static PriorityQueue<Node> pq;
	
	private static int Dijkstra(int s) {
		int start = s;
		Arrays.fill(dist, 987654321);
		dist[start] = 0;
		Node node = new Node(start,dist[start]);
		pq.add(node);
		int path = -1;
		while(!pq.isEmpty()) {
			Node no = pq.poll();
			
			for(int i = 0; i < ar[no.end].size(); i++) {
				if(dist[ar[no.end].get(i).end] > dist[no.end] + ar[no.end].get(i).cost) {
					dist[ar[no.end].get(i).end] = dist[no.end] + ar[no.end].get(i).cost;
//					System.out.println(no.end + " " + ar[no.end].get(i).end);
					if(end == ar[no.end].get(i).end) {
						path = no.end;
					}
					pq.add(new Node(ar[no.end].get(i).end,dist[ar[no.end].get(i).end]));
				}
			}
			
			
//			for(int j = 0; j < n; j++) {
//				System.out.print(dist[j] + " ");
//			}
//			System.out.println();
		}
		for(int j = 0; j < ar[path].size(); j++) {
			if(ar[path].get(j).end == end) {
				ar[path].remove(j);
			}
		}
		return dist[end];
	}
	

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] nm = br.readLine().split(" ");
			n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);
			String[] se = br.readLine().split(" ");
			start = Integer.parseInt(se[0]);
			end = Integer.parseInt(se[1]);
			ar = new ArrayList[n];
			map = new int[n][n];
			dist = new int[n];
			pq = new PriorityQueue<Node>(new Comparator<Node>() {
				@Override
				public int compare(Node arg0, Node arg1) {
					return arg0.cost-arg1.cost;
				}
			});
			
			for(int i = 0; i < n; i++) {
				ar[i] = new ArrayList<Node>();
			}

			for(int i = 0; i < m; i++) {
				String[] uvp = br.readLine().split(" ");
				int u = Integer.parseInt(uvp[0]);
				int v = Integer.parseInt(uvp[1]);
				int p = Integer.parseInt(uvp[2]);
				ar[u].add(new Node(v,p));
				map[u][v] = p;
			}

			for(int j = 0; j < n; j++) {
				System.out.print(ar[j].size() + " ");
			}
			System.out.println();
			int first = Dijkstra(start);
			System.out.println("first : " + first);
			for(int j = 0; j < n; j++) {
				System.out.print(ar[j].size() + " ");
			}
			System.out.println();
//			if(first == 987654321) {
//				System.out.println("-1");
//				return ;
//			}
			int ans = first;
			while(ans <= first) {
				ans = Dijkstra(start);
				System.out.println(ans);
				for(int j = 0; j < n; j++) {
					System.out.print(ar[j].size() + " ");
				}
				System.out.println();
			}
			if(ans == 987654321) {
				System.out.println("-1");
			}
			else {
				System.out.println(ans);
			}
			

		} catch (IOException e) {
		}
		
	}

}
