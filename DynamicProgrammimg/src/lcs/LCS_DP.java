package lcs;

public class LCS_DP {
    public int getLCS_DP(String s1, String s2) {

        char[] str1 = s1.toCharArray();
        char[] str2 = s2.toCharArray();

        int ans = getLCS_DP_helper(str1, str2);
        return ans;


    }

    private int getLCS_DP_helper(char[] str1, char[] str2) {
        int m = str1.length;
        int n = str2.length;

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (str1[i-1] == str2[j-1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];

    }
    public static void main(String[] args) {
        LCS_DP ld = new LCS_DP();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(ld.getLCS_DP(s1, s2));
    }
}
