package Contiguous_Array_Zero_One;

import java.util.HashMap;

public class Contiguous_Array_HashMap {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int maxlen = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }

        for (int i = 0; i < n; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                int end = map.get(sum);
                maxlen = Math.max(maxlen, i - end);
            } else {
                map.put(sum, i);
            }
        }

        return maxlen;
    }
}
