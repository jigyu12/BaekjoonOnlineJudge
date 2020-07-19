package F7_2790;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		ArrayList<Integer> score = new ArrayList<>();
		ArrayList<Integer> minPossibleScore = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			score.add(Integer.parseInt(br.readLine()));
		}
		
		Collections.sort(score, Collections.reverseOrder());

		minPossibleScore.add(score.get(0) + 1);
		int answer = 1;
		
		for(int i = 2; i <= N; i++) {
			if(score.get(i-1) + N >= minPossibleScore.get(i-2)) {
				answer++;
			}
			
			if(minPossibleScore.get(i-2) < (score.get(i-1) + i)) {
				minPossibleScore.add(score.get(i-1) + i);
			}
			else {
				minPossibleScore.add(minPossibleScore.get(i-2));
			}
		}
		
		System.out.println(answer);
	}
}
