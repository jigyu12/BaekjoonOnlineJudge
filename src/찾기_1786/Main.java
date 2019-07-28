package 찾기_1786;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] s1 = br.readLine().split("");
			String[] s2 = br.readLine().split("");
			
			String[] t = new String[1000002];
			ArrayList<Integer> ans = new ArrayList<Integer>();
			for(int i = 1; i <= s1.length; i++) {
				t[i] = s1[i-1];
			}
			String[] p = new String[1000002];
			for(int i = 1; i <= s2.length; i++) {
				p[i] = s2[i-1];
			}
			int[] f = new int[1000001];
			f[0] = -1;
			f[1] = 0;
			for(int i = 1,j = 0; i < s2.length; i++) {
				while(!p[i+1].equals(p[j+1]) && j != 0) {
					j= f[j];
				}
				if(p[i+1].equals(p[j+1])) {
					j++;
				}
				f[i+1] = j;
			}
			for(int i = 0, j = 0; i < s1.length; i++) {
				while(!t[i+1].equals(p[j+1]) && j != 0) {
					j = f[j];
				}
				if(t[i+1].equals(p[j+1])) {
					j++;
				}
				if(j == s2.length) {
					ans.add(i-s2.length+2);
				}
			}
			System.out.println(ans.size());
			for(int i = 0; i < ans.size(); i++) {
				System.out.print(ans.get(i) + " ");
			}
//			for(int i = 1; i < s2.length+1; i++) {
//				System.out.print(f[i] + " ");
//			}
		} catch (IOException e) {
		}
	}
}
