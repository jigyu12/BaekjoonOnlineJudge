package 힙정렬_2220;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private static int[] heap;
	private static int size;

	
	private static void swap(int j, int i) {
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] heap = {7,6,5,8,3,5,9,1,6};
		int n = 9;
		
		for(int i = 1; i < n; i++) {
			int child = i;
			
			do {
				int root = (child - 1) / 2;
				
				if(heap[child] < heap[root]) {
					int temp = heap[child];
					heap[child] = heap[root];
					heap[root] = temp;
				}
				
				child = root;
				
			} while(child != 0);
			
		}
		
		for(int i = n-1; i >= 0; i--) {
			
			int temp = heap[i];
			heap[i] = heap[0];
			heap[0] = temp;
			
			int root = 0;
			int child = 1;
			
			do {
				child = 2 * root + 1;
				
				if(child + 1 < i && heap[child] > heap[child+1]) {
					child++;
				}
				
				if(child < i && heap[root] > heap[child]) {
					temp = heap[root];
					heap[root] = heap[child];
					heap[child] = temp;
				}
				
				root = child;
			} while(child < i);
			
		}
		
		for(int i = 0; i < n; i++) {
			System.out.print(heap[i] + " ");
		}
		System.out.println();

	}
}
