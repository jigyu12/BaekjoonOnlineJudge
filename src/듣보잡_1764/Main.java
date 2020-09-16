package 듣보잡_1764;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
	
	private static final String DELEMETER = "\n";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		StringBuilder answer = new StringBuilder();
		HashSet<String> notListenPeopleSet = new HashSet<>();
		ArrayList<String> notListenSeenPeopleList = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			notListenPeopleSet.add(br.readLine());
		}
		
		for(int i = 0; i < M; i++) {
			String notSeenPeople = br.readLine();
			if(notListenPeopleSet.contains(notSeenPeople)) {
				notListenSeenPeopleList.add(notSeenPeople);
			}
		}
		
		Collections.sort(notListenSeenPeopleList);
		answer.append(notListenSeenPeopleList.size());
		answer.append(DELEMETER);
		
		for(int i = 0; i < notListenSeenPeopleList.size(); i++) {
			answer.append(notListenSeenPeopleList.get(i));
			answer.append(DELEMETER);
		}
		
		System.out.println(answer.toString());
	}

}
