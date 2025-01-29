package Palindromic_Substrings_count;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        int n= s.length();

        for (int l = 1; l <=n; l++) {  // length of the substring , maximum length will be n
            for (int i = 0; i+l-1<n; i++) {  // i+l will check the substring suppose l=2,(length of substring start at i
                int  j= i+l-1;  // pointer to move in substring
                if (i==j) { // one length
                    dp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (i+1 == j) { // for 2 length
                            dp[i][j] = b;
                    } else {
                        if (b && dp[i + 1][j - 1]) {    ///   a    b    c    c    b    a
                            dp[i][j] = true;            //        i+1            j-1
                        }
                    }
                }

                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
