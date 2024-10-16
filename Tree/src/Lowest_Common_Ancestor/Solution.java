package Lowest_Common_Ancestor;
//https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
public class Solution {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;

        while (cur !=null){
            if(p.val < cur.val && q.val < cur.val){
                cur = cur.left;
            }else if(p.val > cur.val && q.val > cur.val){
                cur = cur.right;
            }else{
                return cur;
            }
        }
        return null;
    }
}
