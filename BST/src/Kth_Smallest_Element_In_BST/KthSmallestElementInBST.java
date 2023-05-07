package Kth_Smallest_Element_In_BST;

import java.util.ArrayList;

public class KthSmallestElementInBST {

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

    public class Solution {
        public int kthsmallest(TreeNode A, int B) {
            ArrayList<Integer> inorder = inorder(A);
            for (int i = 0; i < inorder.size(); i++) {
                if (i == B - 1) return inorder.get(i);
            }

            return -1;
        }

        public ArrayList<Integer> inorder(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            TreeNode cur = root;

            while (cur != null) {
                if (cur.left == null) {
                    result.add(cur.val);
                    cur = cur.right;
                } else {
                    TreeNode prev = cur.left;

                    while (prev.right != null && prev.right != cur) {
                        prev = prev.right;
                    }

                    if (prev.right == null) {
                        prev.right = cur;
                        cur = cur.left;
                    } else {
                        prev.right = null;
                        result.add(cur.val);
                        cur = cur.right;
                    }
                }
            }
            return result;
        }
    }
}