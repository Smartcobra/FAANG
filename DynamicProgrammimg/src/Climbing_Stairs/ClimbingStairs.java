package Climbing_Stairs;

///https://leetcode.com/problems/climbing-stairs/
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n == 1) return 1;
        int[] dp = new int[n + 1];
        dp[n] = 1;    /// to reach n from n we need 1 step
        dp[n - 1] = 1;   // to reach n from n-1 we need 1

        for (int i = n - 2; i >= 0; i--) {
            dp[i] = dp[i + 1] + dp[i + 2];
        }

        return dp[0];

    }

    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

}
