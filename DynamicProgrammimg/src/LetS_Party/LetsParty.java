package LetS_Party;

public class LetsParty {
    public int solve(int A) {
        int[] dp = new int[A + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= A; i++) {
            dp[i] = dp[i - 1] + (i - 1) * dp[i - 2];
            dp[i] = dp[i] % 10003;
        }
        return dp[A];

    }
}
