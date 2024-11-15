package Longest_Palindromic_Substring;

public class Memo {
    public static int isPalindrome(int i,int j, String str, int[][] dp){
        if(i>=j){
            return 1;
        }
        if(dp[i][j] !=-1){
            return dp[i][j];
        }

        if(str.charAt(i)==str.charAt(j)){
            return dp[i][j] = isPalindrome(i+1,j-1,str,dp);
        }
        return dp[i][j] =0;
    }

    public int getMaxLPS(String str){
        int n= str.length();
        int maxLen=0;
        int start=0;


        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=-1;
            }
        }

        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                if(isPalindrome(i,j,str,dp) ==1){
                    if(j-i+1> maxLen){
                        maxLen = j-i+1;
                        start=i;
                    }
                }
            }
        }
        System.out.println(str.substring(start,start+maxLen));

        return str.substring(start,maxLen+start).length();
    }
}
