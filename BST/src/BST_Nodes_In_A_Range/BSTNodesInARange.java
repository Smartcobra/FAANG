package BST_Nodes_In_A_Range;

///https://www.scaler.com/academy/mentee-dashboard/class/35019/homework/problems/4679/?navref=cl_pb_nv_tb
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

public class BSTNodesInARange {
    public int solve(TreeNode A, int B, int C) {
        if (A == null) return 0;

        if (A.val >= B && A.val <= C) {
            return 1 + solve(A.left, B, C) + solve(A.right, B, C);
        } else if (A.val < B) {
            return solve(A.right, B, C);
        } else {
            return solve(A.left, B, C);
        }
    }
}


