package YonseiTOTO_12018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		
		int answer = 0;
		int[] putMileageList = new int[n];
		
		for(int test = 0; test < n; test++) {
			String[] pl = br.readLine().split(" ");
			String[] input = br.readLine().split(" ");
			
			int p = Integer.parseInt(pl[0]);
			int l = Integer.parseInt(pl[1]);
			
			if(p < l) {
				
				putMileageList[test] = 1001;
				if(m - 1 < 0) {
					continue;
				}
				
				answer++;
				m -= 1;
				
				continue;
			}
			
	
			int[] mileageArr = new int[p];
			for(int i = 0; i < p; i++) {
				mileageArr[i] = Integer.parseInt(input[i]);
			}
			
			Arrays.sort(mileageArr);
			
			putMileageList[test] = mileageArr[p-l];
		}

		Arrays.sort(putMileageList);
		
		for(int i = 0; i < n; i++) {
			if(m - putMileageList[i] < 0) {
				break;
			}
			m -= putMileageList[i];
			answer++;
		}
		
		System.out.println(answer);
	}

}
