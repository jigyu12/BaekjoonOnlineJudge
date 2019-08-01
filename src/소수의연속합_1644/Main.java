package 소수의연속합_1644;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
	static boolean[] sosu = new boolean[4000001];
	static ArrayList<Integer> ar = new ArrayList<>();
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) throws NumberFormatException, IOException {
		sosu[0] = true;
		sosu[1] = true;
		for(int i = 2; i < Math.sqrt(4000001); i++) {
			for(int j = i+i; j < 4000001; j += i) {
				if(!sosu[j]) {
					sosu[j] = true;
				}
			}
		}

		int num = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int ans = 0;
		ar.add(0);
		for(int i = 2; i < 4000001; i++) {
			if(i > num) {
				break;
			}
			if(!sosu[i]) {
				sum += i;
				ar.add(sum);
			}
		}
		
		for(int i = ar.size() - 1; i  >= 0 ; i--) {
			for(int j = i-1 ; j >= 0; j--) {
				if(ar.get(i) - ar.get(j) < num) {
				}
				else if(ar.get(i) - ar.get(j) > num) {
					break;
				}
				else {
					ans++;
				}
			}
		}
		System.out.println(ans);
	}
}