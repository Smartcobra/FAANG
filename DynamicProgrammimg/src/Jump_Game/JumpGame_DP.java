package Jump_Game;
///https://leetcode.com/problems/jump-game/
import java.util.Arrays;

public class JumpGame_DP {
    public boolean canJump(int[] nums) {
        int n= nums.length;
        boolean[] dp = new boolean[n];  //dp[i] = true: means mai i tak pahanch sakta hun
                                        //dp[i] = false means mai i tak nehi pahanch sakta hun
        dp[0] = true;

        for (int i=1;i<n;i++) {
            for (int j = i - 1; j>=0; j--) {
                if (dp[j] && j+nums[j] >=i) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n-1];
    }
}
