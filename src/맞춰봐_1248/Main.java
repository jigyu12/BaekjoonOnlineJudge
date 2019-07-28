package 맞춰봐_1248;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	private static int num;
	private static String[] s;
	private static int[] ar;
	private static String[] pm;
	private static boolean end;
	private static void find(int n) {
		
		if(n == num) {
			calcul();
			if(end) {
				return;
			}
			return ;
		}
		
		switch(pm[n]) {
		case "+":
			for(int i = 1; i <= 10; i++) {
				ar[n] = i;
				find(n+1);
				if(end) {
					return;
				}
			}
			break;
		case "-":
			for(int i = -10; i <= -1; i++) {
				ar[n] = i;
				find(n+1);
				if(end) {
					return;
				}
			}
			break;
		case "0":
			ar[n] = 0;
			find(n+1);
			if(end) {
				return;
			}
			break;
		}
	}
	
	private static void calcul() {
		int idx = 0;
		for(int i = 0; i < num; i++) {
			int sum = 0;
			for(int j = i; j < num; j++) {
				sum += ar[j];
				if(sum < 0 && !s[idx].equals("-")) {
					return ;
				}
				else if(sum == 0 && !s[idx].equals("0")) {
					return ;
				}
				
				else if(sum > 0 && !s[idx].equals("+")) {
					return ;
				}
				idx++;
			}
		}
		end = true;
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		num = Integer.parseInt(br.readLine());
		s = br.readLine().split("");
		ar = new int[num];
		pm = new String[num];
		end = false;
		int cal = num;
		int idx = 0;
		int plus = 0;
		while(cal >= 1) {
			pm[idx++] = s[plus];
			plus += cal--;
		}
//		
//		for(int i = 0; i < pm.length; i++) {
//			System.out.print(pm[i] + " ");
//		}
//		System.out.println();
//	
		
		find(0);
		for(int i = 0 ; i < ar.length; i++) {
			bw.write(ar[i] + " ");
		}
		bw.write("\n");
		bw.flush();
	}
}
