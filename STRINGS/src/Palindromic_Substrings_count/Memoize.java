package Palindromic_Substrings_count;

import java.util.Arrays;

public class Memoize {
    public static int countPalindrome(String s){
        int n= s.length();
        int count=0;
        int [][]dp = new int[n+1][n+1];

        for (int i=0;i<=n;i++){
            Arrays.fill(dp[i],-1);
        }

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j,dp) ==1){
                    count++;
                }
            }
        }
        return count;
    }

    private static int isPalindrome(String s, int start, int end, int[][] dp) {
        if(start>end){
            return 1;
        }
        if(dp[start][end] !=-1){
            return dp[start][end];
        }

        if(s.charAt(start) == s.charAt(end)){
            return dp[start][end]=isPalindrome(s,start+1,end-1,dp);
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(countPalindrome("a"));
    }
}
