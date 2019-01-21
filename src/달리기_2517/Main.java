package ´Þ¸®±â_2517;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

	private static int[] ar;
	private static int[] ans;
	private static int num;
	private static ArrayList<Integer> comp;
	
	private static void search(int s, int e,int num) {
		int start = s;
		int end = e;
		int mid = 0;
		
//		for(int i = 0; i <= e; i++) {
//			System.out.print(comp[i] + " ");
//		}
//		System.out.println();
		
		while(start <= end) {
			mid = (start + end) / 2;
			
			if(comp.get(mid) > num) {
				end = mid-1;
			}
			else{
				start = mid + 1;
			}		
		}
//		System.out.println(mid + " " + start);

		comp.add(start, num);
//		for(int i = 0; i < comp.size(); i++) {
//			System.out.print(comp.get(i) + " ");
//		}
//		System.out.println();
//		System.out.println(start);
//		System.out.println("------------");
		ans[e+1] = e - start + 2;
	}
	
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			num = Integer.parseInt(br.readLine());
			ar = new int[num];
			ans = new int[num];
			comp = new ArrayList<>();
			for(int i = 0; i < num; i++) {
				int a = Integer.parseInt(br.readLine());
				ar[i] = a;
			}
			
			comp.add(ar[0]);
			
			for(int i = 1; i < num; i++) {	
				search(0,i-1,ar[i]);
			}
			ans[0] = 1;
			for(int i = 0; i < num; i++) {
				bw.write(ans[i]+"\n");

//				System.out.println(ans[i]);
			}
			bw.flush();
		} 
		catch (NumberFormatException | IOException e) {}
	}
}