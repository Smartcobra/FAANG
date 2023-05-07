package Minimum_Swaps;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static int solve(ArrayList<Integer> A, int k) {
        int n = A.size();
        int ans = 0;
        int good = 0;
        int bad = 0;
        int count = 0;

        for (Integer a : A) {
            if (a <= k) count++;
        }

        for (int i = 0; i < count; i++) {
            if (A.get(i) > k) bad++;
        }

        ans = bad;
        for (int i = 0, j = count; j < n; i++, j++) {
            if (A.get(i) > k) bad--;
            if (A.get(j) > k) bad++;

            ans = Math.min(ans, bad);
        }

        return ans;
    }


    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<Integer>(
                Arrays.asList(2, 1, 5, 6, 3));
        // Arrays.asList(1, 12, 10, 3, 14, 10, 5));
        int k = 3;

        System.out.println(solve(arr, k));

    }

}
