package 최소힙_1927;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	private static int[] heap;
	private static int size;
	
	private static void swap(int x, int y) {
		int temp = heap[x];
		heap[x] = heap[y];
		heap[y] = temp;
	}
	
	private static void add(int n) {
		heap[++size] = n;
		
		for(int i = size; i > 1; i /= 2) {
			if(heap[i] < heap[i / 2]) {
				swap(i,i/2);
			}
			else {
				break;
			}
		}
		
	}
	
	private static int delete() {
		
		if(size == 0) {
			return 0;
		}
		
		int data = heap[1];
		heap[1] = heap[size];
		heap[size--] = Integer.MAX_VALUE;
		
		for(int i = 1; i <= 2 * size;) {
			if(heap[i] < heap[i*2] && heap[i] < heap[i*2+1]) {
				break;
			}
			else if(heap[i*2] < heap[i*2+1]) {
				swap(i,i*2);
				i = i*2;
			}
			else {
				swap(i,i*2+1);
				i = i*2+1;
			}
		}
		
		return data;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int[] ar = new int[num];
		heap = new int[num * 4];
		size = 0;
		for(int i = 0; i < num; i++) {
			ar[i] = Integer.parseInt(br.readLine());
		}
		Arrays.fill(heap, Integer.MAX_VALUE);
		for(int i = 0; i < num; i++) {
			if(ar[i] == 0) {
				bw.write(delete()+"\n");
			}
			else {
				add(ar[i]);
			}
		}
		bw.flush();
	}
}
