package 보이저1호_3987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Node{
		int x;
		int y;
		int dir;
		int count;
		
		public Node(int x, int y, int dir, int count) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", dir=" + dir + ", count=" + count + "]";
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nm = br.readLine().split(" ");
		
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int[][] map = new int[n+2][m+2];
		
		for(int i = 1; i <= n; i++) {
			String[] s = br.readLine().split("");
			for(int j = 1; j <= m; j++) {
				switch(s[j-1]) {
				case ".":
					map[i][j] = 1;
					break;
					
				case "/":
					map[i][j] = 2;
					break;
					
				case "\\" :
					map[i][j] = 3;
					break;
				}
			}
		}
		
		String[] prpc = br.readLine().split(" ");
		
		Node start = new Node(Integer.parseInt(prpc[0]),Integer.parseInt(prpc[1]),0,0);

		Queue<Node> qu = new LinkedList<>();
		boolean voyager = false;
		Node ans = new Node(0,0,0,0);
		
		for(int go = 0; go < 4; go++) {
			boolean[][][] visited = new boolean[n+2][m+2][4];
			if(voyager) {
				break;
			}
			
			qu.add(new Node(start.x,start.y,go,1));
			visited[start.x][start.y][go] = true;
			
			while(!qu.isEmpty()) {
				
				if(voyager) {
					break;
				}
				
				Node no = qu.poll();
				
				int x = no.x;
				int y = no.y;
				int d = no.dir;
				int c = no.count;
				
				switch(d) {
				
				case 0:
					if(map[x-1][y] > 0) {
						switch(map[x-1][y]) {
						case 1:
							if(!visited[x-1][y][d]) {
								qu.add(new Node(x-1,y,d,c+1));
								visited[x-1][y][d] = true;
							}
							else {
								voyager = true;
								ans.dir = go;
							}
							break;
							
						case 2:
							if(!visited[x-1][y][(d+1) % 4]) {
								qu.add(new Node(x-1,y,(d+1) % 4,c+1));
								visited[x-1][y][(d+1) % 4] = true;
							}
							else {
								voyager = true;
								ans.dir = go;
							}
							break;
							
						case 3:
							if(d-1 < 0) {
								d = 4;
							}
							if(!visited[x-1][y][(d-1) % 4]) {
								qu.add(new Node(x-1,y,(d-1) % 4,c+1));
								visited[x-1][y][(d-1) % 4] = true;
							}
							else {
								voyager = true;
								ans.dir = go;
							}
							break;
						}
					}
					else {
						if(ans.count < c) {
							ans.count = c;
							ans.dir = go;
						}
					}
					break;
					
				case 1:
					if(map[x][y+1] > 0) {
						switch(map[x][y+1]) {
						case 1:
							if(!visited[x][y+1][d]) {
								qu.add(new Node(x,y+1,d,c+1));
								visited[x][y+1][d] = true;
							}
							else {
								voyager = true;
								ans.dir = go;
							}
							break;
							
						case 2:
							if(d-1 < 0) {
								d = 4;
							}
							if(!visited[x][y+1][(d-1) % 4]) {
								qu.add(new Node(x,y+1,(d-1) % 4,c+1));
								visited[x][y+1][(d-1) % 4] = true;
							}
							else {
								voyager = true;
								ans.dir = go;
							}
							break;
							
						case 3:
							if(!visited[x][y+1][(d+1) % 4]) {
								qu.add(new Node(x,y+1,(d+1) % 4,c+1));
								visited[x][y+1][(d+1) % 4] = true;
							}
							else {
								voyager = true;
								ans.dir = go;
							}
							break;
						}
					}
					else {
						if(ans.count < c) {
							ans.count = c;
							ans.dir = go;
						}
					}
					break;
					
				case 2:
					if(map[x+1][y] > 0) {
						switch(map[x+1][y]) {
						case 1:
							if(!visited[x+1][y][d]) {
								qu.add(new Node(x+1,y,d,c+1));
								visited[x+1][y][d] = true;
							}
							else {
								voyager = true;
								ans.dir = go;
							}
							break;
							
						case 2:
							if(!visited[x+1][y][(d+1) % 4]) {
								qu.add(new Node(x+1,y,(d+1) % 4,c+1));
								visited[x+1][y][(d+1) % 4] = true;
							}
							else {
								voyager = true;
								ans.dir = go;
							}
							break;
							
						case 3:
							if(d-1 < 0) {
								d = 4;
							}
							if(!visited[x+1][y][(d-1) % 4]) {
								qu.add(new Node(x+1,y,(d-1) % 4,c+1));
								visited[x+1][y][(d-1) % 4] = true;
							}
							else {
								voyager = true;
								ans.dir = go;
							}
							break;
						}
					}
					else {
						if(ans.count < c) {
							ans.count = c;
							ans.dir = go;
						}
					}
					break;
					
				case 3:
					if(map[x][y-1] > 0) {
						switch(map[x][y-1]) {
						case 1:
							if(!visited[x][y-1][d]) {
								qu.add(new Node(x,y-1,d,c+1));
								visited[x][y-1][d] = true;
							}
							else {
								voyager = true;
								ans.dir = go;
							}
							break;
							
						case 2:
							if(d-1 < 0) {
								d = 4;
							}
							if(!visited[x][y-1][(d-1) % 4]) {
								qu.add(new Node(x,y-1,(d-1) % 4,c+1));
								visited[x][y-1][(d-1) % 4] = true;
							}
							else {
								voyager = true;
								ans.dir = go;
							}
							break;
							
						case 3:
							if(!visited[x][y-1][(d+1) % 4]) {
								qu.add(new Node(x,y-1,(d+1) % 4,c+1));
								visited[x][y-1][(d+1) % 4] = true;
							}
							else {
								voyager = true;
								ans.dir = go;
							}
							break;
						}
					}
					else {
						if(ans.count < c) {
							ans.count = c;
							ans.dir = go;
						}
					}
					break;
				}
			}
		}
		if(voyager) {
			switch(ans.dir) {
			case 0:
				System.out.println("U");
				System.out.println("Voyager");
				break;
			case 1:
				System.out.println("R");
				System.out.println("Voyager");
				break;
			case 2:
				System.out.println("D");
				System.out.println("Voyager");
				break;
			case 3:
				System.out.println("L");
				System.out.println("Voyager");
				break;
			}
		}
		else {
			switch(ans.dir) {
			case 0:
				System.out.println("U");
				System.out.println(ans.count);
				break;
			case 1:
				System.out.println("R");
				System.out.println(ans.count);
				break;
			case 2:
				System.out.println("D");
				System.out.println(ans.count);
				break;
			case 3:
				System.out.println("L");
				System.out.println(ans.count);
				break;
			}
		}
	}
}
