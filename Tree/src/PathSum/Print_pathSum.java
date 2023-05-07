package PathSum;

import java.util.ArrayList;

public class Print_pathSum {

    ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<Integer> print_Path(TreeNode root, int B) {
        _hasPathSum(root, B);
        return path;
    }

    public boolean _hasPathSum(TreeNode A, int B) {
        if (A == null) return false;

        B = B - A.val;
        path.add(A.val);
        if (A.left == null && A.right == null) {
            return B == 0;
        }
        return _hasPathSum(A.left, B) || _hasPathSum(A.right, B);
    }
}
