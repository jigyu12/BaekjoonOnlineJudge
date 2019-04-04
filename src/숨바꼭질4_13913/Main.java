package ¼û¹Ù²ÀÁú4_13913;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
	
	private static BufferedWriter bw;
	private static int n;
	private static int k;
	private static int[] route;
	
	private static void ansPrint(int i) throws IOException {
		if(i == n) {
			bw.write(i + " ");
			return ;
		}
		
		ansPrint(route[i]);
		bw.write(i + " ");
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] nk = br.readLine().split(" ");
		int[] ar = new int[100001];
		n = Integer.parseInt(nk[0]);
		k = Integer.parseInt(nk[1]);
		route = new int[100001];
		
		Arrays.fill(ar, 100001);
		
		Queue<Subin> qu = new LinkedList<>();
		qu.add(new Subin(n,0));
		int ans = 100001;
		while(!qu.isEmpty()) {
			Subin s = qu.poll();
			int sx = s.x;
			int sc = s.count;
			
			if(sx == k) {
				if(ans >= sc) {
					if(ans > sc) {
						ans = sc;
						continue;
					}
				}
				continue;
			}
			
			if(ans < sc) {
				continue;
			}
			
			if(sx > 0 && ar[sx-1] >= sc) {
				qu.add(new Subin(sx-1,sc+1));
				ar[sx-1] = sc;
				route[sx-1] = sx;
			}
			
			if(sx < 100000 && ar[sx+1] >= sc) {
				qu.add(new Subin(sx+1,sc+1));
				ar[sx+1] = sc;
				route[sx+1] = sx;
			}
			
			if(sx <= 50000 && ar[sx * 2] >= sc ) {
				qu.add(new Subin(sx * 2,sc+1));
				ar[sx*2] = sc;
				route[sx * 2] = sx;
			}
		}
		bw.write(ans + "\n");
		ansPrint(k);
		bw.flush();
		bw.close();
	}
}

