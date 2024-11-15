package Path_Sum_II;

import create.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/path-sum-ii/
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();
        pathSumHelper(root,currList,ans,targetSum);
        return ans;
    }

    public void pathSumHelper(TreeNode root,List<Integer> currList, List<List<Integer>> ans,int targetSum){
        if(root==null){
            return;
        }
        currList.add(root.val);

        if(root.left==null && root.right==null){
            targetSum -= root.val;

            if(targetSum==0){
                ans.add(new ArrayList<>(currList));
            }
        }

        pathSumHelper(root.left,currList,ans,targetSum-root.val);
        pathSumHelper(root.right,currList,ans,targetSum-root.val);
        currList.remove(currList.size()-1);///callback function to check left and right


    }
}
