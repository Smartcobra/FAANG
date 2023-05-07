package Maximum_Element;

import create.CreateTree;
import create.Node;

import java.util.ArrayDeque;
import java.util.Queue;

//using level order
public class FindMaxElement_NonRecursive {
    public static int getMaxElement(Node<Integer> root) {
        int max = Integer.MIN_VALUE;
        if (root == null) {
            return max;
        }
        Queue<Node<Integer>> queue = new ArrayDeque<>();
        queue.add(root);
        Node<Integer> curr = null;

        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (curr.data > max) {
                max = curr.data;
            }
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }


        }
        return max;
    }

    public static void main(String[] args) {
        CreateTree ct= new CreateTree();
        Node<Integer> root=ct.buildTree();
        System.out.println(getMaxElement(root));
    }


}
