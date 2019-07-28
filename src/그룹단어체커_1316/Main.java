package 그룹단어체커_1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int num = Integer.parseInt(br.readLine());
			int count = 0;
			for(int i = 0; i < num; i++) {
				int[] ar = new int[26];
				String word = br.readLine();
				boolean check = false;
				for(int j = 0; j < word.length(); j++) {
					char c = word.charAt(j);
					if(j == 0) {
						ar[c-97]++;
						continue;
					}
					char cc = word.charAt(j-1);
					if(cc != c && ar[c-97] != 0) {
						
						check = true;
						continue;
					}
					ar[c-97]++;
				}
				if(!check) {
					count++;
				}
			}
			System.out.println(count);
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
