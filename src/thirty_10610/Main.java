package thirty_10610;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split("");
		int[] ar = new int[s.length];
		int[] count = new int[10];
		int sum = 0;
		for (int i = 0; i < s.length; i++) {
			ar[i] = Integer.parseInt(s[i]);
			sum += ar[i];
			count[ar[i]]++;
		}
		if (count[0] == 0) {
			bw.write("-1");
		} 
		else {
			if (sum % 3 == 0) {
				for (int i = 9; i >= 0; i--) {
					for(int j = 0; j < count[i]; j++) {
						bw.write(String.valueOf(i));
					}
				}
				
			} 
			else {
				bw.write("-1");
			}
		}
		bw.write("\n");
		bw.flush();
	}
}
