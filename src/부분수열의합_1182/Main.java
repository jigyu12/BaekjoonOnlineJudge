package 부분수열의합_1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int[] ar;
    private static int n;
    private static int s;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] ns = br.readLine().split(" ");
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(ns[0]);
        s = Integer.parseInt(ns[1]);

        if(s == 0){
            answer--;
        }

        ar = new int[n+1];

        for(int i = 0; i < n; i++){
            ar[i] = Integer.parseInt(input[i]);
        }

        combination(0, 0);

        System.out.println(answer);
    }

    private static void combination(int start, int bitMask) {

        if(start > n){
            return ;
        }

        int sum = 0;
        for(int i = 0; i < n; i++){
            if((bitMask & (1 << i)) != 0){
                sum += ar[i];
            }
        }


        if(sum == s){
            answer++;
        }

        for(int i = start; i < n; i++){
            if((bitMask & (1 << i)) == 0){
                combination(i+1, bitMask | (1 << i));
            }
        }

    }
}
