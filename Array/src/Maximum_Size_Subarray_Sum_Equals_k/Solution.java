package Maximum_Size_Subarray_Sum_Equals_k;

///https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/

import java.util.HashMap;

public class Solution {
    public static int maxSubArrayLen(int[] nums, int k) {
        int n=nums.length;
        int prefixSum=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        int longestSubArrayLen=0;
        map.put(0,-1);
        for(int i=0;i<n;i++){
            prefixSum +=nums[i];

            if(prefixSum==k){
                longestSubArrayLen=i+1;
            }

            if(map.containsKey(prefixSum-k)){
                longestSubArrayLen=Math.max(longestSubArrayLen,i-map.get(prefixSum-k));
            }

            if(!map.containsKey(prefixSum)){
                map.put(prefixSum,i);
            }
        }

        return longestSubArrayLen;

    }

    public static void main(String[] args) {
        int [] arr= {1,-1,5,-2,3};
        System.out.println(maxSubArrayLen(arr,3));
    }
}