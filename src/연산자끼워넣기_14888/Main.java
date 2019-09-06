package 연산자끼워넣기_14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static int[] ar;
	static int[] op;
	static int[] permu;
	static int max;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		ar = new int[n];
		op = new int[n - 1];
		permu = new int[n-1];
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		String[] s = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			ar[i] = Integer.parseInt(s[i]);
		}

		String[] o = br.readLine().split(" ");
		
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int oper = Integer.parseInt(o[i]);
			for (int j = 0; j < oper; j++) {
				switch (i) {
				case 0:
					op[idx++] = 1;
					break;
				case 1:
					op[idx++] = 2;
					break;
				case 2:
					op[idx++] = 3;
					break;
				case 3:
					op[idx++] = 4;
					break;
				}
			}
		}
		
		permutation(0,0);
		
		System.out.println(max+"\n"+min);
	}

	private static void permutation(int state, int count) {
		if(count == n-1) {
			int result = ar[0];
			
			for(int i = 0; i < n-1; i++) {
				int opr = op[permu[i]];
				
				switch(opr) {
				case 1:
					result+=ar[i+1];
					break;
				case 2:
					result-=ar[i+1];
					break;
				case 3:
					result*=ar[i+1];
					break;
				case 4:
					result/=ar[i+1];
					break;
				}
			}
			
			if(result > max) {
				max = result;
			}
			if(result < min) {
				min = result;
			}
			return;
		}
		
		for(int i = 0; i < n-1; i++) {
			if((state & (1 << i)) == 0) {
				permu[count] = i;
				permutation(state | (1 << i), count + 1);
			}
		}
	}

}
