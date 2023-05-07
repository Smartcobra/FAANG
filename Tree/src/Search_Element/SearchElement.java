package Search_Element;

import create.CreateTree;
import create.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class SearchElement {
    public static boolean isFind(Node<Integer> root, int data) {
        Queue<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        Node<Integer> curr = null;

        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr.data == data) {
                return true;
            }

            if (curr.left != null) {
                queue.add(curr.left);
            }

            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

        return false;
    }

    public static void main(String[] args) {
        CreateTree ct= new CreateTree();
        Node<Integer> root=ct.buildTree();
        System.out.println(isFind(root,27));
    }
}
