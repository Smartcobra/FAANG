package Length_OF_Longest_Fibonacci_Subsequence;

import java.util.HashMap;

public class Length_OF_Longest_Fibonacci_Subsequence {

    public int solve(int[] A) {
        int n = A.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int[][] dp = new int[n][n];
        int ans = 0;

        for (int i = 0; i < n; i++) {
            map.put(A[i], i);
        }

        for (int k = 0; k < n; k++) {
            for (int j = 0; j < k; j++) {
                if (A[k] - A[j] < A[j] && map.containsKey(A[k] - A[j])) {
                    int i = map.get(A[k] - A[j]);
                    dp[j][k] = dp[i][j] + 1;
                    ans = Math.max(ans, dp[j][k] + 2);
                }

            }
        }

        if (ans >= 3) {
            return ans;
        } else {
            return 0;
        }

    }
}
