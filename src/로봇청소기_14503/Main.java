package 로봇청소기_14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int[][] map = new int[n][m];	
		
		String[] rcd = br.readLine().split(" ");
		
		int r = Integer.parseInt(rcd[0]);
		int c = Integer.parseInt(rcd[1]);
		int d = Integer.parseInt(rcd[2]);
		
		for(int i = 0 ; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0 ; j< m; j++) {
				map[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int cnt = 0;
		boolean end = true;
		while(end) {

			cnt++;
			map[r][c] = 2;
//			for(int i = 0 ; i < n; i++) {
//				for(int j = 0 ; j< m; j++) {
//					System.out.print(map[i][j] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
			boolean ableback = true;
			xx : for(int i = 0; i < 4; i++) {
				d--;
				if(d < 0) {
					d = 3;
				}
				switch(d) {
				case 0:
					if(map[r-1][c] == 0) {
						r--;
						ableback = false;
						break xx;
					}
					break;
					
				case 1:
					if(map[r][c+1] == 0) {
						c++;
						ableback = false;
						break xx;
					}
					break;	
					
				case 2:
					if(map[r+1][c] == 0) {
						r++;
						ableback = false;
						break xx;
					}
					break;
					
				case 3:
					if(map[r][c-1] == 0) {
						c--;
						ableback = false;
						break xx;
					}
					break;
				}
			}
			if(ableback) {
				cnt--;
				int back = (d + 2) % 4;
				boolean goback = false;
				switch(back) {
				case 0:
					if(map[r-1][c] != 1) {
						r--;
						goback = true;
					}
					break;
					
				case 1:
					if(map[r][c+1] != 1) {
						c++;
						goback = true;
					}
					break;	
					
				case 2:
					if(map[r+1][c] != 1) {
						r++;
						goback = true;
					}
					break;
					
				case 3:
					if(map[r][c-1] != 1) {
						c--;
						goback = true;
					}
					break;
				}
				if(!goback) {
					end = false;
				}
			}
		}
		System.out.println(cnt+1);
	}

}
