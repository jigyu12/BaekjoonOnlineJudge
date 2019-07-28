package ox퀴즈_8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int num = Integer.parseInt(br.readLine());
			for(int i = 0; i < num; i++) {
				String[] s = br.readLine().split("");
				int count = 1;
				int score = 0;
				for(int j = 0; j < s.length; j++) {
					if(s[j].equals("O")) {
						score += count++;
					}
					else {
						count = 1;
					}
				}
				System.out.println(score);
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
