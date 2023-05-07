package editDistance;

import java.util.Arrays;

public class EditDistance_Memoization {
    public static int min(int x,int y,int z){
        if(x<y && x<z){
            return x;
        }else if(y<x && y<z){
            return y;
        }else{
            return z;
        }
    }
    public static int getDistance(String str1,String str2,int m,int n,int dp[][]){

        if(m==0){
            return n;
        }
        if(n==0){
            return m;
        }
        if(dp[m][n] !=-1){
            return dp[m][n];
        }
        if(str1.charAt(m-1)==str2.charAt(n-1)){
            if(dp[m][n] ==-1){
                dp[m][n] = getDistance(str1,str2,m-1,n-1,dp);
            }
            return dp[m][n];

        }else{
            int cost_insert=0;
            int cost_remove=0;
            int cost_replace=0;
             //insert
            if(dp[m][n-1] ==-1){
                cost_insert=getDistance(str1,str2,m,n-1,dp);
            }else{
                cost_insert=dp[m][n-1];
            }
            //delte
            if(dp[m-1][n] ==-1){
                cost_remove=getDistance(str1,str2,m-1,n,dp);
            }else{
                cost_remove=dp[m-1][n];
            }
            //remove
            if(dp[m-1][n-1] ==-1){
                cost_replace=getDistance(str1,str2,m-1,n-1,dp);
            }else{
                cost_replace=dp[m-1][n-1];
            }

            return 1+min(cost_insert,cost_remove,cost_replace);//replace
        }
    }

    public static void main(String[] args) {
      //  String str1 = "sunday";
        //String str2 = "saturday";

        String str2 = "voldemort";
        String str1 = "dumbledore";

        int m=str1.length();
        int n=str2.length();
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 0; i < m + 1; i++)
            Arrays.fill(dp[i], -1);

        System.out.println(getDistance(
                str1, str2,m,n,dp ));
    }
}
