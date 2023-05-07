package Three_Sum_Zero;

import java.util.*;

public class Leetcode_Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n - 3; i++) {
            int l = i + 1;
            int h = n - 1;

            while (l < h) {
                int sum = nums[i] + nums[l] + nums[h];

                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[l]);
                    list.add(nums[h]);

                    result.add(list);

                } else if (sum < 0) {
                    l++;
                } else {
                    h--;
                }
            }
        }

        return new ArrayList<>(result);

    }
}
