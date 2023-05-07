package Minimum_Falling_Path_Sum;

public class MinimumFallingPathSum_DP {
    public int findMinFallingPathSum(int[][] matrix) {
        int C = matrix[0].length;
        int R = matrix.length;
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[R][C];
        for (int c = 0; c < C; c++) {
            dp[0][c] = matrix[0][c];  /// o-th row have all the data as same as Matrix
        }
        for (int r = 1; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (c < 1) {
                    dp[c][r] = matrix[c][r] + Math.min(dp[r - 1][c], dp[r - 1][c + 1]);
                } else if (c <= C - 1) {
                    dp[c][r] = matrix[c][r] + Math.min(dp[r - 1][c], dp[r - 1][c - 1]);
                } else {
                    dp[c][r] = matrix[c][r] + Math.min(dp[r - 1][c], Math.min(dp[r - 1][c + 1], dp[r - 1][c - 1]));
                }
            }
        }
        for (int i = 0; i < C; i++) {
            ans = Math.min(ans, dp[R - 1][i]);
        }

        return ans;
    }
}
