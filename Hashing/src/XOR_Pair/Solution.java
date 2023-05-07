package XOR_Pair;

import java.util.HashSet;

public class Solution {
    public static int solve(int[] A, int B) {
        int result = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < A.length; i++) {
            if (set.contains(B ^ A[i])) {
                result++;
            } else {
                set.add(A[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int [] A={5, 4, 10, 15, 7, 6};
        int B = 5;
        System.out.println(solve(A,B));

    }

}
