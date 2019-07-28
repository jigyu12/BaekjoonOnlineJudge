package 나이순정렬_10814;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	
	private static People[] ar;
	private static People[] buf;
	
	static class People{
		int age;
		String name;
		int num;
		
		public People(int age, String name, int num) {
			this.age = age;
			this.name = name;
			this.num = num;
		}

		

		@Override
		public String toString() {
			return age + " " + name;
		}

	}
	
	private static void mergeSort(int start, int end) {
		if(start >= end) return;
		
		int mid = (start + end) / 2;
		int i = start, j = mid+1, k = start;
		
		mergeSort(start, mid);
		mergeSort(mid+1, end);
		
		while(i <= mid && j <= end) {
			if(ar[i].age < ar[j].age) {
				buf[k++] = ar[i++];
			}
			else if(ar[i].age > ar[j].age) {
				buf[k++] = ar[j++];
			}
			else {
				if(ar[i].num < ar[j].num) {
					buf[k++] = ar[i++];
				}
				else {
					buf[k++] = ar[j++];
				}
			}
		}
		
		while(i <= mid) buf[k++] = ar[i++];
		while(j <= end) buf[k++] = ar[j++];
		
		k = start;
		
		while(k <= end) ar[k] = buf[k++];
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int p = Integer.parseInt(st.nextToken());
		ar = new People[p];
		buf = new People[p];
		
		for(int i = 0; i < p; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			ar[i] = new People(Integer.parseInt(st.nextToken()), st.nextToken(), i);
		}
		mergeSort(0, p-1);
		for(int i = 0; i < p; i++) {
			bw.write(ar[i].toString()+"\n");
		}
		bw.flush();
	}
}
