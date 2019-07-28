package 빠른A더하기B_15552;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			int test = Integer.parseInt(br.readLine());
			for (int i = 0; i < test; i++) {
				String[] s = br.readLine().split(" ");
				bw.write(Integer.parseInt(s[0]) + Integer.parseInt(s[1])+"\n");
			}
			bw.flush();
		} catch (IOException e) {
		}
	}
}
