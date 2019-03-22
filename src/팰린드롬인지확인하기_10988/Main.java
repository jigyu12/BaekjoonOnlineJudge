package 팰린드롬인지확인하기_10988;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int len = s.length();
		int ans = 1;
		for(int i = 0; i < len; i++) {
			for(int j = 0; j <= 7; j++) {
				if((s.charAt(i) & (1 << j)) != (s.charAt(len-1-i) & (1 << j))) {
					ans = 0;
					break;
				}
			}
		}
		System.out.println(ans);
	}

}
