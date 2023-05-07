package coinchange;

public class MinimumNoOfCoins {

    public int getMinNoCoins(int coins[], int sum) {
        int n = coins.length;

        int dp[][] = new int[n + 1][sum + 1];
/*

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                dp[0][j] = Integer.MAX_VALUE - 1;
                if (j % coins[0] == 0) {
                    dp[1][j] = j / coins[0];
                } else {
                    dp[1][j] = Integer.MAX_VALUE - 1;
                }
            }
        }
*/


        for (int j = 0; j < sum + 1; j++) {
            dp[0][j] = Integer.MAX_VALUE - 1;
            if (j % coins[0] == 0) {
                dp[1][j] = j / coins[0];
            } else {
                dp[1][j] = Integer.MAX_VALUE - 1;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (coins[i - 1] <= j) {
                    dp[i][j] = Math.min(1 + dp[i][j - coins[i - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }


        return dp[n][sum];
    }

    public static void main(String[] args) {
        MinimumNoOfCoins mnc = new MinimumNoOfCoins();
        int coins[] = {9, 6, 5, 1};
        int sum = 11;
        System.out.println(mnc.getMinNoCoins(coins, sum));

    }

}
