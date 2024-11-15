package Longest_Palindromic_Substring;

/*
for length 1 , all strings are palindrome
so we should start searching from 2
        abbadab  for length2  if we start l=2 , then i = 0, and j = i+2-1 or j = i+l-1 , and i will go till i+l-1<n or i< n-l+1
 */
public class Dp {
    public String longestPalindrome(String str) {
        int n = str.length();
        int[][] dp = new int[n][n];
        int maxLength = 0;
        int idx = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    dp[i][j] = 1;
                }
            }
        }

        for (int l =2;l<=n;l++){
            for(int i=0; i+l-1<n;i++){
                int j= i+l-1;

                if(str.charAt(i)==str.charAt(j) && l==2){
                    dp[i][j]=1;
                    maxLength=2;
                    idx =i;
                } else if (str.charAt(i)==str.charAt(j) && dp[i+1][j-1]==1) {
                    dp[i][j]=1;
                    if(j-i+1> maxLength){
                        maxLength = j-i+1;
                        idx =i;
                    }
                }else{
                    dp[i][j]=0;
                }
            }
        }

        return str.substring(idx,idx+maxLength);
    }

}
