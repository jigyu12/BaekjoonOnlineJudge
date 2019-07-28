package 수정렬하기2_2751;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private static int[] ar;
	private static int[] sort;
	private static int num;
	
	private static void quickSort(int start, int end) {
		if(start >= end) {
			return ;
		}
		
		int i = start + 1, j = end, key = start;
		
		while(i <= j) {
			while(i <= end && ar[i] < ar[key]) {
				i++;
			}
			
			while(j >= start+1 && ar[j] >= ar[key]) {
				j--;
			}
			
			if(i <= j) {
				int temp = ar[i];
				ar[i] = ar[j];
				ar[j] = temp;
			}
			else {
				int temp = ar[key];
				ar[key] = ar[j];
				ar[j] = temp;
			}
		}

		quickSort(start, j-1);
		quickSort(j+1, end);
	}
	
	private static void mergeSort(int start, int end) {
		
		if(start >= end) {
			return ;
		}
		
		int mid = (start + end) / 2;
		
		mergeSort(start, mid);
		mergeSort(mid+1, end);
		
		int i = start, j = mid+1, p = start;
		while(i <= mid && j <= end) {
			if(ar[i] < ar[j]) {
				sort[p++] = ar[i++];
			}
			else {
				sort[p++] = ar[j++];
			}
		}
		
		if(i <= mid) {
			for(int k = i; k <= mid; k++) {
				sort[p++] = ar[k];
			}
		}
		else {
			for(int k = j; k <= end; k++) {
				sort[p++] = ar[k];
			}
		}
		
		for(int k = start; k <= end; k++) {
			ar[k] = sort[k];
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		num = Integer.parseInt(br.readLine());
		ar = new int[num];
		sort = new int[num];
		for(int i = 0; i < num; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		mergeSort(0, num-1);
//		quickSort(0, num-1);
		
		for(int i = 0; i < num; i++) {
			bw.write(ar[i]+"\n");
		}
		bw.flush();
	}
}
