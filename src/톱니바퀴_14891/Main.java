package 톱니바퀴_14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Gear{
		int num;
		int dir;
		
		public Gear(int num, int dir) {
			this.num = num;
			this.dir = dir;
		}

		@Override
		public String toString() {
			return "Gear [num=" + num + ", dir=" + dir + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Deque<Integer>[] dq = new ArrayDeque[4];
		
		for(int i = 0; i < 4; i++) {
			String s = br.readLine();
			dq[i] = new ArrayDeque<>();
			for(int j = 0; j < 8; j++) {
				dq[i].add(s.charAt(j) - 48);
			}
		}
		
		int[][] twosixnum = new int[4][2];
		
		int k = Integer.parseInt(br.readLine());
		for(int t = 0; t < k; t++) {
			String[] s = br.readLine().split(" ");
			int num = Integer.parseInt(s[0]) - 1;
			int dir = Integer.parseInt(s[1]);

			for(int i = 0; i < 4; i++) {
				Iterator<Integer> it = dq[i].iterator();
				int idx = 0;
				while(it.hasNext()) {
					int n = it.next();
					if(idx == 2) {
						twosixnum[i][0] = n;
					} 
					else if(idx == 6) {
						twosixnum[i][1] = n;
					}
					
					idx++;
				}
			}

			
			boolean[] visited = new boolean[4];
			visited[num] = true;
			
			Queue<Gear> qu = new LinkedList<>();
			qu.add(new Gear(num,dir));
			
			while(!qu.isEmpty()) {
				Gear g = qu.poll();
				
				int n = g.num;
				int d = g.dir;
				
				if(d == 1) {
					int last = dq[n].pollLast();
					dq[n].addFirst(last);
				}
				else {
					int first = dq[n].pollFirst();
					dq[n].addLast(first);
				}
				
				if(n+1 <= 3 && !visited[n+1] && twosixnum[n][0] != twosixnum[n+1][1]) {
					visited[n+1] = true;
					qu.add(new Gear(n+1,-d));
				}
				
				if(0 <= n-1 && !visited[n-1] && twosixnum[n-1][0] != twosixnum[n][1]) {
					visited[n-1] = true;
					qu.add(new Gear(n-1,-d));
				}
			}
			
		}
		int score = 1;
		int ans = 0;
		
		
		for(int i = 0; i < 4; i++) {
			if(dq[i].getFirst() == 1) {
				ans += score;
			}
			score *= 2;
		}
		System.out.println(ans);
	}

}
