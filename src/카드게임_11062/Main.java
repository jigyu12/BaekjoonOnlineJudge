package 카드게임_11062;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		try {
			int test = Integer.parseInt(br.readLine());
			for(int i = 0; i < test; i++) {
				int num  = Integer.parseInt(br.readLine());
				String[] s = br.readLine().split(" ");
				ArrayDeque<Integer> dq = new ArrayDeque<>();
				for(int j = 0; j < s.length; j++) {
					dq.add(Integer.parseInt(s[j]));
				}
				int sum = 0;
				
				
			}
		} catch (NumberFormatException | IOException e) {
		}
	}
}
