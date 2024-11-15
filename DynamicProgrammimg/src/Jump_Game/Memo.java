package Jump_Game;

public class Memo {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] dp = new Boolean[n];
        return solve(nums, 0, n, dp);
    }

    private boolean solve(int[] nums, int idx, int n, Boolean[] dp) {
        if (idx == n - 1) return true;

        if (dp[idx] !=null) {
            return dp[idx];
        }

        for (int i = 1; i <= nums[idx]; i++) {
            if (solve(nums, idx + i, n,dp)) {
                return dp[idx] = true;
            }
        }

        return dp[idx] = false;

    }
}
