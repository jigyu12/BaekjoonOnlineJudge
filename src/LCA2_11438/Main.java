package LCA2_11438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	 
	private static ArrayList<Integer>[] ar;
	private static int[] depth;

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int n = Integer.parseInt(br.readLine());
			ar = new ArrayList[n+1];
			depth = new int[n+1];
			for(int i = 0; i < n; i++) {
				ar[i] = new ArrayList<Integer>();
			}
			for(int i = 0; i < n; i++) {
				String[] s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				ar[a].add(b);
			}
			
		} catch (NumberFormatException | IOException e) {
		}
		
	}

}
