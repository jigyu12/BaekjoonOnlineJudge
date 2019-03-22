package »ó¹üºôµù_6593;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Sangbum {
		int l;
		int r;
		int c;
		int count;
		
		public Sangbum(int l, int r, int c, int count){
			this.l = l;
			this.r = r;
			this.c = c;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Sangbum [l=" + l + ", r=" + r + ", c=" + c + ", count=" + count + "]";
		}
		
		
	}
	
	private static int l;
	private static int r;
	private static int c;
	private static int ans;
	private static boolean arrive;
	private static int[][][] cube;
	private static int[][][] countcube;
	
	private static void find(int l, int r, int c, int count) {
		Queue<Sangbum> qu = new LinkedList<>();
		qu.add(new Sangbum(l,r,c,count));
		
		while(!qu.isEmpty()) {
			Sangbum sb = qu.poll();
			int sbl = sb.l;
			int sbr = sb.r;
			int sbc = sb.c;
			int sbco = sb.count;

			if(sbco > ans) {
				continue;
			}
			
			if(cube[sb.l][sb.r][sb.c] == 2) {
				arrive = true;
				if(ans > sb.count) {
					ans = sb.count;
				}
				continue;
			}
			
			countcube[sbl][sbr][sbc] = sbco;
			
			while(cube[sbl+1][sbr][sbc] != 0) {
				sbco++;
				if(countcube[sbl+1][sbr][sbc] > sbco) {
					qu.add(new Sangbum(sbl+1,sbr,sbc,sbco));
				}
				sbl++;
			}
			
			sbl = sb.l;
			sbr = sb.r;
			sbc = sb.c;
			sbco = sb.count;
			while(cube[sbl][sbr-1][sbc] != 0) {
				sbco++;
				if(countcube[sbl][sbr-1][sbc] > sbco) {
					qu.add(new Sangbum(sbl,sbr-1,sbc,sbco));
				}
				sbr--;
			}
			
			sbl = sb.l;
			sbr = sb.r;
			sbc = sb.c;
			sbco = sb.count;
			while(cube[sbl][sbr+1][sbc] != 0) {
				sbco++;
				if(countcube[sbl][sbr+1][sbc] > sbco) {
					qu.add(new Sangbum(sbl,sbr+1,sbc,sbco));
				}
				sbr++;
			}
			
			sbl = sb.l;
			sbr = sb.r;
			sbc = sb.c;
			sbco = sb.count;
			while(cube[sbl][sbr][sbc-1] != 0) {
				sbco++;
				if(countcube[sbl][sbr][sbc-1] > sbco) {
					qu.add(new Sangbum(sbl,sbr,sbc-1,sbco));
				}
				sbc--;
			}
			
			sbl = sb.l;
			sbr = sb.r;
			sbc = sb.c;
			sbco = sb.count;
			while(cube[sbl][sbr][sbc+1] != 0) {
				sbco++;
				if(countcube[sbl][sbr][sbc+1] > sbco) {
					qu.add(new Sangbum(sbl,sbr,sbc+1,sbco));
				}
				sbc++;
			}
			
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		while(true) {
			String[] s = br.readLine().split(" ");
			l = Integer.parseInt(s[0]);
			r = Integer.parseInt(s[1]);
			c = Integer.parseInt(s[2]);
			if(l == 0 && r == 0 && c == 0) {
				break;
			}
			ans = 27001;
			countcube = new int[l+2][r+2][c+2];
			cube = new int[l+2][r+2][c+2];
			arrive = false;
			int startl = 0;
			int startr = 0;
			int startc = 0;
			
			for(int i = 1; i <= l; i++) {
				for(int j = 1; j <= r; j++) {
					String[] ss = br.readLine().split("");
					for(int k = 1; k <= c; k++) {
						countcube[i][j][k] = 27001;
						switch(ss[k-1]) {
						case "S":
							startl = i;
							startr = j;
							startc = k;
							cube[i][j][k] = 1;
							break;
						case "E":
							cube[i][j][k] = 2;
							break;
						case ".":
							cube[i][j][k] = 3;
							break;
						}
						
					}
				}
				br.readLine();
			}
		
			
			find(startl,startr,startc,0);
			
			if(arrive) { 
				bw.write("Escaped in " + ans + " minute(s).\n");
			}
			else {
				bw.write("Trapped!\n");
			}
			
		}
		bw.flush();
	}
}
