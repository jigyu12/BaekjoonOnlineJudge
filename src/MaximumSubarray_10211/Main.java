package MaximumSubarray_10211;

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

		for (int i = 0; i < num; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] ar = new int[n];
			String[] s = br.readLine().split(" ");
			int sum = 0;
			int ans = -10000000;
			for (int j = 0; j < n; j++) {
				sum += Integer.parseInt(s[j]);
				ar[j] = sum;
				if (ans < sum) {
					ans = sum;
				}
				for (int k = 0; k <= j - 1; k++) {
					int val = ar[j] - ar[k];
					if (val > ans) {
						ans = val;
					}
				}
			}
			bw.write(ans + "\n");
		}
		bw.flush();
	}
}
