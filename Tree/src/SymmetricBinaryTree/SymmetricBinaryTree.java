package SymmetricBinaryTree;

//https://www.scaler.com/academy/mentee-dashboard/class/35021/homework/problems/228?navref=cl_tt_nv

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

public class SymmetricBinaryTree {

    public int isSymmetric(TreeNode A) {
        boolean f = isMirror(A, A);
        return f ? 1 : 0;
    }

    public boolean isMirror(TreeNode A1, TreeNode A2) {
        if (A1 == null && A2 == null) return true;
        if (A1 == null || A2 == null) return false;

        boolean left = isMirror(A1.left, A2.right);
        boolean right = isMirror(A1.right, A2.left);

        return (A1.val == A2.val) && left && right;
    }
}
