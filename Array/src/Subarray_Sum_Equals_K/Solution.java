package Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class Solution {

    public int subarraySum(int[] arr, int target) {
        int n = arr.length;
        int[] pfx = new int[n];
        Map<Integer, Integer> map = new HashMap<>();
        pfx[0] = arr[0];
        int ans = 0;

        for (int i = 1; i < n; i++) {
            pfx[i] = pfx[i - 1] + arr[i];
        }

        for (int j = 0; j < n; j++) {
            if (pfx[j] == target) ans++;

            int val = pfx[j] - target;    ///val is basically pfx[i-1]

            if (map.containsKey(val)) {
                ans += map.get(val);
            }
            map.put(pfx[j], map.getOrDefault(pfx[j], 0) + 1);

        }


        return ans;
    }
}
