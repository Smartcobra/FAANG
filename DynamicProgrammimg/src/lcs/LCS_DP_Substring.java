package lcs;

public class LCS_DP_Substring {

    public String getLCS_SubString(String X, String Y) {

        int m = X.length();
        int n = Y.length();
        int dp[][] = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j<n; j++) {
                if (X.charAt(i) == Y.charAt(j)) {
                    dp[i+1][j+1] = 1+dp[i][j];
                } else {
                    dp[i+1][j+1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for(int i=X.length(),j=Y.length(); i!=0 &&j!=0;){
            if(dp[i][j]==dp[i-1][j]){
                i--;
            }else if(dp[i][j] == dp[i][j-1]){
                j--;
            }else {
                assert dp[i][j] == dp[i-1][j-1];
                    //assert X.charAt(i - 1) == Y.charAt(j - 1);
                sb.append(X.charAt(i - 1));
                i--;
                j--;
            }

        }

        System.out.println(dp[m][n]);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        LCS_DP_Substring ld = new LCS_DP_Substring();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println(ld.getLCS_SubString(s1, s2));
    }
}
