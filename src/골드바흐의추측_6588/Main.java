package 골드바흐의추측_6588;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		boolean[] ar = new boolean[1000001];
		ar[0] = true;
		ar[1] = true;
		for (int i = 0; i < ar.length; i++) {
			if (!ar[i]) {
				for (int j = i + i; j < ar.length; j += i) {
					ar[j] = true;
				}
			}
		}


		while (true) {
			int num = Integer.parseInt(br.readLine());
			if (num == 0) {
				break;
			}
			boolean find = false;
			for (int i = num - 1; i >= 3; i--) {
				if (!ar[i] && !ar[num - i]) {
					bw.write(num + " = " + (num-i) + " + " + i+"\n");
					find = true;
					break;
				}
			}
			if (!find) {
				bw.write("Goldbach's conjecture is wrong.");
			}
			bw.flush();
		}
	}
}
