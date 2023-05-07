package Continuous_Subarray_Sum;

import java.util.HashMap;

///////https://leetcode.com/problems/continuous-subarray-sum/
public class ContinuousSubarraySum {

    public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,-1);
        int n=nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=sum+nums[i];
            int key=sum%k;
            if(!map.containsKey(key)){
                map.put(key,i);
            } else if (i-map.get(key)>1) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int [] arr={23,2,4,6,6};
        int k=7;
        System.out.println(checkSubarraySum(arr,7));
    }
}
