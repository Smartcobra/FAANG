package Range_Sum_Query_2D;

public class Optimized2 {
    public static int sumRegion(int[][] arr, int row1, int col1, int row2, int col2) {

        int sum = 0;
        ///first find the prefixarr
        int R = arr.length;
        int C = arr[0].length;
        int[][] prefix_row = new int[R][C];
        int[][] prefix_arr = new int[R][C];


        ////prefix row array
       // prefix_row[0][0] = arr[0][0];
        for (int i = 0; i < R; i++) {
            prefix_row[i][0] = arr[i][0];
            for (int j = 1; j < C; j++) {
                prefix_row[i][j] = arr[i][j] + prefix_row[i][j - 1];
            }
        }
          ////prifix col array or prefix array
       // prefix_arr[0][0] = prefix_row[0][0];
        for (int i = 0; i < R; i++) {
            prefix_arr[0][i] = prefix_row[0][i];
            for (int j = 1; j < C; j++) {
                prefix_arr[j][i] = prefix_row[j][i] + prefix_arr[j - 1][i];
            }
        }


        sum = prefix_arr[row2][col2];
        if (col1 != 0) {
            sum = sum - prefix_arr[row2][col1 - 1];
        }
        if (row1 != 0) {
            sum = sum - prefix_arr[row1 - 1][col2];

        }
        if (col1 != 0 && row1 != 0) {
            sum = sum + prefix_arr[row1 - 1][col1 - 1];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}
                , {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};

        System.out.println(sumRegion(matrix, 2, 1, 4, 3));
    }
}
