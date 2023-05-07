package Diameter_Binary_Tree;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }

    public class Diameter_Binary_Tree {
        int diam;
        public int solve(TreeNode A) {
            if (A == null) return 0;
            diam = 0;
            height(A);
            return diam;
        }


        public int height(TreeNode root) {
            if (root == null) return -1;
            int left_height = height(root.left);
            int right_height = height(root.right);
            diam = Math.max(diam, left_height + right_height + 2);
            return Math.max(left_height, right_height) + 1;
        }
    }
}