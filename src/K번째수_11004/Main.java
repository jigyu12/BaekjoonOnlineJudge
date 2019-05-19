package K¹øÂ°¼ö_11004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[] num;

	private static void QuickSort(int start, int end) {
		if(start >= end) {
			return ;
		}
		
		int l = start - 1, r = end + 1;
		int pivot = num[(l+r) / 2];
		
		while(true) {
			while(num[++l] < pivot);
			while(num[--r] > pivot);
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
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken()) - 1;
		num = new int[n];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		QuickSort(0, n - 1);
//		for (int i = 0; i < n; i++) {
//			System.out.print(num[i] + " ");
//		}
//		System.out.println();
		System.out.println(num[k]);
	}
}
