package 부녀회장이될테야_2775;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] apartment = new int[15][15];
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				if(i == 0) {
					apartment[i][j] = j;
				}
				else if(i >= 1 && j > 0){
					apartment[i][j] = apartment[i][j-1] + apartment[i-1][j];
				}
			}
		}
		int test = sc.nextInt();
		for(int i = 0; i < test; i++) {
			int floor = sc.nextInt();
			int room = sc.nextInt();
			System.out.println(apartment[floor][room]);
		}
	}
}
