package 움직이는미로탈출_16954;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node{
		int x;
		int y;
		int count;
		
		public Node(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", count=" + count + "]";
		}
		
		
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] temp = new int[10][10];
		ArrayList<Integer>[] map = new ArrayList[10];
		boolean[][][] visited = new boolean[10][10][10];
		Queue<Node> qu = new LinkedList<>();
		
		map[0] = new ArrayList<>();
		map[9] = new ArrayList<>();
		for(int i = 1; i <= 8; i++) {
			map[i] = new ArrayList<>();
			String[] s = br.readLine().split("");
			for(int j = 1; j <= 8; j++) {
				if(s[j-1].equals(".")) {
					temp[i][j] = 1;
				}
			}
		}

		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				map[i].add(0);
			}
		}
		
		for(int i = 1; i <= 8; i++) {
			for(int j = 1; j <= 8; j++) {
				if(temp[i][j] == 1) {
					map[j].remove(9-i);
					map[j].add(9-i, temp[i][j]);

				}
			}
		}
		
		qu.add(new Node(1,1,0));
		visited[0][1][1] = true;
		
		int ans = 0;
		while(!qu.isEmpty()) {
			int size = qu.size();
			for(int i = 0; i < size; i++) {
				Node n = qu.poll();
				int nx = n.x;
				int ny = n.y;
				int nc = n.count;
				
				if(nx == 8 && ny == 8) {
					ans = 1;
					break;
				}
				
				if(map[nx].get(ny) == 0) {
					continue;
				}
				else {
					if(nc+1 > 9) {
						continue;
					}
					visited[nc+1][nx][ny] = true;
					qu.add(new Node(nx,ny,nc+1));
				}
				
				if(!visited[nc+1][nx-1][ny] && map[nx-1].get(ny) == 1) {
					visited[nc+1][nx-1][ny] = true;
					qu.add(new Node(nx-1,ny,nc+1));
				}
				
				if(!visited[nc+1][nx+1][ny] && map[nx+1].get(ny) == 1) {
					visited[nc+1][nx+1][ny] = true;
					qu.add(new Node(nx+1,ny,nc+1));
				}
				
				if(!visited[nc+1][nx][ny-1] && map[nx].get(ny-1) == 1) {
					visited[nc+1][nx][ny-1] = true;
					qu.add(new Node(nx,ny-1,nc+1));
				}
				
				if(!visited[nc+1][nx][ny+1] && map[nx].get(ny+1) == 1) {
					visited[nc+1][nx][ny+1] = true;
					qu.add(new Node(nx,ny+1,nc+1));
				}
				
				if(!visited[nc+1][nx-1][ny-1] && map[nx-1].get(ny-1) == 1) {
					visited[nc+1][nx-1][ny-1] = true;
					qu.add(new Node(nx-1,ny-1,nc+1));
				}
				
				if(!visited[nc+1][nx-1][ny+1] && map[nx-1].get(ny+1) == 1) {
					visited[nc+1][nx-1][ny+1] = true;
					qu.add(new Node(nx-1,ny+1,nc+1));
				}
				
				if(!visited[nc+1][nx+1][ny-1] && map[nx+1].get(ny-1) == 1) {
					visited[nc+1][nx+1][ny-1] = true;
					qu.add(new Node(nx+1,ny-1,nc+1));
				}
				
				if(!visited[nc+1][nx+1][ny+1] && map[nx+1].get(ny+1) == 1) {
					visited[nc+1][nx+1][ny+1] = true;
					qu.add(new Node(nx+1,ny+1,nc+1));
				}
				
			
			}
			
			
			for(int i = 1; i <= 8; i++) {
				map[i].remove(1);
				map[i].add(8, 1);
			}
		}
		

		System.out.println(ans);
	}
}
