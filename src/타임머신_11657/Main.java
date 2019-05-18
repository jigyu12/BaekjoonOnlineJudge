package 타임머신_11657;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

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

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] nm = br.readLine().split(" ");
			int n = Integer.parseInt(nm[0]);
			int m = Integer.parseInt(nm[1]);

			int[] dist = new int[n + 1];
			Edge[] e = new Edge[m];
			Arrays.fill(dist, 987654321);

			for (int i = 0; i < m; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				e[i] = new Edge(a, b, c);
			}

			dist[1] = 0;
			for (int i = 1; i < dist.length - 1; i++) {
				for (int j = 0; j < e.length; j++) {
					if (dist[e[j].start] != 987654321 && dist[e[j].end] > dist[e[j].start] + e[j].cost) {
						dist[e[j].end] = dist[e[j].start] + e[j].cost;
					}
				}
			}
			for (int j = 0; j < e.length; j++) {
				if (dist[e[j].start] != 987654321 && dist[e[j].end] > dist[e[j].start] + e[j].cost) {
					System.out.println("-1");
					return ;
				}
			}

			for (int i = 2; i < dist.length; i++) {
				if (dist[i] != 987654321) {
					System.out.println(dist[i]);
				} else {
					System.out.println("-1");
				}

			}
			System.out.println();

		} catch (IOException e) {
		}
	}
}
