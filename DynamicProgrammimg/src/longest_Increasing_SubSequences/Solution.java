package longest_Increasing_SubSequences;

import java.util.Arrays;

public class Solution {
    public int lengthOfLIS(int[] nums) {
        int n= nums.length;
        int[] dp = new int[n];
        int result =0;

        Arrays.fill(dp, 1);

        for(int i=0;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i] = Math.max(dp[j]+1,dp[i]);  // i re seta rahiba jouta j re thiba +1 , karana j ru i ku condition satisfy karuchi sthipain got adhika rahiba
                }
            }
            result = Math.max(dp[i],result);
        }
        return result;
    }
}
