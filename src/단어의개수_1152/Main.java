package 단어의개수_1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] s = br.readLine().split(" ");
			int cnt = 0;
			for(int i = 0; i < s.length; i++) {
				if(!s[i].equals("")) {
					cnt++;
				}
			}
			System.out.println(cnt);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
