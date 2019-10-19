package 불_5427;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node{
		int x;
		int y;
		int cnt;
		
		public Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", cnt=" + cnt + "]";
		}

	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < test; t++) {
			String[] nm = br.readLine().split(" ");
			
			int n = Integer.parseInt(nm[1]);
			int m = Integer.parseInt(nm[0]);
			
			int[][] map = new int[n+2][m+2];
			
			Queue<Node> sg = new LinkedList<>();
			Queue<Node> fire = new LinkedList<>();
			
			for(int i = 1; i <= n; i++) {
				String[] s = br.readLine().split("");
				for(int j = 1; j <= m; j++) {
					switch(s[j-1]) {
					case ".":
						map[i][j] = 1;
						break;
						
					case "@":
						map[i][j] = 2;
						sg.add(new Node(i,j,0));
						break;
						
					case "*":
						map[i][j] = 3;
						fire.add(new Node(i,j,0));
						break;
						
					case "#":
						map[i][j] = 4;
						break;
					}
				}
			}
			
			int[] dx = {-1,0,1,0};
			int[] dy = {0,1,0,-1};
			
			boolean getOut = false;
			int ans = 0;
			
			while(!sg.isEmpty()) {
				if(getOut) {
					break;
				}
				int fsize = fire.size();
				for(int i = 0; i < fsize; i++) {
					Node f = fire.poll();
					
					int x = f.x;
					int y = f.y;
					
					for(int j = 0; j < 4; j++) {
						if(map[x+dx[j]][y+dy[j]] == 1 || map[x+dx[j]][y+dy[j]] == 2) {
							map[x+dx[j]][y+dy[j]] = 3;
							fire.add(new Node(x+dx[j], y+dy[j],0));
						}
					}
				}
				
				int ssize = sg.size();
				for(int i = 0; i < ssize; i++) {
					Node s = sg.poll();
					
					int x = s.x;
					int y = s.y;
					int c = s.cnt;
					
					for(int j = 0; j < 4; j++) {
						if(map[x+dx[j]][y+dy[j]] == 1) {
							map[x+dx[j]][y+dy[j]] = 2;
							sg.add(new Node(x+dx[j], y+dy[j],c+1));
						}
						else if(map[x+dx[j]][y+dy[j]] == 0) {
							getOut = true;
							ans = c+1;
						}
					}
				}
			}
			if(getOut) {
				bw.write(ans+"\n");
			}
			else {
				bw.write("IMPOSSIBLE\n");
			}
		}
		bw.flush();	
	}
}
