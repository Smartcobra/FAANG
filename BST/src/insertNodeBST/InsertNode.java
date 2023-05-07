package insertNodeBST;

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

public class InsertNode {
    public static Node insertNode(Node node, int data) {
        if (node == null) {
            return new Node(data);
        }
        if (node.data > data) {
            node.left = insertNode(node.left, data);
        } else if (node.data < data) {
            node.right = insertNode(node.right, data);
        }
        return node;
    }

    public static void printPreOrder(Node root){
        if(root==null){
            return;
        }

        printPreOrder(root.left);
        System.out.print(root.data +"->");
        printPreOrder(root.right);
    }

    public static void main(String[] args) {
        /*
         *             10
         *          /      \
         *         6        14
         *       /   \     /  \
         *      4     7   12   15
         *    /     /  \     \    \
         *  1     5     9     13  17
         *
         *
         * */
        Node root = new Node(10);
        root.left = new Node(6);
        root.left.left = new Node(4);
        root.left.left.left = new Node(1);
        root.left.right = new Node(7);
        root.left.right.left = new Node(5);
        root.left.right.right = new Node(9);

        root.right = new Node(14);
        root.right.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right = new Node(15);
        root.right.right.right = new Node(17);

        insertNode(root,3);
        printPreOrder(root);
    }
}
