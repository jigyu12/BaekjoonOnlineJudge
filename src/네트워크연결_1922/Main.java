package 네트워크연결_1922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
	
	static class Connect implements Comparable<Connect>{
		int end;
		int cost;
		
		public Connect(int end, int cost) {
			this.end = end;
			this.cost = cost;
		}

		@Override
		public String toString() {
			return "Connect [end=" + end + ", cost=" + cost + "]";
		}
		
		@Override
		public int compareTo(Connect arg0) {

			return this.cost - arg0.cost;
		}
		
	}
		
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int com = Integer.parseInt(br.readLine());
		int count = Integer.parseInt(br.readLine());
		ArrayList<Connect>[] ar = new ArrayList[com+1];
		PriorityQueue<Connect> pq = new PriorityQueue<Connect>();
		boolean[] visited  = new boolean[com+1];
		for(int i = 0; i < com+1; i++) {
			ar[i] = new ArrayList<>();
		}
		for(int i = 0; i < count; i++) {
			String[] s = br.readLine().split(" ");
			ar[Integer.parseInt(s[0])].add(new Connect(Integer.parseInt(s[1]),Integer.parseInt(s[2])));
			ar[Integer.parseInt(s[1])].add(new Connect(Integer.parseInt(s[0]),Integer.parseInt(s[2])));
		}
		int ans = 0;
		visited[1] = true;
		int idx = 1;
		for(int i = 1; i < com; i++) {
			for(int j = 0; j < ar[idx].size();j++) {
				if(!visited[ar[idx].get(j).end]) {
					pq.add(ar[idx].get(j));
				}
				
			}
			while(!pq.isEmpty()) {
				Connect cc = pq.poll();
				if(!visited[cc.end]) {
					ans += cc.cost;
					visited[cc.end] = true;
					idx = cc.end;
					break;
				}
			}
		}
		System.out.println(ans);
	}
}
