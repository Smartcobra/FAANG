package CountRectangles;

import java.util.HashSet;

public class Solution {
    public int solve(int[] A, int[] B) {
        int n = A.length;
        int count = 0;

        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(A[i] + "-" + B[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int Ai = A[i];
                int Bi = B[i];
                int Aj = A[j];
                int Bj = B[j];

                if (Ai == Aj || Bi == Bj) continue;

                if (set.contains(A[j] + "-" + B[i]) && set.contains(A[i] + "-" + B[j])) {
                    count++;
                }

            }
        }
        return count / 2;
    }
}
