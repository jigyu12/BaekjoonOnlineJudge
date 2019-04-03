package ¼û¹Ù²ÀÁú2_12851;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Subin{
		int x;
		int count;
		
		public Subin(int x, int count) {
			this.x = x;
			this.count = count;
		}

		@Override
		public String toString() {
			return "Subin [x=" + x + ", count=" + count + "]";
		}

	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nk = br.readLine().split(" ");
		boolean[][] visited = new boolean[3][100001];
		int[] ar = new int[100001];
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		
		Arrays.fill(ar, 100001);
		
		Queue<Subin> qu = new LinkedList<>();
		qu.add(new Subin(n,0));
		int ans = 100001;
		int count = 1;
		while(!qu.isEmpty()) {
			Subin s = qu.poll();
			int sx = s.x;
			int sc = s.count;
			
			if(sx == k) {
				if(ans >= sc) {
					if(ans > sc) {
						ans = sc;
						count = 1;
						continue;
					}
					count++;
				}
				continue;
			}
			
			if(ans < sc) {
				continue;
			}
			
			if(sx > 0 && ar[sx-1] >= sc) {
				qu.add(new Subin(sx-1,sc+1));
				ar[sx-1] = sc;
			}
			
			if(sx < 100000 && ar[sx+1] >= sc) {
				qu.add(new Subin(sx+1,sc+1));
				ar[sx+1] = sc;
			}
			
			if(sx <= 50000 && ar[sx * 2] >= sc ) {
				qu.add(new Subin(sx * 2,sc+1));
				ar[sx*2] = sc;
			}
		}
		System.out.println(ans);
		System.out.println(count);
	}
}
