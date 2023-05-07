package Maximum_Unsorted_Subarray;

import java.util.Arrays;

public class Solution {
    public static int[] subUnsort(int[] A) {
        int n = A.length;
        int right = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE;
//        int right =A[0];
//        int left = A[n-1];


        int s = 0;
        for (; s < n - 1; s++) {
            if (A[s] > A[s + 1]) break;
        }

        if (s == n - 1) return new int[]{-1};


        for (int i = 1; i < n; ++i)
//            if (A[i] < A[i - 1])
//                left = Math.min(A[i], left);
            if (A[i] >= A[i - 1]) {
                continue;
            } else {
                left = Math.min(A[i], left);
            }


        //System.out.println(left);

        for (int i = n - 2; i >= 0; --i)
            if (A[i] > A[i + 1])
                right = Math.max(A[i], right);

        //  System.out.println(right);


        int i = 0;
        for (; i < n; ++i)
            if (A[i] > left)
                break;

        int j = n - 1;
        for (; j >= 0; --j)
            if (A[j] < right)
                break;

        int[] result = new int[2];
        result[0] = i;
        result[1] = j;

        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4, 5};
        System.out.println(Arrays.toString(subUnsort(A)));
    }
}
