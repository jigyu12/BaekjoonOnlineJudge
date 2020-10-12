package 좋은단어_3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;

        Stack<Character> letterStack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            if (isGoodWord(word, letterStack)) {
                answer++;
            }
            letterStack.clear();
        }

        System.out.println(answer);
    }

    private static boolean isGoodWord(String word, Stack<Character> letterStack) {

        for(int idx = 0; idx < word.length(); idx++) {
            char letter = word.charAt(idx);

            if(letterStack.isEmpty()){
               letterStack.push(letter);
               continue;
            }

            if(letterStack.peek() == letter){
                letterStack.pop();
                continue;
            }

            letterStack.push(letter);
        }

        if(letterStack.size() > 0){
            return false;
        }

        return true;
    }
}
