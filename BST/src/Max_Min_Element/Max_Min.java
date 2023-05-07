package Max_Min_Element;
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

/*
* if you see the above BST the max value will be 17 and it is present in the right most of the tree . To find max no need to go to left
* Similarly we can see that the  min value is present in the left most of the tree. To find mein no need to go right
* */

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

public class Max_Min {
    public static Node findMin(Node root){
        if (root==null){
            return null;
        }
        if(root.left==null){
            return root;
        }
        return findMin(root.left);
    }

    public static Node findMax(Node root){
        if (root==null){
            return null;
        }
        if(root.right==null){
            return root;
        }
        return findMax(root.right);
    }

    public static int findSize(Node root){
        if (root==null){
            return 0;
        }
        int left=findSize(root.left);
        int right=findSize(root.right);
        int size=left+right+1;

        return size;
    }

    public static int findSum(Node root){
        if (root==null){
            return 0;
        }
        int leftSum=findSum(root.left);
        int rightSum=findSum(root.right);
        int sum=leftSum+rightSum+root.data;

        return sum;
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

        Node min = findMin(root);
        System.out.println("min::"+min.data);

        Node max = findMax(root);
        System.out.println("max::"+max.data);

        int size = findSize(root);
        System.out.println("size::"+size);

        int findSum = findSum(root);
        System.out.println("sum::"+findSum);




    }
}


























