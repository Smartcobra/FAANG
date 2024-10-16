package Longest_Palindromic_Substring;

////    https://leetcode.com/problems/longest-palindromic-substring/
public class longestPalindrome {
    public static String longestPalindrome(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // int count = 0;
        String result = "";

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                boolean b = s.charAt(i) == s.charAt(j);
                if (g == 0) {
                    dp[i][j] = true;
                } else if (g == 1) {
                    dp[i][j] = b;
                } else {
                    dp[i][j] = b && dp[i + 1][j - 1];
                }

                if (dp[i][j]) {
                    // count = 1 + g;
                    result = s.substring(i, j + 1);

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "cbbd";

        System.out.println(longestPalindrome(s));
    }
}
