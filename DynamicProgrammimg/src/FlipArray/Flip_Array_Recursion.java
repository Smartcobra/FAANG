package FlipArray;

import java.util.Arrays;

public class Flip_Array_Recursion {
    public int solve(final int[] A) {
        int sum = Arrays.stream(A).sum();
        for (int i = sum / 2; i >= 1; i--) {
            int ans = (int) flipArray(A, A.length - 1, i);
            if (ans <= A.length) return ans; //Break if we have an answer close to halfSum
        }
        return -1;
    }


    private long flipArray(int[] arr, int n, int sum) {
        long ans;

        if (sum == 0) {
            return 0;
        }

        if (n == -1) {
            return arr.length + 1;
        }


        if (arr[n] <= sum) {
            ans = Math.min(flipArray(arr, n - 1, sum - arr[n]) + 1, flipArray(arr, n - 1, sum));
        } else {
            ans = flipArray(arr, n - 1, sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        // int[] arr = {15, 10, 6};
        int[] arr = {9, 6};

        Flip_Array_Recursion fr = new Flip_Array_Recursion();
        System.out.println(fr.solve(arr));

    }
}
