package N_digit_numbers;

import java.util.Arrays;

public class N_Digit_Numbers_Memoization {

    public static int solve(int n, int sum) {
        int MOD = 1000 * 1000 * 1000 + 7;
        int ans = 0;
        int[][] dp = new int[n + 1][sum + 1];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        for (int i = 1; i <= 9; i++) {
            ans = ans + ndigtis(dp, n - 1, sum - i);
            ans = ans % MOD;
        }

        return ans;
    }

    private static int ndigtis(int[][] dp, int n, int sum) {
        int MOD = 1000 * 1000 * 1000 + 7;
        if (sum < 0) return 0;
        if (n == 0 && sum == 0) return 1;
        if (n == 0) return 0;
        if (dp[n][sum] != -1) return dp[n][sum];
        int ans = 0;
        for (int i = 0; i <= 9; i++) {
            ans = ans + ndigtis(dp, n - 1, sum - i);
            ans = ans % MOD;
        }
        dp[n][sum] = ans;
        return dp[n][sum];
    }

    public static void main(String[] args) {
        System.out.println(solve(2, 2));
    }
}
