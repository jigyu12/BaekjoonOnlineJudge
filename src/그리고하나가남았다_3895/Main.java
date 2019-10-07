package 그리고하나가남았다_3895;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n =1,k =1,m = 1;
		
		while(true) {
			String[] nkm = br.readLine().split(" ");
			
			n = Integer.parseInt(nkm[0]);
			k = Integer.parseInt(nkm[1]) - 1;
			m = Integer.parseInt(nkm[2]) - 1;
			if(n == 0 && k == -1 && m == -1) {
				break;
			}
			ArrayList<Integer> stone = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				stone.add(i);
			}
			int size = n;
			stone.remove(m);
			for(int i = 0; i < size-2; i++) {
				int rot = (k % (--n));
				m = (m + rot) % (n);
				stone.remove(m);
				if(m >= stone.size()) {
					m = 0;
				}
			}
			bw.write((stone.get(0)+1)+"\n");
		}
		bw.flush();
	}

}
