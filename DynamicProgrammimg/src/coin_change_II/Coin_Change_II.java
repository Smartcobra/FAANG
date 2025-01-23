package coin_change_II;
////https://leetcode.com/problems/coin-change-ii/
public class Coin_Change_II {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[301][5001];
        for(int i=0;i<=300;i++){
            for(int j=0;j<=5000;j++){
                dp[i][j] =-1;
            }
        }
        return solve(0,amount,coins,n,dp);
    }

    public int solve(int i, int amount, int[] coins,int n,int[][] dp ){
        if(amount==0){
            return 1;
        }

        if(dp[i][amount] != -1) return dp[i][amount];

        if(i>=n) return 0;

        if(coins[i] >amount){
            return solve (i+1,amount,coins,n,dp);
        }

        int skip = solve(i+1,amount,coins,n,dp);
        int take = solve(i,amount-coins[i],coins,n,dp);

        return dp[i][amount]= skip+take;
    }
}
