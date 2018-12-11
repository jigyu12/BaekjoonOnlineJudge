package À½°è_2920;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] comp = new int[8];
		for (int i = 0; i < 8; i++) {
			comp[i] = sc.nextInt();
		}
		int a = 0;
		boolean up = false;
		boolean down = false;
		for (int i = 0; i < 7; i++) {
			if(comp[i] > comp[i+1]) {
				down = true;
			}
			else if(comp[i] < comp[i+1]) {
				up = true;
			}
		}
		if(up && down) {
			System.out.println("mixed");
		}
		else if(!up && down) {
			System.out.println("descending");
		}
		else if(up && !down) {
			System.out.println("ascending");
		}
	}
}
