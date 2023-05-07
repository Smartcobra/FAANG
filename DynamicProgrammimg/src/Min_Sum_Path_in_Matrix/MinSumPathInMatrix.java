package Min_Sum_Path_in_Matrix;

import java.util.Arrays;

public class MinSumPathInMatrix {
    public static int minPathSum(int[][] matrix) {
        int minFallingSum = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));

        minFallingSum = Math.min(minFallingSum, findMinFallingPathSum_Helper(matrix, 0, 0, dp));

        return minFallingSum;
    }

    private static int findMinFallingPathSum_Helper(int[][] matrix, int row, int col, int[][] dp) {
        if (col == matrix[0].length || row == matrix.length) return Integer.MAX_VALUE;

        if (col == matrix[0].length - 1 && row == matrix.length - 1) {
            return matrix[row][col];
        }

        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }

        int left = findMinFallingPathSum_Helper(matrix, row, col + 1, dp);
        int right = findMinFallingPathSum_Helper(matrix, row + 1, col, dp);

        dp[row][col] = Math.min(left, right) + matrix[row][col];

        return dp[row][col];
    }

    public static void main(String[] args) {
        int[][] matrix = {{20, 29, 84, 4, 32, 60, 86, 8, 7, 37},
                {77, 69, 85, 83, 81, 78, 22, 45, 43, 63},
                {60, 21, 0, 94, 59, 88, 9, 54, 30, 80},
                {40, 78, 52, 58, 26, 84, 47, 0, 24, 60},
                {40, 17, 69, 5, 38, 5, 75, 59, 35, 26},
                {64, 41, 85, 22, 44, 25, 3, 63, 33, 13},
                {2, 21, 39, 51, 75, 70, 76, 57, 56, 22},
                {31, 45, 47, 100, 65, 10, 94, 96, 81, 14}
        };
        System.out.println(minPathSum(matrix));

    }
}
