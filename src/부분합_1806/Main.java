package ºÎºÐÇÕ_1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] ns = br.readLine().split(" ");
			int n = Integer.parseInt(ns[0]);
			int s = Integer.parseInt(ns[1]);
			
			int[] ar = new int[n];
			int sum = 0;
			String[] ss = br.readLine().split(" ");
			for(int i = 0; i < n; i++) {
				sum += Integer.parseInt(ss[i]);
				ar[i] = sum;
			}
//			for(int i = 0; i < n; i++) {
//				System.out.print(ar[i] + " ");
//			}
//			System.out.println();
			int len = 100000;
			for(int i = 0; i < n; i++) {
				for(int j = i; j < n; j++) {
					if(i == 0) {
						if(ar[j] >= s) {
							len = (j + 1);
							break;
						}
					}
					else {
						if(ar[j] - ar[i-1] >= s) {
//							System.out.println(j + " " + i);
							int k = j - i + 1;
							if(len > k) {
								
								len = k;
							}
							break;
						}
					}
				}
			}
			if(len == 100000) {
				len = 0;
			}
			System.out.println(len);
		} catch (IOException e) {
		}
	}
}
