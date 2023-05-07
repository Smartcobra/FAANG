package Max_Min_Element;

public class Max_Min_iterative {
    public static Node findMin_Iterative(Node root) {

        if (root == null) {
            return null;
        }

        while (root.left != null) {
            root= root.left;
        }

        return root;
    }

    public static Node findMax_Iterative(Node root) {
        if (root == null) {
            return null;
        }

        while (root.right != null) {
            root= root.right;
        }
        return root;
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

        Node min = findMin_Iterative(root);
        System.out.println("min::" + min.data);

        Node max = findMax_Iterative(root);
        System.out.println("max::" + max.data);

//        int size = findSize(root);
//        System.out.println("size::" + size);
//
//        int findSum = findSum(root);
//        System.out.println("sum::" + findSum);


    }
}
