package 가장큰최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;


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
	private static int[] input;
	private static int[] map;
	private static int n;
	private static int start;
	private static int end;
	private static ArrayList<Node>[] ar;
	private static ArrayList<Node>[] real;
	private static PriorityQueue<Node> pq;
	private static int num;
	
	private static void dijkstra(int s) {
		int start = s;
		Arrays.fill(dist, 987654321);
		dist[start] = 0;
		Node no = new Node(start, dist[start]);
		pq.add(no);
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			for (int i = 0; i < real[n.end].size(); i++) {
				Node nn = real[n.end].get(i);
				if (dist[nn.end] > dist[n.end] + nn.cost) {
					dist[nn.end] = dist[n.end] + nn.cost;
					pq.add(new Node(nn.end, dist[nn.end]));
				}
			}
			
		}
		for(int j = 1; j <= num; j++) {
			System.out.print(dist[j] + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 1; i <= test; i++) {
				num = Integer.parseInt(br.readLine());
				ar = new ArrayList[num+1];
				real = new ArrayList[num+1];
				dist = new int[num+1];
				input = new int[num];
				map = new int[num+1];
				pq = new PriorityQueue<Node>(new Comparator<Node>() {
					@Override
					public int compare(Node arg0, Node arg1) {
						return arg0.cost - arg1.cost;
					}
				});
				String[] s = br.readLine().split(" ");
				for(int j = 0; j <= num; j++) {
					if(j < num) {
						input[j] = Integer.parseInt(s[j]);
					}
					ar[j] = new ArrayList<>();
					real[j] = new ArrayList<>();
				}
				for(int j = 0; j <= num; j++) {
					System.out.print(input[j] + " ");
				}
				System.out.println();
				for(int j = 1; j < num; j++) {
					String[] ss = br.readLine().split(" ");
					for(int k = 0; k < ss.length; k++) {
						ar[j].add(new Node(j+k+1,Integer.parseInt(ss[k])));
						ar[j+k+1].add(new Node(j,Integer.parseInt(ss[k])));
					}
				}
				
				
				for(int j = num; j >= 0; j--) {
					System.out.println(input[j]);
					for(int k = 0; k < ar[input[j]].size(); k++) {
						int end = ar[input[j]].get(k).end;
						int cost = ar[input[j]].get(k).cost;
						System.out.println(end + " " + cost);
						real[input[j]].add(new Node(end,cost));
					}
					for(int k = 1; k <= num; k++) {
						dijkstra(j);
					}
				}
				
				
//				for(int j = 1; j <= num; j++) {
//					for(int k = 0; k < ar[j].size(); k++) {
//						System.out.print(ar[j].get(k).end + " " + ar[j].get(k).cost + " ");
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
		} catch (NumberFormatException | IOException e) {
		}
		
	}

}

