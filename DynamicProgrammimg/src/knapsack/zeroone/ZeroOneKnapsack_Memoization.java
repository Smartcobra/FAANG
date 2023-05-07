package knapsack.zeroone;

import java.util.ArrayList;
import java.util.Arrays;

public class ZeroOneKnapsack_Memoization {
    int[][] dp;

    public int solve(ArrayList<Integer> values, ArrayList<Integer> weights, int W) {
        int n = values.size();
        dp = new int[n+1][W+1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        return knapsack(values, weights, W, n);
    }

    public int knapsack(ArrayList<Integer> values, ArrayList<Integer> weights, int W, int n) {
        if (n == 0 || W == 0) return 0;


        if (dp[n][W] != -1) {
            return dp[n][W];
        }
        if (dp[n][W] == -1) {
            if (weights.get(n - 1) <= W) {
                dp[n][W] = Math.max(values.get(n - 1) + knapsack(values, weights, W - weights.get(n - 1), n - 1), knapsack(values, weights, W, n - 1));
            } else  {
                dp[n][W] = knapsack(values, weights, W, n - 1);
            }
        }


        return dp[n][W];
    }

    public static void main(String[] args) {
        ArrayList<Integer> values = new ArrayList<>();
        values.add(359);
        values.add(963);
        values.add(465);
        values.add(706);
        values.add(146);
        values.add(282);
        values.add(828);
        values.add(962);
        values.add(492);

        /// [ 96, 43, 28, 37, 92, 5, 3, 54, 93 ]
        ArrayList<Integer> weights = new ArrayList<>();
        weights.add(96);
        weights.add(43);
        weights.add(28);
        weights.add(37);
        weights.add(92);
        weights.add(5);
        weights.add(3);
        weights.add(54);
        weights.add(93);
        int C = 383;
        ZeroOneKnapsack_Memoization ks = new ZeroOneKnapsack_Memoization();
        System.out.println(ks.solve(values, weights, C));

    }
}
