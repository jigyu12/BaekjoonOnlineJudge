package 진짜메시지_9324;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int testCnt = Integer.parseInt(br.readLine());
		
		for(int test = 0; test < testCnt; test++) {
			String msg = br.readLine();
			int[] cnt = new int[26];
			boolean isFake = true;
			
			for(int idx = 0; idx < msg.length(); idx++) {
				char letter = msg.charAt(idx);
				cnt[letter-65]++;
				if(cnt[letter-65] == 3) {
					cnt[letter-65] = 0;
					if(idx + 1 >= msg.length() 
							|| msg.charAt(idx+1) != letter) {
						isFake = false;
						break;
					}
					idx++;
				}
			}
			if(!isFake) {
				sb.append("FAKE\n");
				continue;
			}
			sb.append("OK\n");
		}
		System.out.println(sb.toString());
	}
}
