package Minimum_Number_of_Squares;

public class Minmum_Number_Of_Square_DP {
    public static int getMinSquare(int N) {
        int[] dp = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return dp[N];
    }

    public static void main(String[] args) {
        System.out.println(getMinSquare(13));
    }

}
