package Jump_Game;

public class Recursion {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        return solve(nums, 0, n);
    }

    private boolean solve(int[] nums, int idx, int n) {
        if (idx == n - 1) return true;

        for (int i = 1; i <= nums[idx]; i++) {
            if (solve(nums, idx + i, n)) return true;
        }

        return false;

    }
}
