package Minimum_Falling_Path_Sum;

import java.util.Arrays;

public class MinimumFallingPathSum_Memoization {

    public int findMinFallingPathSum(int[][] matrix) {
        int minFallingSum = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));
        for (int i = 0; i < matrix[0].length; i++) {
            minFallingSum = Math.min(minFallingSum, findMinFallingPathSum_Helper(matrix, 0, i, dp));
        }
        return minFallingSum;

    }

    private int findMinFallingPathSum_Helper(int[][] matrix, int row, int col, int[][] dp) {
        if (col < 0 || col == matrix[0].length) {
            return Integer.MAX_VALUE;
        }
        if (row == matrix.length - 1) {
            return matrix[row][col];
        }

        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        int left = findMinFallingPathSum_Helper(matrix, row + 1, col - 1, dp);
        int right = findMinFallingPathSum_Helper(matrix, row + 1, col + 1, dp);
        int mid = findMinFallingPathSum_Helper(matrix, row + 1, col, dp);

        dp[row][col] = Math.min(left, Math.min(right, mid)) + matrix[row][col];

        return dp[row][col];
    }
}
