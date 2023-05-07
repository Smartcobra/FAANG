package Left_Side_View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node {
    int data;
    Node left = null;
    Node right = null;

    Node(int data) {
        this.data = data;
    }
}

public class Solution {

    public static List<Integer> leftSideView(Node root) {

        if (root == null) {
            return null;
        }
        //output
        ArrayList<Integer> result = new ArrayList<>();

        ///create a queue
        LinkedList<Node> q = new LinkedList<>();
        q.addLast(root);

        while (q.size() != 0) {
            int size = q.size();
            result.add(q.getFirst().data);
            while (size-- > 0) {
                Node rn = q.removeFirst();// removing the first entered
                if (rn.left != null) {
                    q.addLast(rn.left);
                }
                if (rn.right != null) {
                    q.addLast(rn.right);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(7);
        root.left.right = new Node(8);
        root.right.right = new Node(15);
        root.right.left = new Node(12);
        root.right.right.left = new Node(14);

        List<Integer> integers = leftSideView(root);
        System.out.println(integers);
    }
}
