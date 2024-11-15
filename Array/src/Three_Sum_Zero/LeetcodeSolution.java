package Three_Sum_Zero;

import java.util.*;

public class LeetcodeSolution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;


        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; ///avoid duplicate start with nums[i]
            int j = i + 1;
            int k = n - 1;


            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    while (j < k && nums[j] == nums[j - 1]) j++;  // once we get result as nums[i] fixed, and as array sorted need to avoid duplicate element of num[j]
                    while (j < k && nums[k] == nums[k + 1]) k--; // once we get result as nums[i] fixed, and as array sorted need to avoid duplicate element of num[j]
                } else if (sum > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        return result;
    }

}

