package Permutations_OF_A_IN_B;
///https://www.scaler.com/academy/mentee-dashboard/class/29549/assignment/problems/1089?navref=cl_tt_nv
public class Solution {
    public int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        int MOD = 1000 * 1000 * 1000 + 7;
        long[] hash = new long[26];
        int val = 97;
        int count = 0;
        long hasA = 0;
        long hasB = 0;
        long pow = 1;

        if (m<n) return 0;

        for (int i = 0; i < 26; i++) {
            if (i != 0) pow = (23 * pow) % MOD;
            hash[i] = (pow * val) % MOD;
        }

        for (int i = 0; i < n; i++) {
            hasA = (hasA + hash[A.charAt(i) - 'a']) % MOD;
            hasB = (hasB + hash[B.charAt(i) - 'a']) % MOD;
        }

        if (hasA == hasB) count++;

        for (int k = n; k < m; k++) {
            hasB = (hasB - hash[B.charAt(k - n) - 'a'] + hash[B.charAt(k) - 'a'] + MOD) % MOD;
            if (hasA == hasB) count++;
        }

        return count;

    }
}
