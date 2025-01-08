package Minimum_Size_Subarray_Sum_209;

public class Minimum_Size_Subarray_Sum_TWO_Pointer {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int start = 0;

        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];

            while (sum >= target) {
                ans = Math.min(ans, i - start + 1);
                sum = sum - nums[start];
                start++;
            }
        }

        return (ans != Integer.MAX_VALUE) ? ans : 0;

    }

}
