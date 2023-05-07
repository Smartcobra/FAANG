package Height_Of_BinaryTree;

import create.CreateTree;
import create.Node;

import java.util.ArrayDeque;
import java.util.Queue;

public class HeightOfBinaryTree {
    public static int getHeight(Node<Integer> root) {
        Queue<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root);

        Node<Integer> curr = null;

        int height = 0;
        int size = 0;
        while (!queue.isEmpty()) {
            height++;
            size = queue.size();

            while (size > 0) {
                --size;
                curr = queue.poll();
                if (curr.left != null) {
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
        }
        return height;
    }
    public static void main(String[] args) {
        CreateTree ct= new CreateTree();
        Node<Integer> root=ct.buildTree();
        System.out.println(getHeight(root));
    }
}
