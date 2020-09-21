package 수열의점수_2036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        BigInteger answer = new BigInteger("0");
        int i = n-1;
        while(i >= 0){
            BigInteger first = new BigInteger("0");
            BigInteger second = new BigInteger("0");
            if(arr[i] <= 1){
                if(arr[i] <= 0){
                    break;
                }
                answer = answer.add(new BigInteger(String.valueOf(arr[i--])));
                continue;
            }
            first = new BigInteger(String.valueOf(arr[i--]));
            if(i < 0 || arr[i] <= 1){
                if(i < 0 || arr[i] <= 0){
                    answer = answer.add(first);
                    break;
                }
                answer  = answer.add(first.add(new BigInteger(String.valueOf(arr[i--]))));
                continue;
            }
            second = new BigInteger(String.valueOf(arr[i--]));
            answer  = answer.add(first.multiply(second));
        }

        int j = 0;
        while(j <= n-1){
            BigInteger first = new BigInteger("0");;
            BigInteger second = new BigInteger("0");;
            if(arr[j] >= 0){
                break;
            }
            first = new BigInteger(String.valueOf(arr[j++]));
            if(j > n-1 || arr[j] >= 0){
                if( j > n-1 || arr[j] > 0){
                    answer = answer.add(first);
                }
                break;
            }
            second = new BigInteger(String.valueOf(arr[j++]));
            answer  = answer.add(first.multiply(second));
        }

        System.out.println(answer.toString());
    }
}
