package 수정렬하기3_10989;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		int[] count = new int[10001];
		int max = 0;
		for(int i = 0; i < num; i++) {
			int n = Integer.parseInt(br.readLine());
			count[n]++;
			if(n > max) {
				max = n;
			}
		}
		for(int i = 1; i <= max; i++) {
			if(count[i] > 0) {
				for(int j = 0; j < count[i]; j++) {
					bw.write(i+"\n");
				}
			}
		}
		bw.flush();
	}
}
