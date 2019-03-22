package 신기한소수_2023;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	private static boolean[] sosu;
	private static int num;
	private static BufferedWriter bw;

	private static void find(int len, StringBuilder number) throws IOException {
		
		if(len == num) {
			bw.write(number.toString()+"\n");
			return;
		}
		
		for(int i = 0; i <= 9; i++) {
			number.append(String.valueOf(i));
			boolean nososu = false;
			int n = Integer.parseInt(number.toString());
			if(n <= 10000) {
				if(sosu[n]) {
					number.deleteCharAt(len);
					continue;
				}
			}
			else {
				for(int j = 2; j <= Math.sqrt(n); j++) {
					if(!sosu[j]) {
						if(n % j == 0) {
							number.deleteCharAt(len);
							nososu = true;
							break;
						}
					}
				}
			}
			if(nososu) {
				continue;
			}
			find(len+1,number);
			number.deleteCharAt(len);
		}
	}

	public static void main(String[] args) throws IOException, NumberFormatException {
		sosu = new boolean[10001];
		sosu[0] = true;
		sosu[1] = true;

		for (int i = 2; i <= 10000; i++) {
			if (!sosu[i]) {
				for (int j = i + i; j <= 10000; j += i) {
					sosu[j] = true;
				}
			}
		}
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));

		num = Integer.parseInt(br.readLine());
		find(0,new StringBuilder());
		
		bw.flush();
	}
}
