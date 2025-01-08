package Shortest_Subarray_With_Sum_At_Least_K;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/description/
public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n=nums.length;
        int ans =Integer.MAX_VALUE;
        int [] pfxArr = new int[n];
        Deque<Integer> dq = new LinkedList<>();
        pfxArr[0] =nums[0];

        for(int i=1;i<n;i++){
            pfxArr[i] = pfxArr[i-1]+nums[i];
        }

        int j=0;

        for(int i=0;i<n;i++){

            while(!dq.isEmpty() && pfxArr[i] - pfxArr[dq.peekFirst()] >=k){
                ans = Math.min(ans,i-dq.peekFirst());
                dq.pollFirst();
            }

            while (!dq.isEmpty() && pfxArr[i] <= pfxArr[dq.peekLast()]){
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        return ans ==Integer.MAX_VALUE ? -1:ans;

    }
}
