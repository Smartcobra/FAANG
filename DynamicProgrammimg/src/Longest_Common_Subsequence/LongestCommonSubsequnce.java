package Longest_Common_Subsequence;

////https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequnce {

    public static int longestCommonSubsequence(String str1, String str2) {

        int n1 = str1.length();
        int n2 = str2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

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
//    int LongestCommonSubstr(string X, string Y) {
//
//        int m=X.length();
//        int n=Y.length();
//        int dp[m+1][n+1];
//
//        // initialization
//        for(int i=0;i<=m;i++)
//            dp[i][0]=0;   // Eg LCS of "abc" & "" = 0
//        for(int j=0;j<=n;j++)
//            dp[0][j]=0;   // Eg LCS of "" & "abc" = 0
//
//        for(int i=1;i<=m;i++)
//        {
//            for(int j=1;j<=n;j++)
//            {
//                if(X[i-1]==Y[j-1])
//                    dp[i][j]=1+dp[i-1][j-1];
//                else dp[i][j]=0;                   // ONLY THIS CHANGE
//            }
//        }
//        int maxLen=0;              // Now finding the max element
//        for(int i=1;i<=m;i++)
//        {
//            for(int j=1;j<=n;j++)
//                maxLen=max(maxLen,dp[i][j]);
//        }
//        return maxLen;
//    }
//}


