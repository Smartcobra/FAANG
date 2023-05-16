package PathSum;


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

///https://leetcode.com/problems/path-sum/
///https://www.scaler.com/academy/mentee-dashboard/class/35021/homework/problems/234/?navref=cl_pb_nv_tb
public class PathSum_K {

    public int hasPathSum(TreeNode A, int B) {
        boolean f = _hasPathSum(A, B);
        return f ? 1 : 0;
    }

    public boolean _hasPathSum(TreeNode A, int B) {
        if (A == null) return false;
        B = B - A.val;
        if (A.left == null && A.right == null) {
            return B == 0;
        }
        return _hasPathSum(A.left, B) || _hasPathSum(A.right, B);
    }
}
