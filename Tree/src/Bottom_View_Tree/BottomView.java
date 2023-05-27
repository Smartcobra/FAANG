package Bottom_View_Tree;

import create.TreeNode;

import java.util.*;

public class BottomView {

    static class  Tuple
    {
        TreeNode node;
        int lineNumber;
        Tuple(TreeNode _node,int _lineNumber)
        {
            node=_node;
            lineNumber=_lineNumber;
        }
    }
    public static ArrayList<Integer> bottomView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(root, 0));

        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int lineNumber = tuple.lineNumber;

            // if(map.get(lineNumber)==null) //The only change in Top-View is the addition of this condition
            map.put(lineNumber, node.val);

            if (node.left != null)
                queue.offer(new Tuple(node.left, lineNumber - 1));
            if (node.right != null)
                queue.offer(new Tuple(node.right, lineNumber + 1));
        }

        for (Map.Entry<Integer, Integer> iterator : map.entrySet()) {
            ans.add(iterator.getValue());
        }

        return ans;

    }
}
