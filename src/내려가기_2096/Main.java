package 내려가기_2096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] maxScoreAr = new int[n][3];
		int[][] minScoreAr = new int[n][3];

		for(int i = 0; i < n; i++){
			String[] ar = br.readLine().split(" ");
			int[] input = new int[3];
			for(int j = 0; j < 3; j++){
				input[j] = Integer.parseInt(ar[j]);
			}
			if(i == 0){
				for(int j = 0; j < 3; j++){
					maxScoreAr[i][j] = input[j];
					minScoreAr[i][j] = input[j];
				}
				continue;
			}
			maxScoreAr[i][0] = input[0] + Math.max(maxScoreAr[i - 1][0], maxScoreAr[i - 1][1]);
			maxScoreAr[i][1] = input[1] + Math.max(maxScoreAr[i - 1][0],
					Math.max(maxScoreAr[i - 1][1], maxScoreAr[i - 1][2]));
			maxScoreAr[i][2] = input[2] + (Math.max(maxScoreAr[i - 1][1], maxScoreAr[i - 1][2]));

			minScoreAr[i][0] = input[0] + (Math.min(minScoreAr[i - 1][0], minScoreAr[i - 1][1]));
			minScoreAr[i][1] = input[1] + Math.min(minScoreAr[i-1][0],
					Math.min(minScoreAr[i - 1][1], minScoreAr[i - 1][2]));
			minScoreAr[i][2] = input[2] + (Math.min(minScoreAr[i - 1][1], minScoreAr[i - 1][2]));
		}

		int maxScore = 0;
		int minScore = 1000000;

		for(int j = 0; j < 3; j++){
			if(maxScore < maxScoreAr[n-1][j]){
				maxScore = maxScoreAr[n-1][j];
			}

			if(minScore > minScoreAr[n-1][j]){
				minScore = minScoreAr[n-1][j];
			}
		}

		System.out.println(maxScore + " " + minScore);
	}
}
