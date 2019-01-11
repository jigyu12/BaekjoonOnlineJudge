package 가장긴증가하는부분수열_11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[] ar;
	static int[] lis;
	static int[] prev;
	
	public static int print(int p) {
		if(p < 0) {
			return -1;
		}
		print(prev[p]);
		System.out.print(ar[p] + " ");
		return 0;
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int num = Integer.parseInt(br.readLine());
			String[] s = br.readLine().split(" ");
			ar = new int[num];
			lis = new int[num];
			prev = new int[num];
			for(int i = 0; i < num; i++) {
				ar[i] = Integer.parseInt(s[i]);
			}
			int last = 0;
			int len = 1;
			for(int i = 0 ; i < num; i++) {
				lis[i] = 1;
				prev[i] = -1;
				for(int j = 0; j < i; j++) {
					if(ar[j] > ar[i]) {
						continue;
					}
					
					if(lis[i] < lis[j] + 1) {
						lis[i] = lis[j] + 1;
						last = i;
						prev[i] = j;
						if(len < lis[j]) {
							len = lis[j];
						}
					}
				}
			}
			print(last);
			for(int i = 0; i < num; i++) {
				System.out.print(lis[i] + " ");
			}
			System.out.println(len);
			System.out.println();
			System.out.println(lis[last]);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
