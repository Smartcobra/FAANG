package coinchange;

//https://leetcode.com/problems/coin-change/
public class MinimumNoOfCoins_322 {

    public int getMinNoCoins(int[] coins, int amount) {
        if (amount < 0) return 0;
        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;

            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            return -1;
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        MinimumNoOfCoins_322 mnc = new MinimumNoOfCoins_322();
        int[] coins = {9, 6, 5, 1};
        int sum = 11;
        System.out.println(mnc.getMinNoCoins(coins, sum));

    }

}
