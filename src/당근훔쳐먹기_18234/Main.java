package 당근훔쳐먹기_18234;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
	
	static class Carrot implements Comparable<Carrot>{ 
		int initTaste;
		int nutrition;
		
		public Carrot(int initTaste, int nutrition) {
			this.initTaste = initTaste;
			this.nutrition = nutrition;
		}

		@Override
		public int compareTo(Carrot o) {
			if(this.nutrition == o.nutrition) {
				return this.initTaste - o.initTaste;
			}
			return this.nutrition - o.nutrition;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String NT[] = br.readLine().split(" ");
		int N = Integer.parseInt(NT[0]);
		int T = Integer.parseInt(NT[1]);
		long answer = 0;
		
		ArrayList<Carrot> carrotList = new ArrayList();
		
		for(int i = 0; i < N; i++) {
			String[] wp = br.readLine().split(" ");
			carrotList.add(new Carrot(Integer.parseInt(wp[0]),
					Integer.parseInt(wp[1])));
		}
		
		Collections.sort(carrotList);
		
		for(int i = N-1; i >= 0; i--) {
			Carrot carrot = carrotList.get(i);
			answer += carrot.initTaste + ((long) carrot.nutrition * (--T));
		}
		
		System.out.println(answer);
	}

}
