package createBSTFromArray;

import java.util.Arrays;

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

public class CreateBST {

    public static Node createBST(int[] arr) {
        Arrays.sort(arr);

        return createBST_(arr, 0, arr.length - 1, null);
    }

    private static Node createBST_(int[] arr, int low, int high, Node root) {
        if (low > high) {
            return root;
        }

        int mid = (low + high) / 2;
        //System.out.println(arr[mid]);
        root = new Node(arr[mid]);

        root.left = createBST_(arr, low, mid - 1, root.left);
        root.right = createBST_(arr, mid + 1, high, root.right);

        return root;

    }
    //print
    public static void printInOrder(Node root){
        if(root==null){
            return;
        }
        printInOrder(root.left);
        System.out.print(root.data+"-->");
        printInOrder(root.right);


    }

    public static void main(String[] args) {
        int[] arr = { 15, 10, 20, 8, 12, 16, 25 };

        // construct a balanced binary search tree
        Node root = createBST(arr);

        // print the keys in an inorder fashion
        printInOrder(root);
    }
}
