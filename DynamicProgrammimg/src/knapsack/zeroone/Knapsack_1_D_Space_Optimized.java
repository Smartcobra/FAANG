package knapsack.zeroone;

public class Knapsack_1_D_Space_Optimized {
    public int solve(int[] v, int[] w, int W) {
        int n = v.length;
        int[] dp = new int[W + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = W; j >= 0; j--) {
                if (w[i - 1] <= j) {
                    dp[j] = Math.max(v[i - 1] + dp[j - w[i - 1]], dp[j]);
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[W];
    }
}
