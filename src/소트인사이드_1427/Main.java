package 소트인사이드_1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int num[];
	
	private static void QuickSort(int start, int end) {
		if(start >= end) {
			return ;
		}
		
		int l = start - 1, r = end + 1;
		int pivot = num[(l+r) / 2];
		
		while(true) {
			while(num[++l] > pivot);
			while(num[--r] < pivot);
			if (l >= r) break;
			int temp = num[l];
			num[l] = num[r];
			num[r] = temp;
		}
		
		QuickSort(start, l-1);
		QuickSort(r+1, end);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split("");
		num = new int[s.length];
		for(int i = 0; i < s.length; i++) {
			num[i] = Integer.parseInt(s[i]);
		}
		
		QuickSort(0, num.length-1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length; i++) {
			sb.append(num[i]);
		}
		System.out.println(sb.toString());
	}
}
