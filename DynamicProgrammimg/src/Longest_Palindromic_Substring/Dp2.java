package Longest_Palindromic_Substring;

public class Dp2 {
    public String longestPalindrome(String str) {
        int n= str.length();
        int maxLength=1;
        int idx=0;
        int [][] dp = new int[n][n];

        for (int i=0;i<n;i++){
            dp[i][i] =1;
        }

        for (int len=2; len<=n;len++){
            for(int i=0;len+i-1<n ;i++){
                int j= len+i-1;

                if(str.charAt(i) == str.charAt(j)){
                    if (len==2|| dp[i+1][j-1] ==1){
                        dp[i][j]=1;

                        if(j-i+1 >maxLength){
                            maxLength =j-i+1;
                            idx =i;
                        }
                    }
                }else{
                    dp[i][j]=0;
                }
            }
        }
        return str.substring(idx,idx+maxLength);
    }
}
