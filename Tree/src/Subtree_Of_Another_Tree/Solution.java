package Subtree_Of_Another_Tree;

import create.TreeNode;

//https://leetcode.com/problems/subtree-of-another-tree/
public class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root==null){
            return  subRoot==null;
        }
        if(isSameTree(root,subRoot)) return true;

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);

    }

    public boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;

        if(root1.val != root2.val) return false;

        return (isSameTree(root1.left,root2.left) && isSameTree(root1.right,root2.right));


    }
}
