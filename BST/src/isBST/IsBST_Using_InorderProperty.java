package isBST;

public class IsBST_Using_InorderProperty {
    public static Node prev = null;

    public static boolean isValidBST(Node root) {
        if (root == null) {
            return true;
        }
        //check is bst to left
        if (!isValidBST(root.left)) {
            return false;
        }
        //inorder property
        if (prev != null && prev.data > root.data) {
            return false;
        }
        prev = root;
        //check right is bst
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        /*
         *             4
         *          /      \
         *         2        7
         *       /         /  \
         *      1         3    8
         *
         *
         *
         *
         * */

//        Node root = new Node(4);
//        root.left = new Node(2);
//        root.left.left = new Node(1);
//
//        root.right = new Node(7);
//        root.right.left = new Node(3);
//        root.right.right = new Node(8);

        /*
        *
        *
        *
        *
        *
        *
        * */
//        Node root = new Node(8);
//        root.left= new Node(3);
//        root.left.left= new Node(1);
//        root.left.right=new Node(6);
//        root.left.right.left=new Node(4);
//        root.left.right.right=new Node(7);
//
//        root.right= new Node(10);
//        root.right.right= new Node(14);
//        root.right.right.left= new Node(13);


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
        root.left.right = new Node(7);
        root.left.left.left = new Node(3);

//        root.left.right.left = new Node(5);
        root.left.right.right = new Node(9);

        root.right = new Node(14);
        root.right.left = new Node(12);
        root.right.left.right = new Node(13);
        root.right.right = new Node(15);
        root.right.right.right = new Node(17);


        System.out.println(isValidBST(root));

    }

}
