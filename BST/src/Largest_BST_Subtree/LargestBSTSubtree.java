package Largest_BST_Subtree;

///https://www.scaler.com/academy/mentee-dashboard/class/35019/assignment/problems/4857/?navref=cl_pb_nv_tb


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
    public class LargestBSTSubtree {
        public int solve(TreeNode root) {
            int start = Integer.MIN_VALUE;
            int end = Integer.MAX_VALUE;

            if (isBST(root, start, end)) {
                return countSize(root);
            }
            return Math.max(solve(root.left), solve(root.right));

        }

        public boolean isBST(TreeNode root, int start, int end) {
            if (root == null) return true;

            if (root.val >= start && root.val <= end) {
                boolean left = isBST(root.left, start, root.val - 1);
                boolean right = isBST(root.right, root.val + 1, end);

                return left && right;
            }
            return false;
        }

        public int countSize(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return 1 + countSize(root.left) + countSize(root.right);
        }
    }
