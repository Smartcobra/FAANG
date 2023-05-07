package Sum_Binary_Tree_Or_Not;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    public class Sumbinarytreeornot {
        boolean isSumTree = true;

        public int solve(TreeNode A) {
            int sum = sumTree(A);
            return isSumTree ? 1 : 0;

        }

        public int sumTree(TreeNode root) {
            if (root == null) return 0;

            if (root.left == null && root.right == null) {
                return root.val;
            }
            if (!isSumTree) return 0;

            int left = sumTree(root.left);
            int right = sumTree(root.right);

            if (left + right != root.val) isSumTree = false;

            return root.val + left + right;
        }
    }
}
