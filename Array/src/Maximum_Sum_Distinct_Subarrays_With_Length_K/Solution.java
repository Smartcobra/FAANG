package Maximum_Sum_Distinct_Subarrays_With_Length_K;

import java.util.HashSet;
import java.util.Set;

////https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/
public class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        long maxSum = 0;
        long windowSum = 0;
        int i = 0;

        for (int j = 0; j < n; j++) {

            while (set.contains(nums[j])) {
                set.remove(nums[i]);
                windowSum -= nums[i];
                i++;
            }

            set.add(nums[j]);
            windowSum += nums[j];

            if (j - i + 1 == k) {
                maxSum = Math.max(maxSum, windowSum);

                set.remove(nums[i]);
                windowSum -= nums[i];
                i++;
            }

        }

        return maxSum;

    }
}
