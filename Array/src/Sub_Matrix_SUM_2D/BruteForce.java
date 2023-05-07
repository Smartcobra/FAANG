package Sub_Matrix_SUM_2D;

public class BruteForce {
    public static int getMaxSum(int[][] arr) {

        int R = arr.length;
        int C = arr[0].length;

        int[][] prefix_row = new int[R][C];
        int[][] prefix_arr = new int[R][C];
        int sum = 0;
        int maxsum = Integer.MIN_VALUE;


        ///row prefix
        for (int i = 0; i < R; i++) {
            prefix_row[i][0] = arr[i][0];
            for (int j = 1; j < C; j++) {
                prefix_row[i][j] = prefix_row[i][j - 1] + arr[i][j];
            }
        }

        /// prefix 2d arr
        for (int i = 0; i < C; i++) {
            prefix_arr[0][i] = prefix_row[0][i];
            for (int j = 1; j < R; j++) {
                prefix_arr[j][i] = prefix_arr[j - 1][i] + prefix_row[j][i];
            }
        }

        for (int a1 = 0; a1 < R; a1++) {
            for (int b1 = 0; b1 < C; b1++) {
               // sum = 0;
                for (int a2 = a1; a2 < R; a2++) {
                    for (int b2 = b1; b2 < R; b2++) {
                        sum = prefix_arr[a2][b2];
                        if (a1 != 0) {
                            sum = sum - prefix_arr[a1 - 1][b2];
                        }
                        if (b1 != 0) {
                            sum = sum - prefix_arr[a2][b1 - 1];
                        }
                        if (a1 != 0 && b1 != 0) {
                            sum = sum + prefix_arr[a1 - 1][b1 - 1];
                        }
                        maxsum = Math.max(sum, maxsum);

                    }
                }
            }
        }

        return maxsum;

    }

    public static void main(String[] args) {
        int[][] matrix = {{0, -2, -7, 0},
                {9, 2, -6, 2},
                {-4, 1, -4, 1},
                {-1, 8, 0, -2}};

        // Function Call
        System.out.println(getMaxSum(matrix));
    }

}
