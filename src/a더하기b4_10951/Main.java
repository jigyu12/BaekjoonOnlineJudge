package a¥ı«œ±‚b4_10951;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			while(true) {
				String[] num = br.readLine().split(" ");
				System.out.println((Integer.parseInt(num[0])+Integer.parseInt(num[1])));
			}
		} catch (Exception e) {
		}
	}
}