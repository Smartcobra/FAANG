package Path_Sum_III;

import create.TreeNode;
//https://leetcode.com/problems/path-sum-iii/
import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    int count = 0;
    int k;
    Map<Long, Integer> map = new HashMap<>();

    public void preorder(TreeNode node, long currSum) {
        if (node == null)
            return;

        // current prefix sum
        currSum += node.val;

        // here is the sum we're looking for
        if (currSum == k)
            count++;

        // number of times the curr_sum − k has occured already,
        // determines the number of times a path with sum k
        // has occured upto the current node
      //  count += map.getOrDefault(currSum - k, 0);
        if (map.containsKey(currSum - k)) {
            count += map.get(currSum - k);
        }
        // add the current sum into hashmap
        // to use it during the child nodes processing
        map.put(currSum, map.getOrDefault(currSum, 0) + 1);

        // process left subtree
        preorder(node.left, currSum);
        // process right subtree
        preorder(node.right, currSum);

        // remove the current sum from the hashmap
        // in order not to use it during
        // the parallel subtree processing
        map.put(currSum, map.get(currSum) - 1);  ///callback
    }

    public int pathSum(TreeNode root, int sum) {
        k = sum;
        preorder(root, 0L);
        return count;
    }
}
