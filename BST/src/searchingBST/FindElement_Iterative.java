package searchingBST;

public class FindElement_Iterative {
    public static boolean isPresent_Iterative(Node root, int data) {

        if (root == null) {
            return false;
        }
        while (root != null) {
            if (root.data == data) {
                return true;
            }
            if (root.data > data) {
                root = root.left;
            }
            if (root.data < data) {
                root = root.right;
            }
        }


        return false;
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

        int data = 4;

        if (isPresent_Iterative(root, data))
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
