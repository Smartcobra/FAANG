package Climbing_Stairs;

public class Stairs {
    public int climbStairs(int A) {
        if(A==1) return 1;
        long [] dp = new long[A+1];
        int MOD=1000*1000*1000+7;
        dp[0]=1;
        dp[1]=1;
        dp[2]=2;


        for(int i=3;i<=A;i++){
            dp[i]=(dp[i-1]+dp[i-2])%MOD;
        }
        return (int)dp[A]%MOD;
    }
}
