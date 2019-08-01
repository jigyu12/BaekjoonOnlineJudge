package 외판원순회_2098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] map;
	static int[][] path;
	static int ans;
	static int n;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
		path = new int[n][1 << n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine().trim());
			for(int j = 0; j < n; j++) {
				int in = Integer.parseInt(st.nextToken());
				map[i][j] = in;
			}
		}
		
		for(int i = 0 ; i < n; i++) {
			for(int j = 0 ; j < (1 << n); j++) {
				path[i][j] = 1000000000;
			}
		}
		
		ans = permutation(0,1);
		System.out.println(ans);
	}

	static int permutation(int cur, int state) {
		
		if(state == (1 << n) - 1) {
			return map[cur][0] == 0 ? 1000000000 : map[cur][0];
		}
		
		if(path[cur][state] != 1000000000) {
			return path[cur][state];
		}
		
		for(int i = 0; i < n; i++) {
			if((state & (1 << i)) == 0 && map[cur][i] != 0) {
				path[cur][state]= Math.min(path[cur][state], permutation(i, state | (1 << i)) + map[cur][i] );
			}
		}
		
		return path[cur][state];
	}
}