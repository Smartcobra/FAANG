package Permutations_OF_A_IN_B;


import java.util.Arrays;

public class PermutationsOFAINB {

    public static int solve(String A, String B) {
        int n = A.length();
        int m = B.length();
        long[] hash = new long[26];
        int MOD = 1000 * 1000 * 1000 + 7;
        int val = 97;
        long pow = 1;
        long hashA = 0;
        long hashB = 0;
        int count = 0;

        if (m < n) return 0;

        for (int i = 0; i < 26; i++) {
            if (i != 0) pow = (pow * 23) % MOD;
            hash[i] = (pow * val) % MOD;
        }
        System.out.println(Arrays.toString(hash));
        for (int i = 0; i < n; i++) {
            hashA = (hashA + hash[A.charAt(i) - 'a']) % MOD;
            hashB = (hashB + hash[B.charAt(i) - 'a']) % MOD;
        }

        if (hashA == hashB) count++;

        for (int i = n; i < m; i++) {
            hashB = (hashB - hash[B.charAt(i - n) - 'a'] + hash[B.charAt(i) - 'a'] + MOD) % MOD;
            if (hashA == hashB) count++;
        }

        return count;
    }

    public static void main(String[] args) {
       // System.out.println(solve("abc", "abcbacabc"));

        System.out.println(solve("p", "pccdpeeooadeocdoacddapacaecb"));


    }
}
