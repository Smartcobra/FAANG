package Top_View_of_Binary_Tree;


import java.util.ArrayList;
import java.util.HashMap;
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

class LevelNode {
    TreeNode node;
    int level;

    public LevelNode(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
public class TOP_View_Scalar {
    public ArrayList<Integer> solve(TreeNode root) {
        HashMap<Integer, ArrayList<TreeNode>> map = new HashMap<>();
        Queue<LevelNode> q = new LinkedList<>();
        q.add(new LevelNode(root, 0));
        ArrayList<Integer> output = new ArrayList<>();
        int minLevel = 1;
        int maxLevel = -1;


        while (!q.isEmpty()) {
            LevelNode ln = q.remove();
            TreeNode node = ln.node;
            int level = ln.level;

            minLevel = Math.min(minLevel, level);
            maxLevel = Math.max(maxLevel, level);

            if (map.containsKey(level)) {
                ArrayList<TreeNode> tmp = map.get(level);
                tmp.add(node);
                map.put(level, tmp);
            } else {
                ArrayList<TreeNode> tmp = new ArrayList<>();
                tmp.add(node);
                map.put(level,tmp);
            }

            if (node.left != null) {
                q.add(new LevelNode(node.left, level - 1));
            }

            if (node.right != null) {
                q.add(new LevelNode(node.right, level + 1));
            }
        }

        output.add(root.val);

        for (int i = -1; i >= minLevel; i--) {
            ArrayList<TreeNode> tmp = map.get(i);
            output.add(tmp.get(0).val);
        }

        for (int i = 1; i <= maxLevel; i++) {
            ArrayList<TreeNode> tmp = map.get(i);
            output.add(tmp.get(0).val);
        }
        return output;

    }
}