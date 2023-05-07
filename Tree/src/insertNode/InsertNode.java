package insertNode;

import create.Node;

import java.util.LinkedList;
import java.util.Queue;

public class InsertNode {

    public static Node<Integer> insertNode(Node<Integer> root, int data) {
        Queue<Node<Integer>> queue = new LinkedList<>();
        queue.add(root);
        Node<Integer> curr = null;

        while (!queue.isEmpty()) {
            curr = queue.poll();

            if (curr != null) {
                if (curr.left != null) {
                    queue.add(curr.left);
                } else {
                    curr.left = new Node<>(data);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                } else {
                    curr.right = new Node<>(data);
                }

            }
        }
        return root;
    }

}
