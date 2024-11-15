package Kth_Smallest_Element_In_BST;

import create.TreeNode;

class Solution {
    int result =-1;
    int count =0;
    public int kthSmallest(TreeNode root, int k) {
        inorder(root,k);
        return result;
    }

    public void inorder(TreeNode root, int k) {
        if(root==null) return;
        inorder(root.left,k);
        count++;

        if(count==k){
            result=root.val;
            return;
        }

        inorder(root.right,k);

    }


}