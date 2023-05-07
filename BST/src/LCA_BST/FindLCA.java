package LCA_BST;

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

/*
 *  The main trick is here the LCA will be must between a and b.
 * */

public class FindLCA {
    public static Node getLCA(Node root, int a, int b) {
        if (root == null) {
            return null;
        }
        if (root.data == a || root.data == b) {
            return root;
        }

        if (a < root.data && b < root.data) {
           return getLCA(root.left, a, b);
        } else if (a > root.data && b > root.data) {
           return getLCA(root.right, a, b);
        } else {
            return root;
        }

    }

    public static void main(String[] args) {
        /*
         *             10
         *          /      \
         *         6        14
         *       /   \     /  \
         *      4     7   12   15
         *    /     /  \     \    \
         *  3     5     9     13  17
         *
         *
         * */

        Node root = new Node(10);
        root.left = new Node(6);
        root.left.left = new Node(4);
        root.left.left.left = new Node(3);
        root.left.right = new Node(7);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(9);

        root.right = new Node(14);
        root.right.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right = new Node(15);
        root.right.right.right = new Node(17);
        Node lca = getLCA(root, 5, 9);
        System.out.println(lca.data);


    }
}
