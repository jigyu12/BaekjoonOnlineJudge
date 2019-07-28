package 상수_2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] s = br.readLine().split(" ");
			String[] w1 = s[0].split("");
			String[] w2 = s[1].split("");
			for(int i = 2; i > 0; i--) {
				if(Integer.parseInt(w2[i]) > Integer.parseInt(w1[i])) {
					for(int j = 2; j >= 0; j--) {
						System.out.print(w2[j]);
					}
					break;
				}
				else if(Integer.parseInt(w2[i]) < Integer.parseInt(w1[i])) {
					for(int j = 2; j >= 0; j--) {
						System.out.print(w1[j]);
					}
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
