package °¡½º°ü_2931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Pipe{
		int x;
		int y;
		int kind;
		
		public Pipe(int x, int y, int kind) {
			this.x = x;
			this.y = y;
			this.kind = kind;
		}

		@Override
		public String toString() {
			return "Pipe [x=" + x + ", y=" + y + ", kind=" + kind + "]";
		}

	}
	
	static class Node{
		int x;
		int y;
		int dir;
		int count;
		Pipe p;
		
		public Node(int x, int y, int dir, int count, Pipe p) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.count = count;
			this.p = p;
		}

		@Override
		public String toString() {
			return "Node [x=" + x + ", y=" + y + ", dir=" + dir + ", count=" + count + ", p=" + p + "]";
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] rc = br.readLine().split(" ");
		int r = Integer.parseInt(rc[0]);
		int c = Integer.parseInt(rc[1]);
		Queue<Node> qu = new LinkedList<>();
		int[][] map = new int[r+2][c+2];
		boolean[][][] visited = new boolean[4][r+2][c+2];
		int[][] abledir = new int[4][11];
		
		for(int i = 0; i < 4; i++) {
			Arrays.fill(abledir[i], -1);
		}
		
		abledir[0][1] = abledir[1][6] = abledir[1][7] = abledir[2][2] = abledir[1][0] = 1;
		abledir[0][3] = abledir[2][4] = abledir[3][6] = abledir[3][7] = abledir[3][0] = 3;
		abledir[0][5] = abledir[0][7] = abledir[1][4] = abledir[3][2] = abledir[0][0] = 0;
		abledir[1][3] = abledir[2][5] = abledir[2][7] = abledir[3][1] = abledir[2][0] = 2;
		abledir[0][8] = abledir[1][8] = abledir[2][8] = abledir[3][8] = 2;
		abledir[0][9] = abledir[1][9] = abledir[2][9] = abledir[3][9] = 2;
		
		Arrays.fill(map[0], 10);
		Arrays.fill(map[r+1], 10);
		
		int count = 0;
		Node end = new Node(0,0,0,0,null);
		for(int i = 1; i <= r; i++) {
			Arrays.fill(map[i],	10);
			String[] s = br.readLine().split("");
			for(int j = 1; j <= c; j++) {
				switch(s[j-1]) {
				case "1":
					count++;
					map[i][j] = 1;
					break;
				case "2":
					count++;
					map[i][j] = 2;
					break;
				case "3":
					count++;
					map[i][j] = 4;
					break;
				case "4":
					count++;
					map[i][j] = 3;
					break;
				case "|":
					count++;
					map[i][j] = 5;
					break;
				case "-":
					count++;
					map[i][j] = 6;
					break;
				case "+":
					count+=2;
					map[i][j] = 7;
					break;
				case "M":
					count++;
					map[i][j] = 8;
					
					qu.add(new Node(i,j,0,0,null));
					visited[0][i][j] = true;
					qu.add(new Node(i,j,1,0,null));
					visited[1][i][j] = true;
					qu.add(new Node(i,j,2,0,null));
					visited[2][i][j] = true;
					qu.add(new Node(i,j,3,0,null));
					visited[3][i][j] = true;
					break;
				case "Z":
					count++;
					map[i][j] = 9;
					end = new Node(i,j,0,0,null);
					break;
				case ".":
					map[i][j] = 0;
					break;
				}
			}
		}

		Pipe ans = new Pipe(0,0,0);
		boolean arrive = false;
		while(!qu.isEmpty()) {
			Node n = qu.poll();

			int nx = n.x;
			int ny = n.y;
			int nd = n.dir;
			int nc = n.count;
			Pipe np = n.p;
			
			int px = 0,py = 0,pk = 0;
			if(np != null) {
				px = np.x;
				py = np.y;
				pk = np.kind;
			}
			if(nx == end.x && ny == end.y) {
				if(count <= nc && nc <= count+1) {
					arrive = true;
					ans.x = np.x;
					ans.y = np.y;
					ans.kind = np.kind;
				}
				continue;
			}
			
			if(arrive) {
				continue;
			}
			
			if(map[nx][ny] == 0 && (np == null)) {
				switch(nd) {
				case 0:
					if(abledir[3][map[nx][ny-1]] > -1 && map[nx][ny-1] > 0 && abledir[1][map[nx][ny+1]] > -1 && map[nx][ny+1] > 0 && 
							abledir[nd][map[nx-1][ny]] > -1 && map[nx-1][ny] > 0) {
						qu.add(new Node(nx-1,ny,abledir[nd][map[nx-1][ny]],nc+1,new Pipe(nx,ny,7)));
						visited[nd][nx-1][ny] = true;
						continue;
					}
					if(abledir[nd][map[nx-1][ny]] > -1 && map[nx-1][ny] > 0) {
						qu.add(new Node(nx-1,ny,abledir[nd][map[nx-1][ny]],nc+1,new Pipe(nx,ny,5)));
						visited[nd][nx-1][ny] = true;
						continue;
					}
					if(abledir[1][map[nx][ny+1]] > -1 && map[nx][ny+1] > 0) {
						qu.add(new Node(nx,ny+1,abledir[1][map[nx][ny+1]],nc+1,new Pipe(nx,ny,1)));
						visited[1][nx][ny+1] = true;
					}
					if(abledir[3][map[nx][ny-1]] > -1 && map[nx][ny-1] > 0) {
						qu.add(new Node(nx,ny-1,abledir[3][map[nx][ny-1]],nc+1,new Pipe(nx,ny,3)));
						visited[3][nx][ny-1] = true;
					}
					break;
					
				case 1:
					if(abledir[2][map[nx+1][ny]] > -1 && (map[nx+1][ny] > 0) && abledir[nd][map[nx][ny+1]] > -1 && map[nx][ny+1] > 0 && 
							abledir[0][map[nx-1][ny]] > -1 && map[nx-1][ny] > 0) {
						qu.add(new Node(nx,ny+1,abledir[nd][map[nx][ny+1]],nc+1,new Pipe(nx,ny,7)));
						visited[nd][nx][ny+1] = true;
						continue;
					}
					if(abledir[nd][map[nx][ny+1]] > -1 && map[nx][ny+1] > 0) {
						qu.add(new Node(nx,ny+1,abledir[nd][map[nx][ny+1]],nc+1,new Pipe(nx,ny,6)));
						visited[nd][nx][ny+1] = true;
						continue;
					}
					if(abledir[0][map[nx-1][ny]] > -1 && map[nx-1][ny] > 0) {
						qu.add(new Node(nx-1,ny,abledir[0][map[nx-1][ny]],nc+1,new Pipe(nx,ny,4)));
						visited[0][nx-1][ny] = true;
					}
					if(abledir[2][map[nx+1][ny]] > -1 && (map[nx+1][ny] > 0)) {
						qu.add(new Node(nx+1,ny,abledir[2][map[nx+1][ny]],nc+1,new Pipe(nx,ny,3)));
						visited[2][nx+1][ny] = true;
					}
					
					break;
					
				case 2:
					if(abledir[3][map[nx][ny-1]] > -1 && map[nx][ny-1] > 0 && abledir[1][map[nx][ny+1]] > -1 && map[nx][ny+1] > 0 
							&& abledir[nd][map[nx+1][ny]] > -1 && (map[nx+1][ny] > 0)) {
						qu.add(new Node(nx+1,ny,abledir[nd][map[nx+1][ny]],nc+1,new Pipe(nx,ny,7)));
						visited[nd][nx+1][ny] = true;
						continue;
					}
					if(abledir[nd][map[nx+1][ny]] > -1 && (map[nx+1][ny] > 0)) {
						qu.add(new Node(nx+1,ny,abledir[nd][map[nx+1][ny]],nc+1,new Pipe(nx,ny,5)));
						visited[nd][nx+1][ny] = true;
						continue;
					}
					if(abledir[1][map[nx][ny+1]] > -1 && map[nx][ny+1] > 0) {
						qu.add(new Node(nx,ny+1,abledir[1][map[nx][ny+1]],nc+1,new Pipe(nx,ny,2)));
						visited[1][nx][ny+1] = true;
					}
					if(abledir[3][map[nx][ny-1]] > -1 && map[nx][ny-1] > 0) {
						qu.add(new Node(nx,ny-1,abledir[3][map[nx][ny-1]],nc+1,new Pipe(nx,ny,4)));
						visited[3][nx][ny-1] = true;
					}
					break;
					
				case 3:
					if(abledir[2][map[nx+1][ny]] > -1 && (map[nx+1][ny] > 0) && abledir[nd][map[nx][ny-1]] > -1 && map[nx][ny-1] > 0 && 
							abledir[0][map[nx-1][ny]] > -1 && map[nx-1][ny] > 0) {
						qu.add(new Node(nx,ny-1,abledir[nd][map[nx][ny-1]],nc+1,new Pipe(nx,ny,7)));
						visited[nd][nx][ny-1] = true;
						continue;
					}
					if(abledir[nd][map[nx][ny-1]] > -1 && map[nx][ny-1] > 0) {
						qu.add(new Node(nx,ny-1,abledir[nd][map[nx][ny-1]],nc+1,new Pipe(nx,ny,6)));
						visited[nd][nx][ny-1] = true;
						continue;
					}
					if(abledir[0][map[nx-1][ny]] > -1 && map[nx-1][ny] > 0) {
						qu.add(new Node(nx-1,ny,abledir[0][map[nx-1][ny]],nc+1,new Pipe(nx,ny,2)));
						visited[0][nx-1][ny] = true;
					}
					if(abledir[2][map[nx+1][ny]] > -1 && (map[nx+1][ny] > 0)) {
						qu.add(new Node(nx+1,ny,abledir[2][map[nx+1][ny]],nc+1,new Pipe(nx,ny,1)));
						visited[2][nx+1][ny] = true;
					}
					
					break;
				}
				continue;
			}
			
			else if(map[nx][ny] == 0 && (np != null)) {
				if(nx == np.x && ny == np.y) {
					switch(nd) {
					case 0:
						if(!visited[nd][nx-1][ny] && abledir[nd][map[nx-1][ny]] > -1 && map[nx-1][ny] > 0) {
							visited[nd][nx-1][ny] = true;
							qu.add(new Node(nx-1,ny,abledir[nd][map[nx-1][ny]],nc+1,new Pipe(px,py,pk)));
						}
						break;
					case 1:
						if(!visited[nd][nx][ny+1] && abledir[nd][map[nx][ny+1]] > -1 && map[nx][ny+1] > 0) {
							visited[nd][nx][ny+1] = true;
							qu.add(new Node(nx,ny+1,abledir[nd][map[nx][ny+1]],nc+1,new Pipe(px,py,pk)));
						}
						break;
					case 2:
						if(!visited[nd][nx+1][ny] && abledir[nd][map[nx+1][ny]] > -1 && map[nx+1][ny] > 0) {
							visited[nd][nx+1][ny] = true;
							qu.add(new Node(nx+1,ny,abledir[nd][map[nx+1][ny]],nc+1,new Pipe(px,py,pk)));
						}
						break;
					case 3:
						if(!visited[nd][nx][ny-1] && abledir[nd][map[nx][ny-1]] > -1 && map[nx][ny-1] > 0) {
							visited[nd][nx][ny-1] = true;
							qu.add(new Node(nx,ny-1,abledir[nd][map[nx][ny-1]],nc+1,new Pipe(px,py,pk)));
						}
						break;
					}
				}
				continue;
			}
			
			switch(nd) {
			case 0:
				if(np == null && !visited[nd][nx-1][ny] && (abledir[nd][map[nx-1][ny]] > -1 || map[nx-1][ny] == 0)) {
					visited[nd][nx-1][ny] = true;
					qu.add(new Node(nx-1,ny,abledir[nd][map[nx-1][ny]],nc+1,null));
				}
				else if(np != null && !visited[nd][nx-1][ny] && map[nx-1][ny] >= 0) {
					visited[nd][nx-1][ny] = true;
					qu.add(new Node(nx-1,ny,abledir[nd][map[nx-1][ny]],nc+1,new Pipe(px,py,pk)));
				}
				break;
			case 1:
				if(np == null && !visited[nd][nx][ny+1] && (abledir[nd][map[nx][ny+1]] > -1 || map[nx][ny+1] == 0)) {
					visited[nd][nx][ny+1] = true;
					qu.add(new Node(nx,ny+1,abledir[nd][map[nx][ny+1]],nc+1,null));
				}
				else if(np != null && !visited[nd][nx][ny+1] && map[nx][ny+1] >= 0 ) {
					visited[nd][nx][ny+1] = true;
					qu.add(new Node(nx,ny+1,abledir[nd][map[nx][ny+1]],nc+1,new Pipe(px,py,pk)));
				}
				break;	
			case 2:
				if(np == null && !visited[nd][nx+1][ny] && (abledir[nd][map[nx+1][ny]] > -1  || map[nx+1][ny] == 0)) {
					visited[nd][nx+1][ny] = true;
					qu.add(new Node(nx+1,ny,abledir[nd][map[nx+1][ny]],nc+1,null));
				}
				else if(np != null && !visited[nd][nx+1][ny] && (map[nx+1][ny] >= 0)) {
					visited[nd][nx+1][ny] = true;
					qu.add(new Node(nx+1,ny,abledir[nd][map[nx+1][ny]],nc+1,new Pipe(px,py,pk)));
				}
				break;
			case 3:
				if(np == null && !visited[nd][nx][ny-1] && (abledir[nd][map[nx][ny-1]] > -1  || map[nx][ny-1] == 0)) {
					visited[nd][nx][ny-1] = true;
					qu.add(new Node(nx,ny-1,abledir[nd][map[nx][ny-1]],nc+1,null));
				}
				else if(np != null && !visited[nd][nx][ny-1] && map[nx][ny-1] >= 0) {
					visited[nd][nx][ny-1] = true;
					qu.add(new Node(nx,ny-1,abledir[nd][map[nx][ny-1]],nc+1,new Pipe(px,py,pk)));
				}
				break;	
			}
			
		}
		String kind = "";
		switch(ans.kind) {
		case 1:
			kind = "1";
			break;
		case 2:
			kind = "2";
			break;
		case 3:
			kind = "4";
			break;
		case 4:
			kind = "3";
			break;
		case 5:
			kind = "|";
			break;
		case 6:
			kind = "-";
			break;
		case 7:
			kind = "+";
			break;
		}
		System.out.println(ans.x + " " + ans.y + " " + kind);
	}
}
