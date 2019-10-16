package 영역구하기_2583;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nmk = br.readLine().split(" ");
		int n = Integer.parseInt(nmk[0]);
		int m = Integer.parseInt(nmk[1]);
		int k = Integer.parseInt(nmk[2]);
		
		boolean[][] map = new boolean[n+2][m+2];
		
		for(int i = 0; i <= n+1; i++) {
			Arrays.fill(map[i], true);
		}

		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				map[i][j] = false;
			}
		}

		for(int i = 0; i < k; i++) {
			String[] s = br.readLine().split(" ");
			
			int x1 = Integer.parseInt(s[0])+1;
			int y1 = Integer.parseInt(s[1])+1;
			int x2 = Integer.parseInt(s[2])+1;
			int y2 = Integer.parseInt(s[3])+1;
			
			for(int j = y1; j < y2; j++) {
				for(int q = x1; q < x2; q++) {
					map[j][q] = true;
				}
			}
		}

		ArrayList<Integer> ar = new ArrayList<>();
		Queue<Node> qu = new LinkedList<>();
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= m; j++) {
				if(!map[i][j]) {
					int sum = 0;
					qu.add(new Node(i,j));
					map[i][j] = true;
					while(!qu.isEmpty()) {
						int size = qu.size();
						sum += size;
						for(int t = 0; t < size; t++) {
							Node no = qu.poll();
							
							int x = no.x;
							int y = no.y;
							
							for(int l = 0; l < 4; l++) {
								if(!map[x+dx[l]][y+dy[l]]) {
									map[x+dx[l]][y+dy[l]] = true;
									qu.add(new Node(x+dx[l],y+dy[l]));
								}
							}
						}
					}
					ar.add(sum);
				}
			}
		}
		
		Collections.sort(ar);
		bw.write(ar.size()+"\n");
		for(int i = 0; i < ar.size(); i++) {
			bw.write(ar.get(i)+ " ");
		}
		bw.write("\n");
		bw.flush();
	}

}
