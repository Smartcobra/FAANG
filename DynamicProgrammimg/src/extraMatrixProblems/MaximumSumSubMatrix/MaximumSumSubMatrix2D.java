package extraMatrixProblems.MaximumSumSubMatrix;



public class MaximumSumSubMatrix2D {
    public static void findMaximumSumSubMatrix(int A[][]) {
        // int[][] M = new int[A.length][A.length];

        int rows = A.length;
        int cols = A[0].length;
        int ans = 0;
        //loop for c1,c2
        for (int c1 = 0; c1 < cols; c1++) {
            int rowSum[] = new int[rows];
            for (int c2 = c1; c2 < cols; c2++) {
                //filling row sum
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += A[i][c2];
                }
                ans = Math.max(ans, kadanes(rowSum));
            }
        }
        System.out.println(ans);


        //Stream.of(M).map(Arrays::toString).forEach(System.out::println);
        //System.out.println(rows +"---"+cols);

    }

    private static int kadanes(int[] rowSum) {
        int cur_sum = rowSum[0];
        int ovr_sum = rowSum[0];
        int start = 0;
        int end = 0;
        int temp_start=0;

        for (int i = 0; i < rowSum.length; i++) {
            if (cur_sum >= 0) {
                cur_sum += rowSum[i];
                temp_start=i;
            } else {
                cur_sum = rowSum[i];
            }

            if (cur_sum > ovr_sum) {
                ovr_sum = cur_sum;
                start=temp_start;
                end=i;
            }
        }
        return ovr_sum;
    }

    public static void main(String[] args) {
        int A[][] = {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };
        findMaximumSumSubMatrix(A);
    }
}
