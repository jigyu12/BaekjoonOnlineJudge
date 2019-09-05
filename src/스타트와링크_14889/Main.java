package 스타트와링크_14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int n;
	static int map[][];
	static int start[];
	static int link[];
	static int ans;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		ans = Integer.MAX_VALUE;
		start = new int[ n/2 ];
		link = new int[ n/2 ];
		for(int i = 0; i < n; i++) {
			String[] s = br.readLine().split(" ");
			for(int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(s[j]);
				if(j < i) {
					map[i][j] += map[j][i];
					map[j][i] = 0;
				}
			}
		}
		
//		for(int i = 0; i < n; i++) {
//			for(int j = 0; j < n; j++) {
//				System.out.print(map[i][j]+ " ");
//			}
//			System.out.println();
//		}
//		System.out.println();
		permutation(0,0,0);
		System.out.println(ans);
	}

	private static void permutation(int state, int count,int st) {
		if(ans == 0) {
			return;
		}
		if(count == n / 2) {
			int s = 0, l = 0;
			for(int i = 0; i < n; i++) {
				if((state & (1 << i)) != 0) {
					start[s++] = i;
				}
				else {
					link[l++] = i;
				}
			}
			cal();
			return;
		}
		
		for(int i = st; i < n; i++) {
			if((state & (1 << i)) == 0) {
				permutation(state | (1 << i), count + 1,i);
			}
		}
		
	}

	private static void cal() {
		int idx = n / 2;
		int s = 0, l = 0;
		for(int i = 0; i < idx; i++) {
			for(int j = i+1; j < idx; j++) {
				s += map[start[j]][start[i]];
				l += map[link[j]][link[i]];
			}
		}
		
		if(ans > Math.abs(s-l)) {
			ans = Math.abs(s-l);
		}
	}

}
