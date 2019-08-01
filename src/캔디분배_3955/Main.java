package 캔디분배_3955;

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
		for(int i = 0; i < num; i++) {
			String[] kc = br.readLine().split(" ");
			int k = Integer.parseInt(kc[0]);
			int c = Integer.parseInt(kc[1]);

			int s1 = 1;
			int s2 = 0;
			int t1 = 0;
			int t2 = 1;
			int r1 = k;
			int r2 = c;
			int q = 0;

			while(r2 > 0) {
				q = r1 / r2;
				int temp = r2;
				r2 = r1 % r2;
				r1 = temp;
				temp = s2;
				s2 = s1 - (q * s2);
				s1 = temp;
				
				temp = t2;
				t2 = t1 - (q * t2);
				t1 = temp;
			}
			
			if(r1 != 1) {
				bw.write("IMPOSSIBLE\n");
				continue;
			}
			
			while(1 <= 0 || s1 >= 0) {
				t1 += k;
				s1 -= c;
			}
			
			if(t1 > 1000000000) {
				bw.write("IMPOSSIBLE\n");
				continue;
			}
			
			bw.write(t1+"\n");	
		}
		bw.flush();
	}
}
