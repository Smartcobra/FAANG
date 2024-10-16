package Binary_Tree_Maximum_Path_Sum;

import create.TreeNode;

////https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
public class BinaryTreeMaximumPathSum {
    int maxSum;

    private int maxPathSum_Helper(TreeNode root) {

        if (root == null) return 0;

        int l = maxPathSum_Helper(root.left);
        int r = maxPathSum_Helper(root.right);

        int niche_hi_milgeya_ans = l + r + root.val;  // this is the potential ans and path finished here
        int koi_ek_achha = Math.max(l, r) + root.val; // may the path cross root and return to his calling function
        int root_hi_achha = root.val; // root is the ans and path still open.

        maxSum = Math.max(maxSum, Math.max(niche_hi_milgeya_ans, Math.max(koi_ek_achha, root_hi_achha)));

        return Math.max(koi_ek_achha, root_hi_achha);
    }

    public int maxPathSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        maxPathSum_Helper(root);
        return maxSum;

    }
}
