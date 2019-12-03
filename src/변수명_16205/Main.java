package 변수명_16205;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static String[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] s = br.readLine().split(" ");
		answer = new String[3];
		switch (s[0]) {
		case "1":
			convertCamel(s[1]);
			break;

		case "2":
			convertSnake(s[1]);
			break;

		case "3":
			convertPascal(s[1]);
			break;
		}
		for(int i = 0; i < 3; i++) {
			bw.write(answer[i]+"\n");
		}
		bw.flush();
	}

	static void convertCamel(String inputString) {
		answer[0] = inputString;
		char[] input = inputString.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= 97) {
				sb.append(input[i]);
			} else {
				sb.append("_" + String.valueOf(input[i]).toLowerCase());
			}
		}
		answer[1] = sb.toString();
		sb.delete(0, sb.length());
		for (int i = 0; i < input.length; i++) {
			if (i == 0) {
				sb.append(String.valueOf(input[i]).toUpperCase());
			} else {
				sb.append(input[i]);
			}
		}
		answer[2] = sb.toString();

	}

	static void convertSnake(String inputString) {

		char[] input = inputString.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= 97) {
				sb.append(input[i]);
			} else {
				++i;
				sb.append(String.valueOf(input[i]).toUpperCase());
			}
		}
		answer[0] = sb.toString();
		answer[1] = inputString;
		sb.delete(0, sb.length());
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= 97) {
				if (i == 0) {
					sb.append(String.valueOf(input[i]).toUpperCase());
				} else {
					sb.append(input[i]);
				}

			} else {
				++i;
				sb.append(String.valueOf(input[i]).toUpperCase());
			}
		}
		answer[2] = sb.toString();

	}

	static void convertPascal(String inputString) {

		char[] input = inputString.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < input.length; i++) {
			if (i == 0) {
				sb.append(String.valueOf(input[i]).toLowerCase());
			} else {
				sb.append(input[i]);
			}
		}
		answer[0] = sb.toString();
		sb.delete(0, sb.length());
		for (int i = 0; i < input.length; i++) {
			if (input[i] >= 97) {
				sb.append(input[i]);
			} else {
				if (i != 0) {
					sb.append("_" + String.valueOf(input[i]).toLowerCase());
				} else {
					sb.append(String.valueOf(input[i]).toLowerCase());
				}
			}
		}
		answer[1] = sb.toString();
		answer[2] = inputString;
	}
}
