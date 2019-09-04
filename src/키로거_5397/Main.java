package 키로거_5397;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int test = Integer.parseInt(br.readLine());
		for(int t = 0; t < test; t++) {
			String s = br.readLine();

			Stack<String> front = new Stack<>();
			Stack<String> back = new Stack<>();
			for(int i = 0; i < s.length(); i++) {
				switch(s.charAt(i)) {
				case '<':
					if(front.size() > 0) {
						back.add(front.pop());
					}
					break;
					
				case '>':
					if(back.size() > 0) {
						front.add(back.pop());
					}
					break;
				case '-':
					if(front.size() > 0) {
						front.pop();
					}
					break;
				default :
					front.add(String.valueOf(s.charAt(i)));
					
					break;
				}
			}
			while(!front.isEmpty()) {
				back.add(front.pop());
			}
			int size = back.size();
			for(int i = 0; i < size; i++) {
				bw.write(back.pop());
			}
			bw.write("\n");
		}
		bw.flush();
	}
}
