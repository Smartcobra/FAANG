package Sub_Matrix_SUM_2D;

public class Kadens_2D {

    public static int getMaxSum(int[][] arr) {
        int R = arr.length;
        int C = arr[0].length;
        int maxSum = Integer.MIN_VALUE;

        int[] k_arr = new int[C];
        int[][] col_prefixArr = new int[R][C];

        //col Matrix
        for (int i = 0; i < C; i++) {
            col_prefixArr[0][i] = arr[0][i];
            for (int j = 1; j < R; j++) {
                col_prefixArr[j][i] = arr[j][i] + col_prefixArr[j - 1][i];
            }
        }
        //////////2d kadens
        for (int rowstart = 0; rowstart < R; rowstart++) {
            for (int rowend = rowstart; rowend < R; rowend++) {
                for (int k = 0; k <C; k++) {
                    if (rowstart == 0) {
                        k_arr[k] = col_prefixArr[rowend][k];

                    } else {
                        k_arr[k] = col_prefixArr[rowend][k] - col_prefixArr[rowstart - 1][k];
                    }
                }
                maxSum = Math.max(maxSum, kadensAlgo(k_arr));
            }
        }
        return maxSum;
    }
    //////////2d kadens

    private static int kadensAlgo(int[] k_arr) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < k_arr.length; i++) {
            sum += k_arr[i];

            maxSum = Math.max(sum, maxSum);
            if (sum < 0) sum = 0;
        }
        return maxSum;

    }

    public static void main(String[] args) {
//        int[][] matrix = {{1, 2, -1, -4, -20},
//                {-8, -3, 4, 2, 1},
//                {3, 8, 10, 1, 3},
//                {-4, -1, 1, 7, -6}};  //29

        int[][] matrix = {{0, -2, -7, 0},
                {9, 2, -6, 2},
                {-4, 1, -4, 1},
                {-1, 8, 0, -2}};

        // Function Call
        System.out.println(getMaxSum(matrix));
    }

}
