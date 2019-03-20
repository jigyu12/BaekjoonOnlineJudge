package 좋은수열_2661;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int num;
	private static String ans;
	private static boolean find;
	
	private static void find(int n, String s) {
		
		StringBuilder sb = new StringBuilder(s);
		
		int len = sb.length()-1;
		int idx = 1;
		for(int i =len; i >= (len / 2) + 1; i--) {
			boolean same = true;
			int comp = len;
			for(int j = len-idx; j >= len - (2 * idx) + 1; j--) {
				if(sb.charAt(comp) != sb.charAt(j)) {
					same = false;
				}
				comp--;
			}
			idx++;
			if(same) {
				return ;
			}
		}
		
		if(n == num) {
			ans = s;
			find = true;
			return ;
		}
		
		
		for(int i = 1; i <= 3; i++) {
			sb.append(i);
			find(n+1,sb.toString());
			if(find) {
				return ;
			}
			sb.delete(n, n+1);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		num = Integer.parseInt(br.readLine());
		find = false;
		ans = "";
		if(num == 1) {
			ans = "1";
		}
		else if(num == 2) {
			ans = "12";
		}
		else if(num == 3) {
			ans = "121";
		}
		else {
			find(3,"121");
		}
		System.out.println(ans);
	}

}
