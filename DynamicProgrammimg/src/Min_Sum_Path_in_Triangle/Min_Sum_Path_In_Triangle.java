package Min_Sum_Path_in_Triangle;

import java.util.ArrayList;
import java.util.Arrays;

public class Min_Sum_Path_In_Triangle {
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][n];
        Arrays.stream(dp).forEach(a -> Arrays.fill(a, Integer.MAX_VALUE));

        return minimumTotal_Helper(triangle, dp, 0, 0);
    }

    private int minimumTotal_Helper(ArrayList<ArrayList<Integer>> triangle, int[][] dp, int row, int col) {
        int n = triangle.size();
        if (row == n - 1) {
            return triangle.get(row).get(col);
        }
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        int down = triangle.get(row).get(col) + minimumTotal_Helper(triangle, dp, row + 1, col);
        int diagonal = triangle.get(row).get(col) + minimumTotal_Helper(triangle, dp, row + 1, col + 1);

        dp[row][col] = Math.min(down, diagonal);
        return dp[row][col];
    }
}
