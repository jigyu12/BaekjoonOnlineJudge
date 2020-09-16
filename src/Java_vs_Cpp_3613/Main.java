package Java_vs_Cpp_3613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	private final static int JAVA = 1;
	private final static int CPP = 2;
	private final static int NOLANG = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		int langNum = distinctLang(input);
		String answer = null;
		
		switch(langNum) {
		
		case JAVA:
			answer = convertJavatoCPP(input);
			break;
			
		case CPP:
			answer = convertCppToJava(input);
			break;
			
		case NOLANG:
			answer = "Error!";
			break;
		}
		
		System.out.println(answer);
	}

	private static String convertCppToJava(char[] input) {
		StringBuilder convertVar = new StringBuilder();	
		for(int i = 0; i < input.length; i++) {
			if(input[i] == '_') {
				i++;
				convertVar.append(String.valueOf(input[i]).toUpperCase());
				continue;
			}
			convertVar.append(input[i]);
		}
		return convertVar.toString();
	}

	private static String convertJavatoCPP(char[] input) {
		StringBuilder convertVar = new StringBuilder();
		for(int i = 0; i < input.length; i++) {
			if(input[i] >= 'A' && input[i] <= 'Z') {
				convertVar.append('_');
				convertVar.append(String.valueOf(input[i]).toLowerCase());
				continue;
			}
			convertVar.append(input[i]);
		}
		return convertVar.toString();
	}

	private static int distinctLang(char[] input) {
		int langNum = NOLANG;
		boolean bothLang = true;
		int underBarCnt = 0;
		for(int i = 0; i < input.length; i++) {
			if(input[i] == '_') {
				bothLang = false;
				underBarCnt++;
				if(langNum == JAVA
						|| underBarCnt > 1
						|| i == input.length - 1
						|| i == 0) {
					langNum = NOLANG;
					break;
				}
				langNum = CPP;
				continue;
			}
			else if(input[i] >= 'A' && input[i] <= 'Z') {
				bothLang = false;
				if(langNum == CPP 
						|| i == 0) {
					langNum = NOLANG;
					break;
				}
				langNum = JAVA;
			}
			underBarCnt = 0;
		}
		if(bothLang) {
			langNum = JAVA;
		}	
		return langNum;
	}
}
