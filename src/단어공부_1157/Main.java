package 단어공부_1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String word = br.readLine();
			int[] ar = new int[26];
			for(int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if(c >= 65 && c <= 90) {
					ar[c-65]++;
				}
				else if(c >= 97 && c <= 122) {
					ar[c-97]++;
				}
			}
			int count = 0;
			int index = -1;
			int max = -1;
			for(int i = 0; i < ar.length; i++) {
				if(ar[i] >= max) {
					max = ar[i];
					index = i;
				}
			}
			for(int i = 0; i < ar.length; i++) {
				if(ar[i] == max) {
					count++;
				}
			}
			
			if(count == 1) {
				System.out.printf("%c",index+65);
			}
			else if(count >= 2) {
				System.out.println("?");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
