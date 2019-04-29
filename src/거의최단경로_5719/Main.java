package 거의최단경로_5719;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	static class Node {
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

	private static int[] dist;
	private static int[] path;
	private static int[][] map;
	private static int n;
	private static int start;
	private static int end;
	private static ArrayList<Node>[] ar;
	private static PriorityQueue<Node> pq;

	private static int dijkstra(int s) {
		int start = s;
		Arrays.fill(path, -1);
		Arrays.fill(dist, 987654321);
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
					path[nn.end] = n.end;
				}
			}
		}
		return dist[end];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			while (true) {
				String[] nm = br.readLine().split(" ");
				n = Integer.parseInt(nm[0]);
				int m = Integer.parseInt(nm[1]);
				if (n == 0 && m == 0) {
					break;
				}
				String[] se = br.readLine().split(" ");
				start = Integer.parseInt(se[0]);
				end = Integer.parseInt(se[1]);
				ar = new ArrayList[n];
				dist = new int[n];
				path = new int[n];
				map = new int[n][n];
				pq = new PriorityQueue<Node>(new Comparator<Node>() {
					@Override
					public int compare(Node arg0, Node arg1) {
						return arg0.cost - arg1.cost;
					}
				});

				for (int i = 0; i < n; i++) {
					ar[i] = new ArrayList<Node>();
				}

				for (int i = 0; i < m; i++) {
					String[] uvp = br.readLine().split(" ");
					int u = Integer.parseInt(uvp[0]);
					int v = Integer.parseInt(uvp[1]);
					int p = Integer.parseInt(uvp[2]);
					map[u][v] = p;
					ar[u].add(new Node(v, p));
				}

				int first = dijkstra(start);
				
//				for (int i = 0; i < dist.length; i++) {
//					System.out.print(dist[i] + " ");
//				}
//				System.out.println();

				int a = end;
				int ans = first;

				Queue<Integer> qu = new LinkedList<>();

				for (int i = 0; i < dist.length; i++) {
					if(end == i) {
						continue;
					}
					if (first == dist[i] + map[i][end]) {
						qu.add(i);
						map[i][end] = 987654321;
					}
				}
				while (!qu.isEmpty()) {
					a = end;
					int minvertex = qu.poll();
					while (minvertex >= 0) {
						for (int i = 0; i < ar[minvertex].size(); i++) {
							if (ar[minvertex].get(i).end == a) {
								ar[minvertex].remove(i);
								break;
							}
						}
						a = minvertex;
						minvertex = path[minvertex];
					}
				}
		
				ans = dijkstra(start);
//				for (int i = 0; i < dist.length; i++) {
//					System.out.print(dist[i] + " ");
//				}
//				System.out.println();
				if (ans >= 987654321) {
					bw.write("-1\n");
				} else {
					bw.write(ans + "\n");
				}
			}
			bw.flush();
		} catch (IOException e) {
		}
	}
}
