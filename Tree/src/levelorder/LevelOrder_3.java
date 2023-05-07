package levelorder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder_3 {

    public static ArrayList<ArrayList<Integer>> levelOrder(Node A) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        ArrayList<Integer> tmp = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(A);
        q.add(null);

        while (q.size() > 1) {
            Node f = q.poll();

            if (f == null) {
                q.add(null);
                output.add(tmp);
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
        output.add(tmp);
        return output;
    }

    public static void main(String[] args) {
        Node root = new Node(15);
        root.left = new Node(10);
        root.right = new Node(20);
        root.left.left = new Node(8);
        root.left.right = new Node(12);
        root.right.left = new Node(16);
        root.right.right = new Node(25);

        levelOrder(root);
    }
}
