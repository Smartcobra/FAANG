package combination_sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] arr, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> curr = new ArrayList<>();
        combinationSumHelper(arr,target, 0, ans, curr);
        return new ArrayList<>(ans);
    }



    public static void combinationSumHelper (int[] arr, int target,int idx, Set<List<Integer>> ans, List<Integer> curr  ){
        if(target==0){
            ans.add( new ArrayList<>(curr));
        }

        if(idx==arr.length || target<0) return;

        curr.add(arr[idx]);
        combinationSumHelper(arr,target-arr[idx],idx+1,ans,curr);
        combinationSumHelper(arr,target-arr[idx],idx,ans,curr);
        curr.remove(curr.size()-1);
        combinationSumHelper(arr,target,idx+1,ans,curr);

    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 6, 7};
        int target = 7;

        List<List<Integer>> result = combinationSum(arr, target);

        System.out.println("Combinations that sum up to " + target + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }
}
