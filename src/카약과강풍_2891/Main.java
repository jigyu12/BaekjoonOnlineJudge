package 카약과강풍_2891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	private static boolean[] damageTeams, borrowTeams;
	private static ArrayList<Integer> lendTeams;
	private static int answer,N,S,R;
	private static boolean[] isRightBorrow;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NSR = br.readLine().split(" ");
		
		N = Integer.parseInt(NSR[0]);
		S = Integer.parseInt(NSR[1]);
		R = Integer.parseInt(NSR[2]);
		
		damageTeams = new boolean[12];
		borrowTeams = new boolean[12];
		lendTeams = new ArrayList<>();
		isRightBorrow = new boolean[R];
		
		String[] damageList = br.readLine().split(" ");
		
		for(int i = 0; i < S; i++) {
			damageTeams[Integer.parseInt(damageList[i])] = true; 
		}
		
		String[] lendList = br.readLine().split(" ");
		
		for(int i = 0; i < R; i++) {
			lendTeams.add(Integer.parseInt(lendList[i])); 
		}
		answer = S;
		
		findMinimumDamage(0);
		System.out.println(answer);
	}

	private static void findMinimumDamage(int start) {
		
		for(int i = 0; i < R; i++) {
			if(isRightBorrow[i]) {
				borrowTeams[lendTeams.get(i)+1] = true;
			}
			else {
				borrowTeams[lendTeams.get(i)-1] = true;
			}
		}
		
		int damageCount = S;
		for(int i = 1; i <= N; i++) {
			if(damageTeams[i] && borrowTeams[i]) {
				damageCount--;
			}
		}
		
		for(int i = 0; i < R; i++) {
			if(isRightBorrow[i]) {
				borrowTeams[lendTeams.get(i)+1] = false;
			}
			else {
				borrowTeams[lendTeams.get(i)-1] = false;
			}
		}
		
		if(damageCount < answer) {
			answer = damageCount;
		}
		
		if(answer == 0 || start == R) {
			return;
		}
		
		for(int i = start; i < R; i++) {
			isRightBorrow[i] = true;
			findMinimumDamage(start+1);
			isRightBorrow[i] = false;
		}
	}
	
}
