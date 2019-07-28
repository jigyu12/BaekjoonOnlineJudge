package 일로만들기_1463;

import java.util.Scanner;

public class Main {
	
	private static int count;
	
	public static int dfs(int m, int cnt) {
		int n = m;
		if(cnt >= count) {
			return 0;
		}

		if(n <= 1) {
			if(cnt < count) {
				count = cnt;
				return 0;
			}
			return 0;
		}
		
		if(n % 3 == 0 && n >= 3) {
			n /= 3;
			cnt++;
			dfs(n, cnt);
			n *= 3;
			cnt--;
		}
		
		if(n % 2 == 0 && n >= 2) {
			n /= 2;
			cnt++;
			dfs(n, cnt);
			n *= 2;
			cnt--;
		}
		cnt++;
		dfs(n-1,cnt);
		return 0;
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		count = Integer.MAX_VALUE;
		dfs(num,0);
		System.out.println(count);
	}
}
