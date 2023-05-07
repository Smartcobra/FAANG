package Balanced_Binary_Tree;

import create.Node;

public class Balanced_Binary_Tree {
    public int isBalanced(Node<Integer> root) {
        if (isBalanced_Helper(root)) return 1;
        return 0;
    }

    public boolean isBalanced_Helper(Node<Integer> root) {
        if (root == null) return true;
        boolean left = isBalanced_Helper(root.left);
        boolean right = isBalanced_Helper(root.right);
        boolean balanced = Math.abs(height(root.left) - height(root.right)) <= 1;
        return balanced && left && right;
    }


    private int height(Node<Integer> root) {
        if (root == null) {
            return -1;
        }
        int height_left = height(root.left);
        int height_root = height(root.right);
        return 1 + Math.max(height_left, height_root);
    }
}
