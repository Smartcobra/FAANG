package eggDropping;

import java.util.Arrays;

public class EggDroppingMemoization_Imporve {
    static int  dp[][] = new int[10001][10001];

    public static int solveEggDropping(int e, int f) {

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
        int low = 0;
        int high = 0;

        for (int i = 1; i <= f; i++) {

            if (dp[e - 1][i - 1] != -1) {
                low = dp[e - 1][i - 1];
            } else {
                low = solveEggDropping(e - 1, i - 1);
            }

            if (dp[e][f - i] != -1) {
                high = dp[e][f - i];
            } else {
                high = solveEggDropping(e, f - i);
            }

            int res = 1 + Math.max(low, high);

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
        System.out.print(solveEggDropping(n, k));
    }

}
