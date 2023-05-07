package Count_Subarray_Sum_Equals_K;

import java.util.HashMap;

public class subarraySum_HashMap {
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> map= new HashMap<>();
        int count=0;
        int n=nums.length;
        int prefixSum=0;
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
