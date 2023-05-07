package Range_Sum_Query_2D.leetcode;

public class NumMatrix {
    private int[][] data;

    public NumMatrix(int[][] matrix) {

        int R = matrix.length;
        int C = matrix[0].length;
        data = new int[R][C];

        data[0][0] = matrix[0][0];
        for (int i = 1; i < C; i++) {
            data[0][i] = matrix[0][i] + data[0][i - 1];
        }

        for (int i = 1; i < R; i++) {
            data[i][0] = matrix[i][0] + data[i - 1][0];
        }

        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                data[i][j] = matrix[i][j] + data[i - 1][j] + data[i][j - 1] - data[i - 1][j - 1];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = data[row2][col2];

        if (col1 != 0) {
            sum = sum - data[row2][col1 - 1];
        }
        if (row1 != 0) {
            sum = sum - data[row1 - 1][col2];
        }
        if (row1 != 0 && col1 != 0) {
            sum = sum + data[row1 - 1][col1 - 1];
        }

        return sum;
    }
}
