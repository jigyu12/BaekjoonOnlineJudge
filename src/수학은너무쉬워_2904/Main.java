package 수학은너무쉬워_2904;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
	
	static class Div{
		int num;
		int count;
		boolean visit;
		
		public Div(int num, int count) {
			this.num = num;
			this.count = count;
			this.visit = false;
		}

		@Override
		public String toString() {
			return "Div [num=" + num + ", count=" + count + "]";
		}
		
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			boolean[] b = new boolean[1000001];
			b[0] = true;
			b[1] = true;
			for(int i = 2; i < b.length; i++) {
				if(!b[i]) {
					for(int j = i+i; j < b.length; j++) {
						if(!b[j]) {
							b[j] = true;
						}
					}
				}
			}
			
			int n = Integer.parseInt(br.readLine());
			int[] map = new int[n];
			ArrayList<Div>[] ar = new ArrayList[n];
			String[] s = br.readLine().split(" ");
			for(int i = 0; i < n; i++) {
				map[i] = Integer.parseInt(s[i]);
				ar[i] = new ArrayList<Div>();
			}
			Arrays.sort(map);
			HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
			for(int i = 0; i < n; i++) {
				int num = map[i];
				for(int j = 2; j < b.length; j++) {
					if(!b[j]) {
						int count = 0;
						if(num % j != 0) {
							continue;
						}
						while(num > 1) {
							if(num % j != 0) {
								break;
							}
							num /= j;
							count++;
						}
						ar[i].add(new Div(j,count));
						if(!hm.containsKey(j)) {
							hm.put(j, count);
						}
						else {
							int c = hm.get(j);
							c += count;
							hm.put(j,c);
						}
					}
					if(num == 1) {
						break;
					}
				}
			}
//			for(int i = 0; i < ar.length; i++) {
//					System.out.println(ar[i]);
//			}
			Iterator<Integer> it = hm.keySet().iterator();
			while(it.hasNext()) {
				int key = it.next();
				int v = hm.get(key);
				v /= n;
//				System.out.println(key + " " + v);
				hm.put(key, v);
			}
			int ans = 0;
			for(int i = 0; i < n; i++) {
				it = hm.keySet().iterator();
				while(it.hasNext()) {
					int key = it.next();
					int v = hm.get(key);
					if(v == 0) {
						continue;
					}
					boolean in = false;
					for(int j = 0; j < ar[i].size(); j++) {
						if(!ar[i].get(j).visit && ar[i].get(j).num == key) {
							in = true;
							ar[i].get(j).visit = true;
							if(ar[i].get(j).count < v) {
								ans += v - ar[i].get(j).count;
							}
						}
					}
					if(!in) {
						ans += v;
					}
				}
			}
			it = hm.keySet().iterator();
			long cal = 1;
			while(it.hasNext()) {
				long key = it.next();
				long v = hm.get((int)key);
				if(v == 0) {
					continue;
				}
				cal *= (long)(key * v);
			}
			System.out.println(cal + " " + ans);

		} catch (NumberFormatException | IOException e) {
		}
	}
}
