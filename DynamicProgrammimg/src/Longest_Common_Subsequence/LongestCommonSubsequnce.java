package Longest_Common_Subsequence;

////https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequnce {

    public static int longestCommonSubsequence(String str1, String str2) {

        int n1 = str1.length();
        int n2 = str2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];   //dp[i][j] denotes str1 of length i , and str2 of length j

        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];   // if match increase both pointer
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);  /// find matching with either way
                }
            }
        }

        return dp[0][0];

    }


    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde", "ace"));

        ///abdace   babce  matchings are  bace  abce
    }
}


