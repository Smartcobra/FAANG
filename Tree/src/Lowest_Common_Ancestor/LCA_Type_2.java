package Lowest_Common_Ancestor;


///https://www.scaler.com/academy/mentee-dashboard/class/35020/assignment/problems/218/?navref=cl_pb_nv_tb

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class LCA_Type_2 {
    public int lca(TreeNode A, int B, int C) {
        TreeNode lca = findLCA(A, B, C);

        if (!isNodePresent(A, B) || !isNodePresent(A, C)) return -1;

        return lca != null ? lca.val : -1;

    }

    public boolean isNodePresent(TreeNode root, int target) {
        if (root == null) return false;

        if (root.val == target) return true;

        boolean left = isNodePresent(root.left, target);
        if (left) {
            return true;
        } else {
            return isNodePresent(root.right, target);
        }


    }

    public TreeNode findLCA(TreeNode root, int B, int C) {
        if (root == null || root.val == B || root.val == C) return root;

        TreeNode left = findLCA(root.left, B, C);
        TreeNode right = findLCA(root.right, B, C);

        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }

    }

}
