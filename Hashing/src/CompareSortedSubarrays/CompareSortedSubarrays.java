package CompareSortedSubarrays;

import java.util.Arrays;
import java.util.HashSet;

//https://www.scaler.com/academy/mentee-dashboard/class/29547/homework/problems/522?navref=cl_tt_nv
/////not completed

public class CompareSortedSubarrays {

    public static int[] solve(int[] A, int[][] B) {
        HashSet<Integer> hashSet = new HashSet<>();
        int[] result = new int[B.length];
        int diff;
        int a, b;
        int l1, r1, l2, r2;

        for (int i = 0; i < B.length; i++) {
            l1 = B[i][0];
            r1 = B[i][1];
            l2 = B[i][2];
            r2 = B[i][3];
            diff = r2 - l2 + 1;
            a = 0;
            b = 0;

            for (int idx = l1; idx <= r1; idx++) {
                hashSet.add(A[idx]);
                if (hashSet.contains(A[idx]) && A[l2] == A[idx]) {
                    l2++;
                    a++;
                    hashSet.remove(A[idx]);
                } else if (hashSet.contains(A[idx]) && A[r2] == A[idx]) {
                    r2--;
                    b++;
                    hashSet.remove(A[idx]);
                } else
                    break;
            }
            if (diff == a + b)
                result[i] = 1;
            else
                result[i] = 0;
        }
        return result;
        // ============================

    }

    public static void main(String[] args) {
        int[] A = {1, 7, 11, 8, 11, 7, 1};
        int[][] B = {
                {0, 2, 4, 6}
        };
        System.out.println(Arrays.toString(solve(A, B)));
    }

}
