package 평범한배낭_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = br.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);

        int[] values = new int[n + 1];
        int[] weights = new int[n + 1];
        int[][] dp = new int[n + 1][k+1];

        for (int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            weights[i] = Integer.parseInt(input[0]);
            values[i] = Integer.parseInt(input[1]);
            dp[i][i] = values[i];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i][j - 1] > dp[i - 1][j] ? dp[i][j - 1] : dp[i - 1][j];
                if (j >= weights[i]) {
                    dp[i][j] = dp[i - 1][j - weights[i]] + values[i] > dp[i][j]
                            ? dp[i - 1][j - weights[i]] + values[i] : dp[i][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}
