package Longest_Palindrome_Subsequence;

public class LPS_Memoization {

    public static int getLPSHelper(String str){
        int n= str.length();
        int dp[][]= new int [n+1][n+1];

        for(int i=0;i<=dp.length-1;i++){
            for(int j=0;j<=dp[0].length-1;j++){
                dp[i][j]=-1;
            }
        }
        return getLPS(str,0,n-1,dp);
    }


    public static int getLPS( String str, int i, int j,int dp[][]){

        if(i>j){
            return 0;
        }
        if(i==j){
            return 1;
        }
        if(dp[i][j] !=-1){
            return dp[i][j];
        }

        if(str.charAt(i)==str.charAt(j)){
                dp[i][j]= 2+getLPS(str,i+1,j-1,dp);
        }else{
            dp[i][j]= Math.max(getLPS(str,i,j-1,dp),getLPS(str,i+1,j,dp));
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        String X = "aedbcbea";

        System.out.print("The length of the longest palindromic subsequence is :::Memoization  "
                + getLPSHelper(X));
    }
}
