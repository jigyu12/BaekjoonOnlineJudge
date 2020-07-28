package 등수매기기_2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int rankArray[] = new int[N];
		for(int i = 0; i < N; i++) {
			rankArray[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.parallelSort(rankArray);
		
		long answer = 0;
		for(int i = 1; i <= N; i++) {
			answer += Math.abs(rankArray[i-1] - i);
		}
		System.out.println(answer);
	}

}
