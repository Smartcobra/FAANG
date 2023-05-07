package Recover_Binary_Search_Tree;

import java.util.ArrayList;

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

public class Morris_Traversal {
    public static ArrayList<Integer> morrisInorder(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                result.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }
                //if null give connection
                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {   //disconnect
                    prev.right = null;
                    result.add(curr.val);
                    curr = curr.right;
                }
            }
        }
        return result;
    }

    public static void print_InOrder(TreeNode node) {
        if (node == null) {
            return;
        }

        print_InOrder(node.left);
        System.out.print(node.val + "->");
        print_InOrder(node.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(25);
        root.left.left.left = new TreeNode(1);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(9);
        root.right.left = new TreeNode(20);
        root.right.right = new TreeNode(30);
        root.right.right.left = new TreeNode(28);
        root.right.right.right = new TreeNode(35);

        System.out.println(morrisInorder(root));
        print_InOrder(root);


    }
}
