package Invert_Binary_Tree;

import create.TreeNode;

//https://leetcode.com/problems/invert-binary-tree/description/
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        invertTree(root.left);
        invertTree(root.right);

        return root;

    }

}
