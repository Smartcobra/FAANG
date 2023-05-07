package N_digit_numbers;
//https://www.scaler.com/academy/mentee-dashboard/class/35031/assignment/problems/368/?navref=cl_pb_nv_tb
public class N_Digit_Numbers_DP {
    public static int solve(int n, int sum) {
        int MOD = 1000 * 1000 * 1000 + 7;
        int[][] dp = new int[n + 1][sum + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (i == 1) {
                        dp[i][j] = (j<=9?1:0);
                    /*if (j <= 9) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }*/
                } else {
                    for (int k = 0; k <= 9; k++) {
                        if (j > k) {
                            dp[i][j] = dp[i][j] + dp[i - 1][j - k];
                            dp[i][j] = dp[i][j] % MOD;
                        }
                    }
                }
            }
        }
        return dp[n][sum];

    }

    public static void main(String[] args) {
        System.out.println(solve(4, 10));
    }
}
