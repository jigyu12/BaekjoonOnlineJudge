package 블랙잭_2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private static int m;
	private static int answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] nm = br.readLine().split(" ");
		String[] input = br.readLine().split(" ");
		
		int n = Integer.parseInt(nm[0]);
		m = Integer.parseInt(nm[1]);
		
		int[] cardArr = new int[n];
		
		for(int idx = 0; idx < n; idx++) {
			cardArr[idx] = Integer.parseInt(input[idx]);
		}
		
		boolean[] checkUseCard = new boolean[n];
		int selectCardCnt = 0;
		int cardNumSum = 0;
		findThreeCard(selectCardCnt,checkUseCard,cardNumSum,cardArr);
		System.out.println(answer);
		
	}

	private static void findThreeCard(int selectCardCnt, boolean[] checkUseCard, 
			int cardNumSum, int[] cardArr) {
		
		if(cardNumSum > m || selectCardCnt > 3) {
			return ;
		}
		
		else if(selectCardCnt == 3) {
			if(cardNumSum <= m && cardNumSum > answer) {
				answer = cardNumSum;
				return;
			}
		}
		
		for(int idx = 0; idx < checkUseCard.length; idx++) {
			if(!checkUseCard[idx]) {
				checkUseCard[idx] = true;
				findThreeCard(selectCardCnt + 1, checkUseCard, 
						cardNumSum + cardArr[idx],cardArr);
				checkUseCard[idx] = false;
			}
		}
		
	}

}
