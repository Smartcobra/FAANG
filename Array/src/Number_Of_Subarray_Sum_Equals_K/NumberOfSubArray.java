package Number_Of_Subarray_Sum_Equals_K;

import java.util.HashMap;
import java.util.Map;

////https://leetcode.com/problems/subarray-sum-equals-k/
public class NumberOfSubArray {

    public int subarraySum(int[] nums, int k) {
        int count=0;
        int n=nums.length;
        int prefixSum=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);

        for (int num : nums) {
            prefixSum = prefixSum + num;

            if (map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
}
