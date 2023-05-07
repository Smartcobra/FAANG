package Subsequence_Sum_Problem;

import java.util.ArrayList;

public class SubsequenceSum_Problem {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();

        for (int i = 0; i < n; i++) {
            if (B >= A.get(i)) {
                B = B - A.get(i);
            }
        }

        return B == 0 ? 1 : 0;
    }
}
