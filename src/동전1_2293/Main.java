package 동전1_2293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        int[] coins = new int[n];
        int[] sum = new int[k+1];
        for(int i = 0; i < n; i++){
            coins[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(coins);
        sum[0] = 1;
        for(int i = 0; i < n; i++){
            for(int j = coins[i]; j <= k; j++){
                sum[j] += sum[j-coins[i]];
            }
        }

        System.out.println(sum[k]);
    }
}
