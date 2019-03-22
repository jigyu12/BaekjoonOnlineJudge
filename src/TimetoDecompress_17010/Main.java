package TimetoDecompress_17010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException, NumberFormatException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(br.readLine());
		for(int i = 0; i < num; i++) {
			String[] s = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			for(int j = 0; j < n; j++) {
				bw.write(s[1]);
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
