package Subsets_II;



/*
Example 1:

Input: nums = [1,2,2]
Output: [[],[1],[1,2],[1,2,2],[2],[2,2]]

Example 2:

Input: nums = [0]
Output: [[],[0]]

 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
////////////               https://leetcode.com/problems/subsets-ii/
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        getAllSubsets(nums,ans,current,0);
        return ans;

    }

    private void getAllSubsets(int[] nums,List<List<Integer>> ans,List<Integer> current,int i){
        if(i == nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }

        current.add(nums[i]);
        getAllSubsets(nums,ans,current,i+1);
        current.remove(current.size()-1);

        ///remove duplicate
        int idx= i+1;
        while(idx<nums.length && nums[idx-1] == nums[idx]){
            idx++;
        }
        getAllSubsets(nums,ans,current,idx);
    }
}
