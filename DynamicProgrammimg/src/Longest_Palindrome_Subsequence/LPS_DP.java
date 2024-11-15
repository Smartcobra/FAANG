package Longest_Palindrome_Subsequence;

public class LPS_DP {
    public static int getLPS(String str) {
        int[][] dp = new int[str.length()][str.length()];

        for (int g = 0; g < dp.length; g++) {
            for (int i = 0, j = g; j < dp.length; j++, i++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1) {
                    dp[i][j] = str.charAt(i) == str.charAt(j) ? 2 : 1;
                } else {
                    if (str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = 2 + dp[i + 1][j - 1];
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }

        }
        return dp[0][str.length() - 1];
    }

    public static void main(String[] args) {
        String X = "aedbcbea";

        System.out.print("The length of the longest palindromic subsequence is :::Memoization  "
                + getLPS(X));
    }
}
