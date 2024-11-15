package Maximum_Depth_of_Binary_Tree;

import create.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
//https://leetcode.com/problems/maximum-depth-of-binary-tree/
public class BFS_Solution {

    public int maxDepth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        if (root == null) return 0;

        int level = 0;
        q.offer(root);
        while (q.size() > 0) {
            for (int i = 0; i < q.size(); i++) {
                TreeNode tr = q.poll();
                if (tr.left != null) {
                    q.offer(tr.left);
                }

                if (tr.right != null) {
                    q.offer(tr.right);
                }
            }
            level++;
        }

        return level;
    }
}
