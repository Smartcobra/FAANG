package Min_Sum_Path_in_Matrix;

import java.util.ArrayList;

public class MinSumPathInMatrix_DP_2 {
    // TODO: 06-11-2022  remove the 2 extra for loop
    public int minPathSum(ArrayList<ArrayList<Integer>> matrix) {
        int n = matrix.size();
        int m = matrix.get(0).size();
        int[][] dp = new int[n][m];
        dp[0][0] = matrix.get(0).get(0);

        for (int i = 1; i < n; i++) {
            dp[i][0] = matrix.get(i).get(0) + dp[i - 1][0];
        }

        for (int j = 1; j < m; j++) {
            dp[0][j] = matrix.get(0).get(j) + dp[0][j - 1];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + matrix.get(i).get(j);
            }
        }

        return dp[n - 1][m - 1];
    }
}
