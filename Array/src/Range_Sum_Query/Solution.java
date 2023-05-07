package Range_Sum_Query;

import java.util.Arrays;
import java.util.Collections;

public class Solution {

    public static long[] rangeSum(int[] A, int[][] B) {

        int n = A.length;
        int m = B.length;

        long[] prefix_A = new long[n];
        prefix_A[0] = A[0];


        for (int i = 1; i < n; i++) {
            prefix_A[i] = prefix_A[i - 1] + A[i];
        }

        long[] ans = new long[m];

        for (int i = 0; i < m; i++) {
            int l = B[i][0];
            int r = B[i][1];
            if (l == 1) {
                ans[i] = prefix_A[r - 1];
            } else {
                ans[i] = prefix_A[r - 1] - prefix_A[l - 2];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {7, 3, 1, 5, 5, 5, 1, 2, 4, 5};
       int [][] B= { {7, 10},{3, 10}, {3, 5}, {1, 10} };

        long[] longs = rangeSum(A, B);

       for (int i=0;i<longs.length;i++){
           System.out.println(longs[i]);
       }

    }
}
