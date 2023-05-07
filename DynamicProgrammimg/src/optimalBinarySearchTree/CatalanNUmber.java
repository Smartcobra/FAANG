package optimalBinarySearchTree;

import java.util.Arrays;

public class CatalanNUmber {
    /////Using Recursive
    public int getCatalanNumberRecursive(int n) {
        int res = 0;
        if (n == 0) {
            return 1;
        }
        for (int i = 1; i <= n; i++) {
            res = res + getCatalanNumberRecursive(i - 1) * getCatalanNumberRecursive(n - i);
        }
        return res;
    }

    static int dp[] = new int[10];

    /////Using Memoization
    public int getCatalanNumber_Memoization(int n) {
        if (n<=1) {
            return 1;
        }

        if (dp[n] != 0) {
            return dp[n];
        }

        int res = 0;

        for (int i = 1; i <= n; i++) {
            res = res + getCatalanNumber_Memoization(i - 1) * getCatalanNumber_Memoization(n - i);
        }
        dp[n] = res;
        return dp[n];
    }
    /////Using DP
    public int getCatalanNumber_DP(int n){
        int dp[] = new int [n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+= dp[j]*dp[i-j-1];
            }
        }
        return dp[n];

    }
    public static void main(String[] args) {
        CatalanNUmber cn = new CatalanNUmber();
        System.out.println(cn.getCatalanNumberRecursive(4));
       // Arrays.fill(dp,-1);
        System.out.println("getCatalanNumber_Memoization::" + cn.getCatalanNumber_Memoization(5));
        System.out.println("getCatalanNumber_DP::" + cn.getCatalanNumber_DP(5));

    }
}
