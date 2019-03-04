package ÄµµðºÐ¹è_3955;

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
			int num = Integer.parseInt(br.readLine());
			for(int i = 0; i < num; i++) {
				String[] kc = br.readLine().split(" ");
				int k = Integer.parseInt(kc[0]);
				int c = Integer.parseInt(kc[1]);
				
				int[] s = new int[50];
				int[] t = new int[50];
				int[] r = new int[50];
				int[] q = new int[50];
				s[0] = 1;
				s[1] = 0;
				t[0] = 0;
				t[1] = -1;
				r[0] = c;
				r[1] = k;
				int index = 2;
				while(r[index-1] >= 1) {
					q[index] = r[index-2] / r[index-1];
					r[index] = r[index-2] % r[index-1];
					s[index] = s[index-2] - q[index] * s[index-1];
					t[index] = t[index-2] - q[index] * t[index-1];
					index++;
				}
				for(int j = 0; j < index; j++) {
					System.out.print(s[j] + " ");
				}
				System.out.println();
				if(k % c == 0) {
					bw.write("IMPOSSIBLE\n");
					continue;
				}
				if(s[index-1] > 0) {
					bw.write(s[index-1]+"\n");
				}
				else if(s[index-1] < 0) {
					bw.write(s[index]+"\n");
				}
			}
			bw.flush();
		} catch (NumberFormatException | IOException e) {
		}
	}
}
