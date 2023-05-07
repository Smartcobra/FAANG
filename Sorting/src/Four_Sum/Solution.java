package Four_Sum;
//https://leetcode.com/problems/4sum/
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (i != start && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> threeSumAns = threeSum(nums, target - nums[i], i + 1, end);
            createResult(result, threeSumAns, nums[i]);
        }
        return result;
    }


    public List<List<Integer>> twoSum(int[] nums, long target, int start, int end) {
        List<List<Integer>> result = new ArrayList<>();

        while (start < end) {
            long sum = nums[start] + nums[end];
            if (sum < target) {
                start++;
            } else if (sum > target) {
                end--;
            } else {
                result.add(new ArrayList<>(Arrays.asList(nums[start], nums[end])));
                start++;
                end--;
                while (start < end && nums[start] == nums[start - 1]) start++;
                while (start < end && nums[end] == nums[end + 1]) end--;
            }
        }
        return result;

    }

    public List<List<Integer>> threeSum(int[] nums, long target, int start, int end) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (i != start && nums[i] == nums[i - 1]) continue;
            List<List<Integer>> threeSumAns = twoSum(nums, target - nums[i], i + 1, end);
            createResult(result, threeSumAns, nums[i]);
        }
        return result;

    }

    public void createResult(List<List<Integer>> result, List<List<Integer>> smallAns, int val) {
        for (List<Integer> sa : smallAns) {
            sa.add(val);
            result.add(sa);
        }
    }

}
