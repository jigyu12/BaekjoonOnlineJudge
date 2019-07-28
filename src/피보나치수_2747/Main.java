package 피보나치수_2747;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	private static int[] ar;
	private static int num;
	private static int fibonacci(int n) {
		
		if(ar[n] > -1) {
			return ar[n];
		}

		return ar[n] = fibonacci(n-1) + fibonacci(n-2);
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ar = new int[47];
		num = Integer.parseInt(br.readLine());
		Arrays.fill(ar, -1);
		ar[0] = 0;
		ar[1] = 1;
		System.out.println(fibonacci(num));
	}
}
