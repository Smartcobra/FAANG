package KthPrice;

import java.util.Arrays;

public class Solution {
    public static int solve(final int[] A, int B) {
        int n = A.length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        int ans = low;
        for (int i = 0; i < n; i++) {
            low = Math.min(low, A[i]);
            high = Math.max(high, A[i]);
        }
        while (low <= high) {
            int mid = (low + high) / 2;

            if (count(A, mid) >= B) {
                ans = mid;
                high=mid - 1;
            } else {
                low = mid + 1;
            }

        }

        return ans;
    }

    public static int count(int[] A, int mid) {
        int count = 0;
        for (int a : A) {
            if (a <= mid)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int []A ={ 74, 90, 85, 58, 69, 77, 90, 85, 18, 36 };
        int B=1;

        int []A1= {8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15, 45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16, 66, 35, 91, 36, 44,
                9, 85, 58, 59, 49, 75, 20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92 };
       int B1 = 9;
        //Arrays.sort(A1);
        //System.out.println(Arrays.toString(A1));
        System.out.println(solve(A,B));
    }
}
