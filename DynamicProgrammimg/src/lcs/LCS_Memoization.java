package lcs;

public class LCS_Memoization {

    public int getLCS(String s1, String s2) {
        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int m = str1.length;
        int n = str2.length;

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }

        int ans = getLCSHelper(str1, str2, m, n, dp);

        return ans;

    }

    private int getLCSHelper(char[] str1, char[] str2, int m, int n, int[][] dp) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (dp[m][n] != -1) {
            return dp[m][n];
        }
        if (str1[m - 1] == str2[n - 1]) {
            dp[m][n] = 1 + getLCSHelper(str1, str2, m - 1, n - 1, dp);
        } else {
            dp[m][n] = Math.max(getLCSHelper(str1, str2, m - 1, n, dp), getLCSHelper(str1, str2, m, n - 1, dp));
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        LCS_Memoization lr = new LCS_Memoization();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(lr.getLCS(s1, s2));
    }
}
