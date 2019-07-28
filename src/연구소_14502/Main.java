package 연구소_14502;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	private static int n;
	private static int m;
	private static int max;
	private static int count;
	private static ArrayList<int[]> al;
	private static int[][] comp;
	
	public static void dfs(int x, int y) {
		comp[x][y] = 2;
		if( comp[x - 1][y] == 0 ) {
			dfs(x-1,y);
		}
		if( comp[x + 1][y] == 0) {
			dfs(x+1,y);
		}
		if( comp[x][y - 1] == 0) {
			dfs(x,y - 1);
		}
		if( comp[x][y+1] == 0) {
			dfs(x,y+1);
		}
	}
	
	public static int zero(int[][] arr, int c) {
		if(c == 3) {
			comp = new int[n+2][m+2];
			for(int h = 0; h < n+2; h++) {
				for(int g = 0; g < m+2; g++) {
					comp[h][g] = arr[h][g];
				}
			}
			for(int i = 0; i < al.size(); i++) {
				int[] ar = al.get(i);
				dfs(ar[0],ar[1]);
			}
			for(int k = 1; k < n+1; k++) {
				for(int x = 1; x < m+1; x++) {
					if(comp[k][x] == 0) {
						count++;
					}
				}
			}
			if(max < count) {
				max = count;
			}
			count = 0;
			return 0;
		}
		
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				int[][] xx = arr;
				
				if(xx[i][j] == 0) {
					xx[i][j] = 1;
					zero(xx,c+1);
					xx[i][j] = 0;
				}
//				for(int h = 0; h < n+2; h++) {
//					for(int g = 0; g < m+2; g++) {
//						System.out.print(xx[h][g]);;
//					}
//					System.out.println();
//				}
//				System.out.println();
			}
		}
		return 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] ar = new int[n+2][m+2];
		
		max = 0;
		al = new ArrayList<int[]>();
		for(int i = 0; i < n+2; i++) {
			for(int j = 0; j < m+2; j++) {
				if(i == 0 || i == n+1 || j == 0 || j == m+1) {
					ar[i][j] = 1;
					continue;
				}
				ar[i][j] = sc.nextInt();
				if(ar[i][j] == 2) {
					int[] arr = new int[2];
					arr[0] = i;
					arr[1] = j;
					al.add(arr);
				}
			}
		}
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				if(ar[i][j] == 0) {
					ar[i][j] = 1;
					zero(ar,1);
					ar[i][j] = 0;
				}
			}
		}
		System.out.println(max);
		max = 0;
	}
}
