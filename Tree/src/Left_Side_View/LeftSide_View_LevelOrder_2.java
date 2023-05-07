package Left_Side_View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftSide_View_LevelOrder_2 {
    public ArrayList<Integer> solve(Node root) {
        ArrayList<Integer> tmp = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (q.size() > 1) {
            Node f = q.poll();
            if (f == null) {
                q.add(null);
                result.add(tmp.get(0));
                tmp = new ArrayList<>();
            } else {
                tmp.add(f.data);
                if (f.left != null) {
                    q.add(f.left);
                }

                if (f.right != null) {
                    q.add(f.right);
                }
            }
        }
        result.add(tmp.get(0));
        return result;

    }
}
