package Kth_Smallest_SelectionSort;

public class Solution {
    public static int kthsmallest(final int[] A, int B) {
        int n = A.length;
        //int idx = -1;

        for (int i = 0; i < B; i++) {
            int min = A[i];
            int idx = i; ///current min
            for (int j = i; j < n; j++) {
                if (A[j] < min) {
                    min = A[j];
                    idx = j;
                }
            }
            swap(A,i, idx);
        }

        return A[B - 1];
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void main(String[] args) {
        int []A={ 8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35,
                91, 36, 44, 9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92};
        int B=9;

//        int [] A={2, 1, 4, 3, 2};
//       int  B = 3;

        System.out.println(kthsmallest(A,B));
    }
}
