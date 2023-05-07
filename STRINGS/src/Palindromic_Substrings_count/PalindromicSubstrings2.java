package Palindromic_Substrings_count;

///https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstrings2 {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;

        for (int g = 0; g < s.length(); g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                boolean b=s.charAt(i) == s.charAt(j);
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    dp[i][j] = b;
                } else {
                    dp[i][j] = b && dp[i + 1][j - 1];
                }

                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
