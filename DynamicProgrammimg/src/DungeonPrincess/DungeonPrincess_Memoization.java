package DungeonPrincess;

import java.util.Arrays;

public class DungeonPrincess_Memoization {
    int[][] dp;
    int n;
    int m;

    public int calculateMinimumHP(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        dp = new int[n][m];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, -1));
        dp[n - 1][m - 1] = Math.max(1, 1 - matrix[n - 1][m - 1]);
        return calculateMinimumHP_Helper(0, 0, matrix);
    }

    public int calculateMinimumHP_Helper(int i, int j, int[][] matrix) {
        if (i == n || j == m) {
            return Integer.MAX_VALUE;
        }

        if (dp[i][j] == -1) {
            int a = calculateMinimumHP_Helper(i, j + 1, matrix);
            int b = calculateMinimumHP_Helper(i + 1, j, matrix);
            dp[i][j]=Math.max(1,Math.min(a,b)-matrix[i][j]);
        }


        return dp[i][j];
    }
}
