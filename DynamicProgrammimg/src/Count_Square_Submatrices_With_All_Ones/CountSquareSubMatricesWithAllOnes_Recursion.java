package Count_Square_Submatrices_With_All_Ones;
//https://leetcode.com/problems/count-square-submatrices-with-all-ones/submissions/1435172246/
public class CountSquareSubMatricesWithAllOnes_Recursion {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    result = result + solve(i, j, matrix, m, n);
                }
            }
        }

        return result;

    }

    private int solve(int i, int j, int[][] matrix, int m, int n) {
        if (i >= m || j >= n) {
            return 0;
        }

        if (matrix[i][j] == 0) {
            return 0;
        }

        int right = solve(i, j + 1, matrix, m, n);
        int diag = solve(i + 1, j + 1, matrix, m, n);
        int down = solve(i + 1, j, matrix, m, n);

        return 1 + Math.min(right, Math.min(diag, down));

    }
}
