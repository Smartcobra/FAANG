package ZigZag_Level_Order_Traversal_BT;

import create.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class ZigZagLevelOrderTraversalBT_Arraylist {
    public static ArrayList<ArrayList<Integer>> zigzagOrder(Node<Integer> root) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<>();
        Queue<Node<Integer>> q = new LinkedList<>();
        q.add(root);
        boolean even = true;

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> sublist = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node<Integer> top = q.poll();

                if (top.left != null) {
                    q.add(top.left);
                }

                if (top.right != null) {
                    q.add(top.right);
                }

                if (even) {
                    sublist.add(top.data);
                } else {
                    sublist.add(0,top.data);
                }
            }
            output.add(sublist);
            even = !even;

        }
        System.out.println(output);

        return output;
    }

    public static void main(String[] args) {
        Node<Integer> root = new Node<>(15);
        root.left = new Node<>(10);
        root.right = new Node<>(20);
        root.left.left = new Node<>(8);
        root.left.right = new Node<>(12);
        root.right.left = new Node<>(16);
        root.right.right = new Node<>(25);

        zigzagOrder(root);
    }
}
