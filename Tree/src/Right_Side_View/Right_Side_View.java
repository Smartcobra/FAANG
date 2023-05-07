package Right_Side_View;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Node {
    int val;
    Node left = null;
    Node right = null;

    Node(int val) {
        this.val = val;
    }
}

public class Right_Side_View {
    public static List<Integer> rightSideView(Node root) {

        //queue
        LinkedList<Node> q = new LinkedList();
        //output
        ArrayList<Integer> result = new ArrayList<>();
        q.addFirst(root);

        while (!q.isEmpty()) {
            int size = q.size();
            result.add(q.getFirst().val);
            while (size-- > 0) {
                Node rn = q.removeFirst();

                if (rn.right != null) q.addLast(rn.right);
                if (rn.left != null) q.addLast(rn.left);
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

        List<Integer> integers = rightSideView(root);
        System.out.println(integers);


    }

}
