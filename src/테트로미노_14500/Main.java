package 테트로미노_14500;

import java.util.Scanner;

public class Main {
	private static int n;
	private static int m;
	private static int[][] ar;
	private static int[][] check;
	private static int max;
	
	public static void shape(int a) {
		switch(a) {
		case 0:
			zero();
			break;
		case 1:
			one();
			break;
		case 2:
			two();
			break;
		case 3:
			three();
			break;
		case 4:
			four();
			break;
		}
	}
	
	public static void zero() {
		for(int i = 0; i < n-3; i++) {
			for(int j = 0; j < m; j++) {
				int a = ar[i][j] + ar[i+1][j] + ar[i+2][j] + ar[i+3][j];
				max = (max < a) ? a : max;
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m-3; j++) {
				int a = ar[i][j] + ar[i][j+1] + ar[i][j+2] + ar[i][j+3];
				max = (max < a) ? a : max;
			}
		}
	}
	
	public static void one() {
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < m-1; j++) {
				int a = ar[i][j] + ar[i+1][j] + ar[i][j+1] + ar[i+1][j+1];
				max = (max < a) ? a : max;
			}
		}
	}
	
	public static void two() {
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < m-2; j++) {
				int a = ar[i][j] + ar[i][j+1] + ar[i][j+2] + ar[i+1][j+2];
				max = (max < a) ? a : max;
				
				a = ar[i][j] + ar[i][j+1] + ar[i][j+2] + ar[i+1][j];
				max = (max < a) ? a : max;
				
				a = ar[i][j] + ar[i+1][j] + ar[i+1][j+1] + ar[i+1][j+2];
				max = (max < a) ? a : max;
				
				a = ar[i+1][j] + ar[i+1][j+1] + ar[i][j+2] + ar[i+1][j+2];
				max = (max < a) ? a : max;
			}
		}
		
		for(int i = 0; i < n-2; i++) {
			for(int j = 0; j < m-1; j++) {
				int a = ar[i][j] + ar[i+1][j] + ar[i+2][j] + ar[i][j+1] ;
				max = (max < a) ? a : max;
				
				a = ar[i][j] + ar[i+1][j] + ar[i+2][j] + ar[i+2][j+1];
				max = (max < a) ? a : max;
				
				a = ar[i+2][j] + ar[i][j+1] + ar[i+1][j+1] + ar[i+2][j+1];
				max = (max < a) ? a : max;
				
				a = ar[i][j] + ar[i][j+1] + ar[i+1][j+1] + ar[i+2][j+1];
				max = (max < a) ? a : max;
			}
		}
	}
	
	public static void three() {
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < m-2; j++) {
				int a = ar[i][j] + ar[i][j+1] + ar[i+1][j+1] + ar[i+1][j+2];
				max = (max < a) ? a : max;
				
				a = ar[i][j+1] + ar[i][j+2] + ar[i+1][j] + ar[i+1][j+1] ;
				max = (max < a) ? a : max;
				
			}
		}
		
		for(int i = 0; i < n-2; i++) {
			for(int j = 0; j < m-1; j++) {
				int a = ar[i][j] + ar[i+1][j] + ar[i+1][j+1] + ar[i+2][j+1] ;
				max = (max < a) ? a : max;
				
				a = ar[i+1][j] + ar[i+2][j] + ar[i][j+1] + ar[i+1][j+1];
				max = (max < a) ? a : max;
			}
		}
	}
	
	public static void four() {
		for(int i = 0; i < n-1; i++) {
			for(int j = 0; j < m-2; j++) {
				int a = ar[i][j] + ar[i][j+1] + ar[i][j+2] + ar[i+1][j+1];
				max = (max < a) ? a : max;
				
				a = ar[i][j+1] + ar[i+1][j] + ar[i+1][j+1] + ar[i+1][j+2] ;
				max = (max < a) ? a : max;
				
			}
		}
		
		for(int i = 0; i < n-2; i++) {
			for(int j = 0; j < m-1; j++) {
				int a = ar[i][j] + ar[i+1][j] + ar[i+2][j] + ar[i+1][j+1] ;
				max = (max < a) ? a : max;
				
				a = ar[i+1][j] + ar[i][j+1] + ar[i+1][j+1] + ar[i+2][j+1];
				max = (max < a) ? a : max;
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		ar = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ar[i][j] = sc.nextInt();
			}
		}
		for(int i = 0; i < 5; i++) {
			shape(i);
		}
		System.out.println(max);
	}
}
