package 색종이붙이기_17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node{
		int x;
		int y;
		
		public Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + "]";
		}

	}
	
	private static int[][] map;
	private static boolean[][] visited;
	private static int shape[];
	private static int ans;
	
	private static void draw(int x, int y, int len, int cal) {
		
		if(shape[len] <= 0) {
			return ;
		}
		ArrayList<Node> ar;
		Queue<Node> qu = new LinkedList<>();
		qu.add(new Node(x,y));
		
		while(!qu.isEmpty()) {
			int size = qu.size();
			ar = new ArrayList<>();
			for(int i = 0; i < size; i++) {
				Node n = qu.poll();
				
				ar.add(n);
				
				int nx = n.x;
				int ny = n.y;
				
				boolean right = false;
				boolean rightdown = false;
				boolean down = false;
				
				if(!visited[nx][ny+1] && map[nx][ny+1] == 1) {
					right = true;
				}
				if(!visited[nx+1][ny+1] && map[nx+1][ny+1] == 1) {
					rightdown = true;
				}
				if(!visited[nx+1][ny] && map[nx][ny+1] == 1) {
					down = true;
				}
				
				if(right && rightdown && down) {
					
				}
								
			}
			
			
			
		}
		


	}
	
	private static void start(int cal) {
		
		if(ans < cal) {
			return;
		}
		
		boolean noone = false;
		
		for(int i = 1; i <= 10; i++) {
			for(int j = 1; j <= 10; j++) {
				if(!visited[i][j] && map[i][j] == 1) {
					noone = true;
					draw(i,j,5,cal);
					draw(i,j,4,cal);
					draw(i,j,3,cal);
					draw(i,j,2,cal);
					draw(i,j,1,cal);
				}
			}
		}
		
		if(!noone && ans > cal) {
			ans = cal;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[17][17];
		visited = new boolean[17][17];
		shape = new int[6];
		Arrays.fill(shape, 5);
		ans = 20;
		for(int i = 0; i < 12; i++) {
			Arrays.fill(visited[i], true);
		}
		
		boolean onecheck = false;
		for(int i = 1; i <= 10; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 1; j <= 10; j++) {
				map[i][j] = Integer.parseInt(s[j-1]);
				if(map[i][j] == 1) {
					onecheck = true;
					visited[i][j] = false;
				}
			}
		}
		
		if(onecheck) {
			start(0);
			if(ans == 20) {
				System.out.println("-1");
			}
			else {
				System.out.println(ans);
			}
			
		}
		else {
			System.out.println("0");
		}
		
		
		
		
	}
}
