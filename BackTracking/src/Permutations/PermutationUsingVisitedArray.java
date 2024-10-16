package Permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationUsingVisitedArray {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<Integer> tmp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[nums.length];

        permute(nums, tmp, ans, isVisited);
    }

    private static void permute(int[] nums, List<Integer> tmp, List<List<Integer>> ans, boolean[] isVisited) {

        if (tmp.size() == nums.length) {
            List<Integer> l = new ArrayList<>(tmp);
            ans.add(l);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!isVisited[i]) {
                tmp.add(nums[i]);  // adding the num to tmp arr
                isVisited[i] = true; // making that number is visited
                permute(nums, tmp, ans, isVisited);  //recursion
                isVisited[i] = false; // backtrack
                tmp.remove(tmp.size() - 1); //backtrack
            }
        }

    }
}
