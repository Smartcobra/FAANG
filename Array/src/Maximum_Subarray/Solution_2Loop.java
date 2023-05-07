package Maximum_Subarray;

public class Solution_2Loop {
    public int maxSubArray(int[] nums) {
        int maxSubarray = Integer.MIN_VALUE;


        for (int i = 0; i < nums.length; i++) {
            int currSum = 0;
            for (int j = i; j < nums.length; j++) {
                currSum += nums[j];
                maxSubarray = Math.max(maxSubarray, currSum);
            }
        }

        return maxSubarray;
    }
}
