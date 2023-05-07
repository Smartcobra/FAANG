package Matrix_Median;

public class Solution_Array {
    public int findMedian(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int[] ints : A) {
            low = Math.min(low, ints[0]);
            high = Math.max(high, ints[m - 1]);
        }

        while (low <= high) {
            int mid = (low + high) >> 1;

            int count = 0;
            for (int i = 0; i < n; i++) {
                count = count + countSmallerThanMid(A[i], mid, m);
            }
            if (count <= (n * m) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public int countSmallerThanMid(int[] A, int mid, int col) {
        int low = 0;
        int high = col - 1;

        while (low <= high) {
            int md = (low + high) >> 1;

            if (A[md] <= mid) {
                low = md + 1;
            } else {
                high = md - 1;
            }
        }

        return low;
    }
}
