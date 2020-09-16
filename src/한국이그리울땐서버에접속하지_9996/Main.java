package 한국이그리울땐서버에접속하지_9996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		char[] regexInput = br.readLine().toCharArray();
		StringBuilder regex = new StringBuilder();
		StringBuilder answer = new StringBuilder();
		
		regex.append("^");
		for(int i = 0; i < regexInput.length; i++) {
			if(regexInput[i] == '*') {
				regex.append("[a-z]*");
			}
			else {
				regex.append(regexInput[i]);
			}
		}
		regex.append("$");

		for(int i = 0; i < N; i++) {
			String input = br.readLine();
			Pattern p = Pattern.compile(regex.toString());
			Matcher m = p.matcher(input);
			if(m.find()) {
				answer.append("DA");
			}
			else {
				answer.append("NE");
			}
			answer.append("\n");
		}
		System.out.println(answer.toString().trim());
	}
}
