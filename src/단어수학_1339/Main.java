package 단어수학_1339;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	static class Alphabet implements Comparable<Alphabet>{
		int alpha;

		
		public Alphabet(int alpha) {
			this.alpha = alpha;

		}

		@Override
		public String toString() {
			return "Alphabet [alpha=" + alpha + "]";
		}

		public int compareTo(Alphabet a) {
			for(int i = 7; i >= 0; i--) {
				if(count[this.alpha][i] == count[a.alpha][i]) {
					continue;
				}
				else {
					if(count[this.alpha][i] > count[a.alpha][i]) {
						return -1;
					}
					else {
						return 1;
					}
				}
			}
			return 0;
		}
	}
	private static int[][] count;

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Alphabet[] ar = new Alphabet[26];
		int[] convert = new int[26];
		count = new int[26][8];
		
		for(int i = 0; i < 26; i++) {
			ar[i] = new Alphabet(i);
		}
		
		Arrays.fill(convert,-1);
		int num = Integer.parseInt(br.readLine());
		String[] input = new String[num];
		for(int i = 0; i < num; i++) {
			input[i] = br.readLine();
			int idx = 0;
			for(int j = input[i].length() - 1; j >= 0; j--) {
				int a = input[i].charAt(j) - 65;
				count[a][idx]++;
				idx++;
			}
		}

		Arrays.sort(ar);
		
		int n = 9;
		for(int i = 0; i < 26; i++) {
			if(n < 0) {
				break;
			}
			convert[ar[i].alpha] = n;
			n--;
		}
		long ans = 0;
		for(int i = 0; i < num; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j = 0; j < input[i].length() ; j++) {
				sb.append(convert[input[i].charAt(j) - 65]);
			}
			ans += Long.parseLong(sb.toString());
		}
		System.out.println(ans);
	}
}
