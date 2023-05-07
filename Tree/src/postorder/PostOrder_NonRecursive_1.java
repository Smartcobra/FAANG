package postorder;

import create.CreateTree;
import create.Node;

import java.util.List;
import java.util.Stack;

public class PostOrder_NonRecursive_1 {
    public static boolean isLeaf(Node<Integer> root) {
        if (root.right == null && root.left == null) {
            return true;
        }
        return false;
    }

    public static void print_postOrder1(Node<Integer> root) {
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            Node curr = stack.peek();

            if (isLeaf(curr)) {
                Node node = stack.pop();
                System.out.print(node.data +"->");
            } else {
                if (curr.right != null) {
                    stack.push(curr.right);
                    curr.right = null;
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                    curr.left = null;
                }
            }
        }

    }

    public static void main(String[] args) {
        Node<Integer> node = CreateTree.buildTree();
                print_postOrder1(node);
    }
}
