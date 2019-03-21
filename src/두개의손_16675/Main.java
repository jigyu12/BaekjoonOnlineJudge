package 두개의손_16675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int[] hands = new int[4];
		for(int i = 0; i < s.length; i++) {
			switch(s[i]) {
			case "R":
				hands[i] = 0;
				break;
			case "S":
				hands[i] = 1;
				break;
			case "P":
				hands[i] = 2;
				break;
			}
		}
		
		for(int i = 0; i <= 1; i++) {
			int mwin = 0;
			int twin = 0;
			for(int j = 2; j <= 3; j++) {
				if(hands[i] == hands[j]) {
					continue;
				}
				else {
					if(hands[i] == 0) {
						if(hands[j] == 1) {
							mwin++;
						}
						else {
							twin++;
						}
					}
					else if (hands[i] == 1) {
						if(hands[j] == 0) {
							twin++;
						}
						else {
							mwin++;
						}
					}
					else {
						if(hands[j] == 0) {
							mwin++;
						}
						else {
							twin++;
						}
					}
				}
			}
			if(mwin == 2) {
				System.out.println("MS");
				return ;
			}
		}
		
		for(int i = 2; i <= 3; i++) {
			int mwin = 0;
			int twin = 0;
			for(int j = 0; j <= 1; j++) {
				if(hands[i] == hands[j]) {
					continue;
				}
				else {
					if(hands[i] == 0) {
						if(hands[j] == 1) {
							twin++;
						}
						else {
							mwin++;
						}
					}
					else if (hands[i] == 1) {
						if(hands[j] == 0) {
							mwin++;
						}
						else {
							twin++;
						}
					}
					else {
						if(hands[j] == 0) {
							twin++;
						}
						else {
							mwin++;
						}
					}
				}
			}
			if(twin == 2) {
				System.out.println("TK");
				return ;
			}
		}
		System.out.println("?");
	}
}
