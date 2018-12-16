package 크로아티아알파벳_2941;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String[] word = br.readLine().split("");
			int count = 0;
			for(int i = 0; i < word.length; i++) {
				boolean check = false;
				boolean check2 = false;
				if(i < word.length-2) {
					String s = word[i] + word[i+1] + word[i+2];
					switch(s) {
					case "dz=" :
						count++;
						check = true;
						check2 = true;
						i+=2;
						break;
					}
				}
				if(i < word.length-1 && !check2) {
					String s = word[i] + word[i+1];
					switch(s) {
					case "c=" : case "c-" : case "dz=" : case "d-" : case "lj" :
					case "nj" : case "s=" : case "z=" :
						count++;
						check = true;
						i++;
						break;
					}
				}

				if(!check) {
					switch(word[i]) {
					case "a" : case "b" : case "c" : case "d" : case "e" :
					case "f" : case "g" : case "h" : case "i" : case "j" : 
					case "k" : case "l" : case "m" : case "n" : case "o" :
					case "p" : case "q" : case "r" : case "s" : case "t" : 
					case "u" : case "v" : case "w" : case "x" : case "y" :
					case "z" :
						count++;
						break;
					}
				}		
			}
			System.out.println(count);
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 	
}
