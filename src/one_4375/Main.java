package one_4375;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		try {
			String s = br.readLine();
			int count = 0;
			boolean[] check = new boolean[10001];
			switch(s.length()) {
			case 1:
				int num1 = Integer.parseInt(s);
				int a = 11;
				int r = -1;
				while(true) {
					r = a % num1;
			
					if(check[r]) {
						break;
					}
					else{
						check[r] = true;
					}
					if(r == 0) {
						count++;
						break;
					}
					a = r * 10 + 1;
//					System.out.println(a);
					count++;
				}
				count += 1;
				break;
			case 2:
				int num2 = Integer.parseInt(s);
				if(num2 == 11) {
					count++;
					break;
				}
				int a2 = 111;
				int r2 = -1;
				while(true) {
					r2 = a2 % num2;
				
					if(check[r2]) {
						break;
					}
					else {
						check[r2] = true;
					}
					
					if(r2 == 0) {
						count++;
						break;
					}
					int cnt = 0;
					while(r2 < num2) {
						r2 *= 10;
						r2 += 1;
						cnt++;
					}
//					System.out.println(r2);
					a2 = r2;
					count+=cnt;
				}
				count += 2;
				break;
			case 3:
				int num3 = Integer.parseInt(s);
				if(num3 == 111) {
					count++;
					break;
				}
				int a3 = 1111;
				int r3 = -1;
				while(true) {
					r3 = a3 % num3;

					if(check[r3]) {
						break;
					}
					else {
						check[r3] = true;
					}
					
					if(r3 == 0) {
						count++;
						break;
					}
					int cnt = 0;
					while(r3 < num3) {
						r3 *= 10;
						r3 += 1;
						cnt++;
					}
//					System.out.println(r3);
					a3 = r3;
					count+= cnt;
				}
				count += 3;
				break;
			case 4:
				int num4 = Integer.parseInt(s);
				if(num4 == 1111) {
					count++;
					break;
				}
				int a4 = 11111;
				int r4 = -1;
				while(true) {
					r4 = a4 % num4;
//					System.out.println(r4);
					if(check[r4]) {
						break;
					}
					else {
						check[r4] = true;
					}

					if(r4 == 0) {
						count++;
						break;
					}
					int cnt = 0;
					while(r4 < num4) {
						r4 *= 10;
						r4 += 1;
						cnt++;
					}
//					System.out.println(r4);
					a4 = r4;
					count+=cnt;
				}
				count += 4;
				break;
			}
			System.out.println(count);
		} catch (NumberFormatException | IOException e) {
		}
	}
}
