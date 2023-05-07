package deletingNode;

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

public class DeleteNodeBST {
    public static Node removeNode(Node node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = removeNode(node.left, data);
        } else if (data > node.data) {
            node.right = removeNode(node.right, data);
        } else {
            if (node.left != null && node.right != null) {
                int max = findMax(node.left);
                node.data = max;
                node.left = removeNode(node.left, max);
                return node;
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }


//    public static Node findMax(Node node) {
//        if (node == null) {
//            return null;
//        }
//        if (node.right == null) {
//            return node;
//        }
//        return findMax(node.right);
//    }

    public static int findMax(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.right == null) {
            return node.data;
        }
        return findMax(node.right);
    }

    public static void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + "->");
        inorder(node.right);
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
        removeNode(root, 3);
        inorder(root);

    }
}
