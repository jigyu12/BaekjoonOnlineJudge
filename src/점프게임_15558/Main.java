package 점프게임_15558;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node{
		int line;
		int x;
		
		public Node(int line, int x) {
			this.line = line;
			this.x = x;
		}

		@Override
		public String toString() {
			return "Node [line=" + line + ", x=" + x + "]";
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]) - 1;
		int k = Integer.parseInt(nk[1]);
		
		ArrayList<Integer>[] map = new ArrayList[2];
		boolean[][] visited = new boolean[2][n+1];
		
		for(int i = 0; i < 2; i++) {
			map[i] = new ArrayList<>();
			String[] s = br.readLine().split("");
			for(int j = 0; j < s.length; j++) {
				map[i].add(Integer.parseInt(s[j]));
			}
		}
	
		int time = 0;
		boolean arrive = false;
		
		Queue<Node> qu = new LinkedList<>();
		qu.add(new Node(0,0));
		visited[0][0] = true;
		
		while(!qu.isEmpty()) {
			int size = qu.size();
			for(int i = 0; i < size; i++) {
				Node no = qu.poll();
				int nl = no.line;
				int nx = no.x;
				
				if(arrive) {
					continue;
				}
				
				if(nx > n) {
					arrive = true;
					continue;
				}
				
				if(nx < 0) {
					continue;
				}
				
				if(nx+k+ time <= n  && !visited[(nl + 1) % 2][nx+k+ time] && map[(nl + 1) % 2].get(nx+k) == 1) {
					qu.add(new Node((nl + 1) % 2,nx+k-1));
					visited[(nl + 1) % 2][nx+k+ time] = true;
				}
				else if(nx+k+ time > n ) {
					arrive = true;
					continue;
				}
				
				if(nx+1+time <= n && !visited[nl][nx+1+time] && map[nl].get(nx+1) == 1) {
					qu.add(new Node(nl,nx));
					visited[nl][nx+1+time] = true;
				}
				else if(nx+1+time > n) {
					arrive = true;
					continue;
				}
				
				if(nx >= 1 && !visited[nl][nx-1+time] && map[nl].get(nx-1) == 1) {
					qu.add(new Node(nl,nx-2));
					visited[nl][nx-1+time] = true;
				}
			}
			
			map[0].remove(0);
			map[1].remove(0);
			time++;
		}
		
		if(arrive) {
			System.out.println("1");
		}
		else {
			System.out.println("0");
		}
	}
}
