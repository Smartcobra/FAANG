package isBST;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class IsBST {

    public static boolean isBST(Node root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && findMax(root.left) > root.data) {
            return false;
        }
        if (root.right != null && findMin(root.right) > root.data) {
            return false;
        }

        return !isBST(root.left) && !isBST(root.right);
    }

    private static int findMin(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null) {
            return node.data;
        }
        return findMin(node.left);
    }

    private static int findMax(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.right == null) {
            return node.data;
        }
        return findMax(node.right);
    }
}
