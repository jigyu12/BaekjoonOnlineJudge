package ´Þ¸®±â_2517;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

	private static int[] ar;
	private static int[] ans;
	private static int num;
	private static BufferedWriter bw;

	
	private static void search(int s, int e,int[] ar) {
		
		if(e == s) {
			return ;
		}
		
		else if((e - s) == 1) {
			if(ar[e] < ar[s]) {
				int temp = ar[s];
				ar[s] = ar[e];
				ar[e] = temp;
			}
			return;
		}
		
		else if((e-s) > 1) {
			int mid = (s + e) / 2;
			search(s,mid,ar);
			search(mid+1,e,ar);
		}
		
		for(int i = 0; i < e; i++) {
			for(int j = 0; j < e; j++) {
				
			}
		}
		
		for(int i = 0; i < ar.length; i++) {
			System.out.print(ar[i] + " ");
		}
		System.out.println();
		

	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			num = Integer.parseInt(br.readLine());
			ar = new int[num];
			ans = new int[num];
			for(int i = 0; i < num; i++) {
				ar[i] = Integer.parseInt(br.readLine());
			}
			ans[0] = 1;
			for(int i = 0; i < num; i++) {	
//				search(0,i,ar,ar[i]);
			}
			bw.flush();	
		} 
		catch (NumberFormatException | IOException e) {}
	}
}