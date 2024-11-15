package Count_Square_Submatrices_With_All_Ones;

public class UsingBottomUp {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;

        int[][] dp = new int[m][n];
        for(int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] == 0 ? 0 : 1;
                }

                if (matrix[i][j] == 1) {
                    dp[i][j] = 1 + Math.min(matrix[i - 1][j], Math.min(matrix[i][j - 1], matrix[i - 1][j - 1]));
                }

                result += dp[i][j];
            }
        }
        return result;
    }
}
