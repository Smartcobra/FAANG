package Right_Side_View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RightSideView_Using_Level_Order_2 {
    public static ArrayList<Integer> solve(Node root) {
        ArrayList<Integer> tmp = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while (q.size() > 1) {
            Node f = q.poll();
            // TREENODE.TreeNode f = q.remove();

            if (f == null) {
                q.add(null);
                //  System.out.println();
                result.add(tmp.get(0));
                tmp = new ArrayList<>();

            } else {
                // System.out.print(f.val + " ");
                tmp.add(f.val);
                if (f.right != null) {
                    q.add(f.right);
                }
                if (f.left != null) {
                    q.add(f.left);
                }
            }
        }
        result.add(tmp.get(0));
        //  System.out.println(tmp.toString());
        return result;
    }

    public static void main(String[] args) {
//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.left.left = new Node(4);
//        root.left.right = new Node(5);
//        root.left.left.left = new Node(8);
//        root.right.left = new Node(6);
//        root.right.right = new Node(7);

//        Node root = new Node(1);
//        root.left = new Node(2);
//        root.right = new Node(3);
//        root.right.left = new Node(4);
//        root.right.left.right = new Node(5);

        Node root = new Node(7);
        root.left = new Node(1);
        root.right = new Node(15);
        root.left.left = new Node(2);
        //  root.right.left.right = new Node(5);

        // 7 1 15 2

        System.out.println(solve(root));


    }
}
