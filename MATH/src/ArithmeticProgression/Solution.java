package ArithmeticProgression;

import java.util.HashSet;

public class Solution {
    public static int solve(int[] A) {
        int n = A.length;
        int count = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            max = Math.max(A[i], max);
            min = Math.min(A[i], min);
            set.add(A[i]);
        }
        int diff = (max - min) /( n - 1);

        while (set.contains(max)) {
            count++;
            max =max-diff;
        }
        if (count == n) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 5, 1};
        System.out.println(solve(A));
    }
}

