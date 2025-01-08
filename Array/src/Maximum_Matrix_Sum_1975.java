
////https://leetcode.com/problems/maximum-matrix-sum/description/
public class Maximum_Matrix_Sum_1975 {

    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int absMin = Integer.MAX_VALUE;
        int countNtv = 0;

        for (int[] ints : matrix) {
            for (int j = 0; j < n; j++) {
                sum += Math.abs(ints[j]);
                //count
                if (ints[j] < 0) {
                    countNtv++;
                }

                absMin = Math.min(absMin, Math.abs(ints[j]));
            }
        }

        if (countNtv % 2 == 0) {
            return sum;
        } else {
            return sum - 2L * absMin;
        }

    }

}
