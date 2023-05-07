package Odd_And_Even_Levels;

import java.util.LinkedList;
import java.util.Queue;

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

public class OddAndEvenLevels {
///https://www.scaler.com/academy/mentee-dashboard/class/35018/homework/problems/4677/?navref=cl_pb_nv_tb
    public int solve(TreeNode A) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(A);

        int evenSum = 0;
        int oddSum = 0;
        int level = 0;


        while (!q.isEmpty()) {
            int size = q.size();
            level++;

            while (size > 0) {
                TreeNode temp = q.remove();

                if (level % 2 == 0)
                    evenSum += temp.val;
                else
                    oddSum += temp.val;

                if (temp.left != null)
                    q.add(temp.left);
                if (temp.right != null)
                    q.add(temp.right);

                size--;
            }
        }
        return (oddSum - evenSum);
    }

}
