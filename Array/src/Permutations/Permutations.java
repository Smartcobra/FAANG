package Permutations;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/permutations/
public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(new ArrayList<>(), ans, nums);
        return ans;
    }

    public void backtrack(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int num: nums) {  //  we are picking one number from the given number
            /*
             *   1 2 3 ,  we pick 1 and tell  2 3 to permutation them self
             */
            if (!curr.contains(num)) {
                curr.add(num);
                backtrack(curr, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }
}