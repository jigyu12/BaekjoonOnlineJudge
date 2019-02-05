package ¿∑≥Ó¿Ã_2490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			try {
				for(int i = 0; i < 3; i++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					int sum = 0;
					while(st.hasMoreTokens()) {
						sum += Integer.parseInt(st.nextToken());
					}
					switch(sum) {
					case 0:
						System.out.println("D");
						break;
					case 1:
						System.out.println("C");
						break;
					case 2:
						System.out.println("B");
						break;
					case 3:
						System.out.println("A");
						break;
					case 4:
						System.out.println("E");
						break;
					}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
