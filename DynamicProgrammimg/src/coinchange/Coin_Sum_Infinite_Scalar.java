package coinchange;

import java.util.ArrayList;

//https://www.scaler.com/academy/mentee-dashboard/class/35040/assignment/problems/319?navref=cl_tt_lst_nm
public class Coin_Sum_Infinite_Scalar {
    public int coinchange2(ArrayList<Integer> arr, int sum) {
        int MOD = 1000 * 1000 + 7;
        int n = arr.size();
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (arr.get(i - 1) <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr.get(i - 1)];
                    dp[i][j] = dp[i][j] % MOD;
                } else {
                    dp[i][j] = dp[i - 1][j];
                    dp[i][j] = dp[i][j] % MOD;
                }
            }
        }

        return dp[n][sum];

    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        int sum = 4;
        Coin_Sum_Infinite_Scalar ss = new Coin_Sum_Infinite_Scalar();
        System.out.println(ss.coinchange2(arr, sum));
    }
}
