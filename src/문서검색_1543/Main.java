package 문서검색_1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] document = br.readLine().toCharArray();
		char[] word = br.readLine().toCharArray();
		
		int answer = 0;
		for(int start = 0; start < document.length - word.length+1; start++) {
			int sameWordCount = 0;
			for(int documentIdx = start; documentIdx < document.length- word.length+1; documentIdx++) {
				boolean findSameWord = false;
				if(document[documentIdx] == word[0]) {
					findSameWord = true;
					for(int wordIdx = 1; wordIdx < word.length; wordIdx++) {
						if(document[++documentIdx] != word[wordIdx]) {
							findSameWord = false;
							break;
						}
					}
				}
				if(findSameWord) {
					sameWordCount++;
				}
			}
			if(answer < sameWordCount) {
				answer = sameWordCount;
			}
		}
		System.out.println(answer);
		
	}

}
