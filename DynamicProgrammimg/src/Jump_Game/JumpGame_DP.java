package Jump_Game;
///https://leetcode.com/problems/jump-game/
import java.util.Arrays;

public class JumpGame_DP {
    public boolean canJump(int[] nums) {
        char[] memo = new char[nums.length];
        Arrays.fill(memo, 'U');
        memo[memo.length - 1] = 'G';

        for (int i = nums.length - 2; i >= 0; i--) {
            int furthestJump = i + nums[i];
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == 'G') {
                    memo[i] = 'G';
                    break;
                }
            }
        }

        return memo[0] == 'G';
    }
}
