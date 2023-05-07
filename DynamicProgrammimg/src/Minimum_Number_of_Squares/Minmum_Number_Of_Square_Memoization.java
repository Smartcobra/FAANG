package Minimum_Number_of_Squares;

import java.util.Arrays;

public class Minmum_Number_Of_Square_Memoization {
    public static int getMinSquare(int N,int[]dp) {
        if (N == 0 || N == 1 || N == 2 || N == 3) return N;

        if(dp[N]!=Integer.MAX_VALUE){
            return dp[N];
        }

        for (int i = 1; i * i <= N; i++) {
            dp[N] = Math.min( dp[N], 1 + getMinSquare((N - i * i),dp));
        }

        return dp[N];
    }

    public static int GetMinSquareMemo(int N){
        int [] dp= new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
       return getMinSquare(N,dp);


    }


    public static void main(String[] args) {
        System.out.println(GetMinSquareMemo(13));
    }
}
