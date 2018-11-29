package °¨½Ã_15683;

import java.util.Scanner;

public class Main {
	private static int n;
	private static int m;
	private static int[][] ar;
	private static int[][] check;
	private static int min;
	private static int cnt;
	private static int[] cal;
	
	public static int dfs(int a) {
		int z = 0;
		if(a >= cnt) {
			draw();
			for(int i = 1; i < n+1; i++) {
				for(int j = 1; j < m+1; j++) {
					if(check[i][j] == 0 ) {
						z++;
					}				
				}
			}
			if(min > z) {
				min = z;
			}
			return 0;
		}
		for(int i = 0; i < 4; i++) {
			cal[a] = i;
			dfs(a+1);
		}
		return 0;
	}
	
	public static void draw() {
		int a = 0;
		check = new int[n+2][m+2];
		for(int i = 0; i < n+2; i++) {
			for(int j = 0; j < m+2; j++) {
				check[i][j] = ar[i][j];
			}
		}
		for(int i = 1; i < n+1; i++) {
			for(int j = 1; j < m+1; j++) {
				if(check[i][j] >= 1 && check[i][j] <= 5) {
					mode(a,i,j,check);
					a++;
				}
			}
		}
		
	}
	public static void mode(int a , int x, int y, int[][] ar) {
		switch(ar[x][y]) {
		case 1:
			switch(cal[a]) {
			case 0:
				left(x,y,ar);
				break;
			case 1:
				up(x,y,ar);
				break;
			case 2:
				right(x,y,ar);
				break;
			case 3:
				down(x,y,ar);
				break;
			}
			break;
		case 2:
			switch(cal[a]) {
			case 0:
				left(x,y,ar);
				right(x,y,ar);
				break;
			case 1:
				up(x,y,ar);
				down(x,y,ar);
				break;
			case 2:
				left(x,y,ar);
				right(x,y,ar);
				break;
			case 3:
				up(x,y,ar);
				down(x,y,ar);
				break;
			}
			break;
		case 3:
			switch(cal[a]) {
			case 0:
				left(x,y,ar);
				up(x,y,ar);
				break;
			case 1:
				up(x,y,ar);
				right(x,y,ar);
				break;
			case 2:
				right(x,y,ar);
				down(x,y,ar);
				break;
			case 3:
				down(x,y,ar);
				left(x,y,ar);
				break;
			}
			break;
		case 4:
			switch(cal[a]) {
			case 0:
				left(x,y,ar);
				up(x,y,ar);
				right(x,y,ar);
				break;
			case 1:
				up(x,y,ar);
				right(x,y,ar);
				down(x,y,ar);
				break;
			case 2:
				right(x,y,ar);
				down(x,y,ar);
				left(x,y,ar);
				break;
			case 3:
				down(x,y,ar);
				left(x,y,ar);
				up(x,y,ar);
				break;
			}
			break;
		case 5:
			switch(cal[a]) {
			case 0:
				left(x,y,ar);
				up(x,y,ar);
				right(x,y,ar);
				down(x,y,ar);
				break;
			case 1:
				left(x,y,ar);
				up(x,y,ar);
				right(x,y,ar);
				down(x,y,ar);
				break;
			case 2:
				left(x,y,ar);
				up(x,y,ar);
				right(x,y,ar);
				down(x,y,ar);
				break;
			case 3:
				left(x,y,ar);
				up(x,y,ar);
				right(x,y,ar);
				down(x,y,ar);
				break;
			}
			break;
		}
	}
	public static int left(int x,int y, int[][] arr) {
		if(arr[x-1][y] != 6) {
			if((arr[x-1][y] >= 1 && arr[x-1][y] <= 5) || arr[x-1][y] == 9) {
				left(x-1,y,arr);
				return 0;
			}
			arr[x-1][y] = 9;
			left(x-1,y,arr);
			return 0;
		}
		else if(arr[x-1][y] == 6) {
			return 0;
		}
		
		return 0;
	}
	public static int down(int x,int y, int[][] arr) {
		if(arr[x][y+1] != 6) {
			if((arr[x][y+1] >= 1 && arr[x][y+1] <= 5) || arr[x][y+1] == 9) {
				down(x,y+1,arr);
				return 0;
			}
			arr[x][y+1] = 9;
			down(x,y+1,arr);
			return 0;
		}
		else if(arr[x][y+1] == 6) {
			return 0;
		}
		
		return 0;
	}
	public static int right(int x,int y, int[][] arr) {
		if(arr[x+1][y] != 6) {
			if((arr[x+1][y] >= 1 && arr[x+1][y] <= 5) || arr[x+1][y] == 9) {
				right(x+1,y,arr);
				return 0;
			}
			arr[x+1][y] = 9;
			right(x+1,y,arr);
			return 0;
		}
		else if(arr[x+1][y] == 6) {
			return 0;
		}
		
		return 0;
	}
	public static int up(int x,int y, int[][] arr) {
		if(arr[x][y-1] != 6) {
			if((arr[x][y-1] >= 1 && arr[x][y-1] <= 5) || arr[x][y-1] == 9) {
				up(x,y-1,arr);
				return 0;
			}
			arr[x][y-1] = 9;
			up(x,y-1,arr);
			return 0;
		}
		else if(arr[x][y-1] == 6) {
			return 0;
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		ar = new int[n+2][m+2];
		cnt = 0;
		min = n * m;
		for(int i = 0; i < n+2; i++) {
			for(int j = 0; j < m+2; j++) {
				if(i == 0 || i == n+1 || j == 0 || j == m+1) {
					ar[i][j] = 6;
					continue;
				}
				ar[i][j] = sc.nextInt();
				if(ar[i][j] >= 1 && ar[i][j] <= 5) {
					cnt++;
				}
			}
		}
		cal = new int[cnt];
		dfs(0);
		System.out.println(min);
	}
}