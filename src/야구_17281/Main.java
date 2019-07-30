package 야구_17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int[] order = new int[9];
	static int[][] player;
	static int n;
	static int ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
	
		StringTokenizer st;
		ans = 0;
		
		player = new int[n][9];
		
		for(int t = 0; t < n; t++) {
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 9; i++) {
				player[t][i] = Integer.parseInt(st.nextToken());
			}
		}
		
		permutation(1, 0);
		System.out.println(ans);
	}
	
	static void permutation(int status, int c) {
		int cnt = c;
		if(cnt == 3) {
			++cnt;
		}
	
		if(cnt == 9) {
			playgame();
			return ;
		}
		
		for(int i = 1; i < 9; i++) {
			if((status & (1 << i)) == 0) {
				order[cnt] = i;
				permutation(status | (1 << i), cnt+1);
			}
		}
	}

	static void playgame() {
		int pidx = 0;
		int score = 0;
		
		for(int t = 0; t < n; t++) {
			int out = 0;
			Queue<Integer> qu = new LinkedList<>();
			while(out < 3) {
				int num = player[t][order[pidx]];
				if(num == 0) {
					++out;
				}
				else if(num < 4){
					int size = qu.size();
					for(int i = 0; i < size; i++) {
						int in = qu.poll();
						in += num;
						if(in > 3) {
							++score;
						}
						else {
							qu.add(in);
						}
					}
					qu.add(num);
				}
				else {
					score += qu.size() + 1;
					qu.clear();
				}
				
				pidx++;
				pidx %= 9;
				
				if(out == 3) {
					break;
				}
				
			}
		}
		if(ans < score) {
			ans = score;
		}
	}

}
