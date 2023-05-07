package eggDropping;

import java.util.Arrays;

public class EggDroppingMemoization {
    static int dp[][] = new int[101][10001];

    public static int solveEggDrop(int e, int f) {
        if (e == 1) {
            return f;
        }
        if (f == 0 || f == 1) {
            return f;
        }
        if (dp[e][f] != -1) {
            return dp[e][f];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= f; i++) {
            int res = 1 + Math.max(solveEggDrop(e - 1, i - 1), solveEggDrop(e, f - i));

            if (res < min) {
                min = res;
            }
        }
        dp[e][f] = min;
        return min;
    }

    public static void main(String[] args) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        int n = 2, k = 36;
        System.out.print(solveEggDrop(n, k));
    }
}
