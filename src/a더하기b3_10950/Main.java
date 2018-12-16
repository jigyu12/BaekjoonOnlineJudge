package a¥ı«œ±‚b3_10950;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 0; i < test; i++) {
				String[] num = br.readLine().split(" ");
				System.out.println((Integer.parseInt(num[0])+Integer.parseInt(num[1])));
			}
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
	}
}
