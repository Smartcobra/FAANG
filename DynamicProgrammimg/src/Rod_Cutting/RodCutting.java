package Rod_Cutting;

public class RodCutting {
    public static int solve(int[] price) {
        int n = price.length;
        int[] length = new int[n];
        for (int i = 0; i < n; i++) {
            length[i] = i + 1;
        }
        int[][] dp = new int[n + 1][n + 1];


        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if (length[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], price[i-1] + dp[i][j - length[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        int[] A = {3, 4, 1, 6, 2};
        System.out.println(solve(A));
    }
}
