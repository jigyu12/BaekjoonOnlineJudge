package 달리기_2517;

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

	
	private static void search(int s, int e, int num) {
		
		int start = s;
		int end = e;
		int mid = 0;
		
		while(start <= end) {
			mid = (start + end) / 2;
			if(ar[mid] > num) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}

	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			num = Integer.parseInt(br.readLine());
			ar = new int[500000];
			ans = new int[500000];
			for(int i = 0; i < num; i++) {
				ar[i] = Integer.parseInt(br.readLine());
			}
			ans[0] = 1;
			for(int i = 0; i < num; i++) {	
				
			}
			bw.flush();	
		} 
		catch (NumberFormatException | IOException e) {}
	}
}