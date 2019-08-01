package 게임_1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static long win;
	private static long x;
	private static long y;
	
	private static long binarySearch(long i, long j) {
		
		if(i > j) {
			return -1;
		}
		
		long mid = (i + j) / 2;
		
		long find =  (y + mid) * 100 / (x + mid);
		
		if(find > win) {
			return binarySearch(i, mid-1);
		}
		else if(find < win) {
			return binarySearch(mid+1, j);
		}
		else {
			long plusone = ( (y + mid + 1)  * 100 / (x + mid + 1) );
			if(find < plusone) {
				return mid+1;
			}
			else {
				return binarySearch(mid+1, j);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] xy = br.readLine().split(" ");
		x = Long.parseLong(xy[0]);
		y = Long.parseLong(xy[1]);
		
		win = y * 100 / x;

		long num = binarySearch(0, 1000000000);
		if(num < 0) {
			System.out.println("-1");
		}
		else {
			System.out.println(num);
		}
	}
}

