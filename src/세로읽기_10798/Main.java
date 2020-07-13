package 세로읽기_10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder answer = new StringBuilder();
		Queue<String>[] ar = new Queue[5];
		
		int maxLen = 0;
		for(int i = 0; i < 5; i++) {
			ar[i] = new LinkedList<>();
			String[] input = br.readLine().split("");
			if(maxLen < input.length) {
				maxLen = input.length;
			}
			for(int j = 0; j < input.length; j++) {
				ar[i].add(input[j]);
			}
		}
		
		for(int i = 0; i < maxLen; i++) {
			for(int j = 0; j < 5; j++) {
				if(!ar[j].isEmpty()) {
					answer.append(ar[j].poll());
				}
			}
		}
		
		System.out.println(answer.toString());
		
	}

}
