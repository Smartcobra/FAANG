package House_Robber;

////https://leetcode.com/problems/house-robber/

/*
 *
 *    f(n)= max( nums[0]+f(n-2) ,f(n-1) );
 *
 * */
public class HouseRobber {

    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n + 1];

        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            int skip = dp[i - 1];
            int steal = nums[i - 1] + dp[i - 2];
            dp[i] = Math.max(steal, skip);
        }

        return dp[n];

    }

}
