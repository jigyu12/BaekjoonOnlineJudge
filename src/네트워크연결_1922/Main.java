package 네트워크연결_1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;



public class Main {
	
	static class Connect implements Comparable<Connect>{
		int start;
		int end;
		int cost;
		
		public Connect(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Connect [start=" + start + ", end=" + end + ", cost=" + cost + "]";
		}

		@Override
		public int compareTo(Connect arg0) {

			if(this.cost < arg0.cost) {
				return -1;
			}
			else if(this.cost > arg0.cost) {
				return 1;
			}
			return 0;
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
		parent[find(x)] = find(y);
	}
	
	private static int[] parent;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int com = Integer.parseInt(br.readLine());
			int count = Integer.parseInt(br.readLine());
			parent = new int[com+1];
			PriorityQueue<Connect> pq = new PriorityQueue<Connect>();
			for(int i = 0; i < count; i++) {
				String[] s = br.readLine().split(" ");
				Connect c = new Connect(Integer.parseInt(s[0]),Integer.parseInt(s[1]),Integer.parseInt(s[2]));
				pq.add(c);
			}
			int cnt = 0;
			for(int i = 0; i < parent.length; i++) {
				init(i);
			}
			int len = 0;
			while(!pq.isEmpty()) {
				if(cnt == com-1) {
					break;
				}
				Connect c = pq.poll();
				
				if(find(c.start) == find(c.end)) {
					continue;
				}
				if(find(c.start) == 0 || find(c.end) == 0) {
					continue;
				}
				
				union(c.start,c.end);
				len += c.cost;
				cnt++;
			}
			System.out.println(len);
		} catch (NumberFormatException | IOException e) {

		}
	}
}
