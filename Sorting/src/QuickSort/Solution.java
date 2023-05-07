package QuickSort;

import java.util.Arrays;

public class Solution {

    public static int[] solve(int[] A) {
        int s = 0;
        int e = A.length - 1;
        quickSort(A, s, e);
        return A;
    }

    public static void quickSort(int[] A, int s, int e) {
        if (s >= e) return;
        int p = rearrange(A, s, e);
        quickSort(A, s, p - 1);
        quickSort(A, p + 1, e);
    }

    public static int rearrange(int[] A, int s, int e) {
        int l = s + 1;
        int r = e;

        while (l <= r) {
            if (A[l] <= A[s]) l++;
            else if (A[r] > A[s]) r--;
            else {
                swap(A, l, r);
            }
        }
        swap(A, s, l - 1);
        return l - 1;
    }

    public static  void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int []A={1, 4, 10, 2, 1, 5 };
        System.out.println(Arrays.toString(solve(A)));
    }
}
