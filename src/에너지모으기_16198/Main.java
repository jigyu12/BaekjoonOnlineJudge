package 에너지모으기_16198;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	private static int num;
	private static ArrayList<Integer> ar;
	private static int ans;
	
	private static void find(int i, int count, int val) {
		
		if(ar.size() <= 3) {
			int v = val + (ar.get(i-1) * ar.get(i+1));
			if(ans < v) {
				ans = v;
			}
			return;
		}
		
		int v = val + (ar.get(i-1) * ar.get(i+1));
		int re = ar.remove(i);
		for(int j = 1; j < ar.size()-1; j++) {
			find(j,count+1,v);
		}
		ar.add(i, re);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		ans = -1;
		ar = new ArrayList<>();
		String[] s = br.readLine().split(" ");
		for(int i = 0; i < num; i++) {
			ar.add(Integer.parseInt(s[i]));
		}
		
		for(int i = 1; i < num-1; i++) {
			find(i,0,0);
		}
		
		System.out.println(ans);
	}
}
