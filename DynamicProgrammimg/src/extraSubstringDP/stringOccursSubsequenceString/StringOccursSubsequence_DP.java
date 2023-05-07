package extraSubstringDP.stringOccursSubsequenceString;
//https://leetcode.com/problems/distinct-subsequences/

public class StringOccursSubsequence_DP {
    public static int countSubSequencesDP(String str1, String str2) {
        int m = str1.length();  // big string
        int n = str2.length();  // small string

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i <= n; i++)
            dp[0][i] = 0;

        for(int i=0;i<=m;i++){
            dp[i][0] = 1;

        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i-1][j];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "babgbag";
        String str2 = "bag";
        //String str1 = "subsequence";   // input string
        //String str2 = "sue";
        System.out.println(countSubSequencesDP(str1, str2));
    }
}
