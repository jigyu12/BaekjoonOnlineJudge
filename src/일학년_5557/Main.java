package ÀÏÇĞ³â_5557;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	private static long num;
	private static long[] ar;
	private static long result;
	private static long[][] sum;

	private static long find(long cnt, long ssum) {
		if(ssum > 20 || ssum < 0) {
			return 0;
		}
		
		if(cnt == ar.length-1) {
			if(ssum == result) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		if(sum[(int)cnt][(int)ssum] != -1) {
			return sum[(int)cnt][(int)ssum];
		}
	
		sum[(int)cnt][(int)ssum] = 0;
		
		for(int i = 0; i < 2; i++) {
			if(i == 0) {
				sum[(int)cnt][(int)ssum] += find(cnt+1,ssum + ar[(int)cnt+1]);
			}
			else {
				sum[(int)cnt][(int)ssum] += find(cnt+1,ssum - ar[(int)cnt+1]);
			}
		}
		return sum[(int)cnt][(int)ssum];
	}

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			num = Integer.parseInt(br.readLine());
			ar = new long[(int)(num-1)];
			sum = new long[101][21];
			for(int i = 0; i < num; i++) {
				Arrays.fill(sum[i], -1);
			}
			String[] s = br.readLine().split(" ");
			for(int i = 0; i < num - 1; i++) {	
				ar[i] = Long.parseLong(s[i]);
			}
			result = Long.parseLong(s[s.length-1]);
			find(0,ar[0]);
//			for(int i = 0; i < 101; i++) {
//				for(int j = 0; j < 21; j++) {
//					System.out.print(sum[i][j] + " ");
//				}
//				System.out.println();
//			}
			System.out.println(sum[0][(int)ar[0]]);
		} catch (NumberFormatException | IOException e) {
		}
	}
}

