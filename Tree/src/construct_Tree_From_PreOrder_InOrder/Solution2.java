package construct_Tree_From_PreOrder_InOrder;

import create.TreeNode;

///https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
public class Solution2 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int psi = 0;
        int pei = preorder.length - 1;
        int isi = 0;
        int iei = inorder.length - 1;

        return buildTreeHelper(preorder, psi, pei, inorder, isi, iei);
    }

    public TreeNode buildTreeHelper(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei) {
        if (psi > pei || isi > iei) {
            return null;
        }

        int root_data = preorder[psi];
        TreeNode root = new TreeNode(root_data);

        int idx = isi;
        while (root_data != inorder[idx]) {
            idx++;
        }
        int len_left_subtree = idx - isi;


        root.left = buildTreeHelper(preorder, psi + 1, psi + len_left_subtree, inorder, isi, idx - 1);
        root.right = buildTreeHelper(preorder, psi + 1 + len_left_subtree, pei, inorder, idx + 1, iei);

        return root;


    }


}

