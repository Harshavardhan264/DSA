import java.util.Arrays;

public class Knapsack01DP {
    public static int knapsack(int[] weights, int[] profits, int m) {
        int n = weights.length;
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= m; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w], profits[i - 1] + dp[i - 1][w - weights[i - 1]]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        int[] weights = {10, 20, 30};
        int[] profits = {60, 100, 120};
        int W = 50;

        int maxProfit = knapsack(weights, profits, m);
        System.out.println("Maximum profit in Knapsack: " + maxProfit);
    }
}
