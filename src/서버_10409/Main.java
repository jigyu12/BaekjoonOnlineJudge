package 서버_10409;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] nt = br.readLine().split(" ");
		
		int n = Integer.parseInt(nt[0]);
		int t = Integer.parseInt(nt[1]);
		
		String[] s = br.readLine().split(" ");
		int sum = 0, ans = 0;
		
		for(int i = 0; i < n; i++) {
			sum += Integer.parseInt(s[i]);
			if(sum > t) {
				ans = i;
				break;
			}
		}
		
		if(ans == 0) {
			if(sum <= t) {
				ans = n;
			}
		}
		System.out.println(ans);
	}
}
