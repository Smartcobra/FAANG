package postorder;

import create.CreateTree;
import create.Node;

public class PostOrder_Recursive {
    public static void printPostOrder(Node<Integer> root) {
        if (root == null) {
            return;
        }
        printPostOrder(root.left);
        printPostOrder(root.right);
        System.out.print(root.data + "->");
    }

    public static void main(String[] args) {
        Node<Integer> node = CreateTree.buildTree();
        printPostOrder(node);
    }
}

